<%@page import="com.forum.biz.impl.MessagesBizImpl"%>
<%@page import="com.forum.biz.MessagesBiz"%>
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
  	
  <link rel="stylesheet" href="css/scanMsg.css" type="text/css"></link>
  </head>
<%
	String title= request.getParameter("title");
	String sendName = request.getParameter("senderName");
	String sendtime = request.getParameter("sendtime");
	String content = request.getParameter("content");
	int senderId = Integer.parseInt(request.getParameter("senderId"));
	boolean isread =Boolean.parseBoolean(request.getParameter("isread"));
	if(isread==false){
	//将邮件变成已读
		int id = Integer.parseInt(request.getParameter("id"));
		MessagesBiz messagesBiz = new MessagesBizImpl();
		int num=messagesBiz.updateMsg(id);
		if(num>0){
			int count =(Integer)(request.getSession().getAttribute("count"));
			System.out.println("count++++++++++"+count);
			count--;
			System.out.println("count----------"+count);
			session.setAttribute("count", count);
		}
	}
	
	
	
	request.setAttribute("senderId", senderId);
	request.setAttribute("title",title);
	request.setAttribute("sendName",sendName);
	request.setAttribute("sendtime",sendtime);
	request.setAttribute("content",content);
 %>
  
  <body>
  	<div id="main">
    	<%@ include file="shared/header.jsp" %>
    	
    	<div id="addTopic_content">
    		<form action="" method="get">
	    		<table style="text-align: center;">
	    			<tr><th colspan="2">浏览邮件</th></tr>
		    		<tr><td width="20%">标题：</td><td width="80%">${title}</td></tr>
		    		<tr><td width="20%">发件人：</td><td width="80%">${sendName }</td></tr>
		    		
		    		<tr><td width="20%">发件时间：</td><td width="80%">${sendtime }</td></tr>
		    		<tr><td width="20%" height="110px">内容：</td><td width="80%">${content }</td></tr>
			    	<tr>
			    		<td width="20%"></td>
			    		<td width="80%" style="text-align: left;">
			    			<a href="addmsg.jsp?title=${title }&receiverName=${sendName}&receiverId=${senderId}">回复邮件</a>
			    		</td>
			    	</tr>
			    </table>
			</form>
    	</div>
    	
    	<%@ include file="shared/footer.jsp" %>
    
    </div>
    
  </body>
</html>
