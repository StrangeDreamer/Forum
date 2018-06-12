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
  	<link rel="stylesheet" href="xheditor/demos/common.css" type="text/css" media="screen" />
	<script type="text/javascript" src="xheditor/jquery/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="xheditor/xheditor-1.2.1.min.js"></script>
	<script type="text/javascript" src="xheditor/xheditor_lang/zh-cn.js"></script>
  	
  </head>
  
  <body>
  	<div id="main">
    	<%@ include file="shared/header.jsp" %>
    	
    	<div id="addTopic_content">
    		<form action="AddTopicServlet" method="get">
	    		<table style="border-collapse:separate; border-spacing:15px;">
		    		<tr><td>主题：</td><td><input style="width: 420px" type="text" name="title"/></td></tr>
		    		<tr><td>时间：</td><td><input style="width: 420px" type="date" name="date"/></td></tr>
			    	<tr><td >内容：</td><td ><textarea style="width: 420px;height: 120px" rows="5" cols="50" name="content"  class="xheditor-simple"></textarea></td></tr>
			    	<tr><td></td><td style="text-align: left;"> <input type="submit" value="提交"/></td></tr>
			    </table>
			</form>
    	</div>
    	
    	<%@ include file="shared/footer.jsp" %>
    
    </div>
    
  </body>
</html>
