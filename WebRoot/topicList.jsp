<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>topicList</title>
	
	
  <link rel="stylesheet" href="css/model.css" type="text/css"></link>
  <link rel="stylesheet" href="css/topicList.css" type="text/css"></link>
  </head>
  
  <body>
    <div id="main">
    	<%@ include file="shared/header.jsp" %>
    	
    	<div id="topicList_content">
    		
	    		<table style="text-align:center">
	    			<tr><th width="60%">主题</th><th width="20%">发表用户</th><th width="20%">发表时间</th></tr>
	    			<c:forEach var="topic" items="${topics }" varStatus="status">
		    			<tr>
		    				<td width="60%" height="60px"><a href="GetTopicInformationServlet?topicId=${topic.id }">${topic.title }</a></td>
		    				<td width="20%">${users[status.index].username }</td>
		    				<td width="20%">${topic.date }</td>
		    			</tr>
	    			</c:forEach>
	    		</table>
    			<c:if test="${pageNo>1 }">	
    				<a href="GetTopicByPageServlet?pageNo=${pageNo-1 }">上一页</a>
    			</c:if>
    			<c:if test="${pageNo<pageCount }">
	    			<a href="GetTopicByPageServlet?pageNo=${pageNo+1 }">下一页</a>
	    		</c:if>
	    	
	    			&nbsp;共${pageCount }页，第${pageNo }页。
    	</div>
    	
    	<%@ include file="shared/footer.jsp" %>
    
    </div>
  </body>
</html>
