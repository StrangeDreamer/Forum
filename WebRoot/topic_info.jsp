<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>topic</title>
   	<link rel="stylesheet" href="css/model.css" type="text/css"></link>

  	<link rel="stylesheet" href="css/topic_info.css" type="text/css"></link>
  </head>
  
  <body>
	<div id="topic_main">
	   	<%@ include file="shared/header.jsp" %>
	   	
	   	<div id="topic_content">
	   		<c:if test="${pageNo==1 }">
	   			<table style="text-align: center;">
		    			<tr>
		    				<td width="20%" height="20px">名称:${user.username }
		    					<c:if test="${sessionScope.user!=null&&sessionScope.user.username!=user.username}">
		    					<a href="addmsg.jsp?title=${topic.title }&receiverName=${user.username}
		    						&receiverId=${user.id}">
		    						<img src="images/unReaded.png" style="width: 20px;height: 20px"/>
		    					</a> 
		    					</c:if>
		    				</td>
		    				<td width="80%" style="text-align: left;
		    				border:1px solid #FFFFFF;background-color: #D1D1D1">
		    						${topic.title }&nbsp;${topic.date }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td width="20%" height="100px"><img style="width: 100px;height: 100px" src="images/${user.id }.gif" /></td>
		    				<td width="80%" style="border:1px solid #FFFFFF;text-align: left;">${topic.content }</td>
		    			</tr>
		    			<tr>
		    				<td width="20%" height="20px">
		    					
		    				</td>
		    				<td width="80%" style="text-align: left;border:1px solid #FFFFFF;background-color: #B0E2FF">127.0.0.1</td>
		    			</tr>
	    		</table>
	    	</c:if>	
	   
	   		<!--用c:foreach循环输出  -->
	   		<c:forEach var="information" items="${informations }" varStatus="status">
	    		<table style="text-align: center;">
		    			<tr>
		    				<td width="20%" height="20px">名称:${users[status.index].username }
		    				<c:if test="${sessionScope.user!=null&&sessionScope.user.username!=users[status.index].username}">
		    					<a href="addmsg.jsp?title=${topic.title }&receiverName=${users[status.index].username}
		    						&receiverId=${users[status.index].id}">
		    						<img src="images/unReaded.png" style="width: 20px;height: 20px"/>
		    					</a> 
		    				</c:if>
		    				<c:if test="${sessionScope.user==null}"> 
		    				</c:if>
		    				</td>
		    				<td width="80%" style="text-align: left;border:1px solid #FFFFFF;background-color: #D1D1D1">2017-7-5</td>
		    			</tr>

		    			<tr>
		    				<td width="20%" height="100px"><img style="width: 100px;height: 100px" src="images/${information.userId }.gif" /></td>
		    				<td width="80%" style="border:1px solid #FFFFFF;text-align: left;">${information.content }</td>
		    			</tr>
		    			
		    			<tr>
		    			<c:choose>
			                <c:when test="${sessionScope.user.username==users[status.index].username}">
			    				<td width="20%" height="20px">
			    					<a href="DeleteInfoServlet?id=${information.id }
			    					&pageNo=${pageNo }&topicId=${topicId }">删除</a>
			    				</td>
			    			</c:when>
			
			                <c:otherwise>
			                	<td width="20%" height="20px">
		                	</c:otherwise>
	                    </c:choose>
		    			
		    				<td width="80%" style="text-align: left;border:1px solid #FFFFFF;background-color: #B0E2FF">127.0.0.1</td>
		    			</tr>
	    		</table>

	    		<div style="height: 10px"></div>
	    	</c:forEach>
	    	<c:if test="${pageNo>1 }">	
   				<a href="GetTopicInformationServlet?pageNo=${pageNo-1 }&topicId=${topicId }">上一页</a>
   			</c:if>
   			<c:if test="${pageNo<pageCount }">
    			<a href="GetTopicInformationServlet?pageNo=${pageNo+1 }&topicId=${topicId }">下一页</a>
    		</c:if>
    			&nbsp;共${pageCount }页，第${pageNo }页。
    			
	    	
	    	<c:if test="${sessionScope.user!=null }">
	    		<form action="AddTopicInfoServlet" method="get">
	    			<input type="hidden" name="topicId" value="${topicId }"/>
	    			<input type="hidden" name="userId" value="${sessionScope.user.id }"/>
			    	<div id="reply_box">
			    		
			    		<div >
			    			<textarea rows="10" cols="20" name="content"></textarea>
			    		</div>
			    		<input type="submit" value="回复">
			    	</div>
			    </form>
		    </c:if>
	   	</div>
	   	
	   	<%@ include file="shared/footer.jsp" %>
  	</div>
  </body>
</html>
