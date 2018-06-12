<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>发表主题</title>
    <link rel="stylesheet" href="css/model.css" type="text/css"></link>
  	
  	<link rel="stylesheet" href="css/receiveMail.css" type="text/css"></link>
  </head>
 
  <body>
  	<div id="main">
    	<%@ include file="shared/header.jsp" %>
    	
    	<div id="receiveMail_content">
    		
	    		<table>
	    			<tr><th colspan="4">我的收件箱</th></tr>
	    			<tr><th width="50%">邮件列表</th><th width="20%">发件人</th><th width="20%">发件时间</th><th width="10%">删除</th></tr>
		    		<c:forEach var="message" items="${messages }" varStatus="status">	
			    		<tr>
			    			<td>
			    				<a href="scanMsg.jsp?title=${message.title}&senderName=${users[status.index].username}
			    					&senderId=${users[status.index].id}&sendtime=${message.sendtime}&content=${message.content}
			    					&isread=${message.isread}&id=${message.id}">
				    				<c:if test="${message.isread==false}">
				    					<img alt="" src="images/unReaded.png"/>
				    				</c:if>
				    				<c:if test="${message.isread==true}">
				    					<img alt="" src="images/readed.png"/>
				    				</c:if>
			    					${message.title }
			    				</a>
			    			</td>
			    			<td>${users[status.index].username }</td>
			    			<td>${message.sendtime }</td>
			    			<td><a href="">删除</a></td>
			    		</tr>
		    		</c:forEach>

			    </table>
			
    	</div>
    	
    	<%@ include file="shared/footer.jsp" %>
    
    </div>
    
  </body>
</html>
