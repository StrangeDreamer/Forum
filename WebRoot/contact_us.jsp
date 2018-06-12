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
  	<link rel="stylesheet" href="css/addTopic.css" type="text/css"></link>
  </head>
  
  <body>
  	<div id="main">
    	<%@ include file="shared/header.jsp" %>
    	
    	<div id="addTopic_content">
    		<p style="margin-top: 100px">关于我们</p>
    		<p>论坛编写--小组成员</p>
    		<p>徐超，王锦</p>
    		<p>张刘倩，曹阳</p>
    		<p>&nbsp;</p>
    		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			--广州蓝鸥java105室
    		</p>
    	</div>
    	
    	<%@ include file="shared/footer.jsp" %>
    
    </div>
    
  </body>
</html>
