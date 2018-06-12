<%@page import="com.forum.biz.impl.UserBizImpl"%>
<%@page import="com.forum.biz.UserBiz"%>
<%@page import="com.forum.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <head>
    <title>编写邮件</title>
    <link rel="stylesheet" href="css/model.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/addTopic.css" type="text/css"></link>
  	<link rel="stylesheet" href="xheditor/demos/common.css" type="text/css" media="screen" />
	<script type="text/javascript" src="xheditor/jquery/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="xheditor/xheditor-1.2.1.min.js"></script>
	<script type="text/javascript" src="xheditor/xheditor_lang/zh-cn.js"></script>
  	
  </head>
  
  <body>
  
  <%
  		String title = request.getParameter("title");
  		String receiverName = request.getParameter("receiverName");
  		int receiverId = Integer.parseInt(request.getParameter("receiverId"));
  		
  		request.setAttribute("receiverId",receiverId);
  		request.setAttribute("title", title);
  		request.setAttribute("receiverName", receiverName);
   %>
  
  	<div id="main">
    	<%@ include file="shared/header.jsp" %>
    	<div id="addTopic_content">
    		<form action="AddMsgServlet" method="get">
	    		<table style="border-collapse:separate; border-spacing:15px;">
		    		<tr><td>标题：</td><td><input style="width:420px " type="text" name="title" value="${title }"/></td></tr>
		    		<tr><td>收件人：</td><td><input style="width:420px " type="text" readonly value="${receiverName }"/ >
		    	    <input type="hidden" name="receiverid" value="${receiverId }"/ >
		    		
		    		</td></tr>
			    	<tr><td>内容：</td><td><textarea style="width: 420px;height: 120px" rows="5" cols="50" name="content"  class="xheditor-simple"></textarea></td></tr>
			    	<tr><td colspan="2" style="text-align: center"><input type="submit" value="回复"/></td></tr>
			    </table>
			</form>
    	</div>
    	
    	<%@ include file="shared/footer.jsp" %>
    
    </div>
    
  </body>
</html>
