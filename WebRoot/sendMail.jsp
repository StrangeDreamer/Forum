<%@page import="com.forum.biz.impl.UserBizImpl"%>
<%@page import="com.forum.biz.UserBiz"%>
<%@page import="com.forum.entity.Messages"%>
<%@page import="com.forum.biz.impl.MessagesBizImpl"%>
<%@page import="com.forum.biz.MessagesBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>发件箱</title>
<link rel="stylesheet" href="css/model.css" type="text/css"></link>

<link rel="stylesheet" href="css/receiveMail.css" type="text/css"></link>
</head>
<%
	User user=(User)request.getSession().getAttribute("user");
	int userid=user.getId();
	System.out.println("userid="+userid);
	MessagesBiz messagesBiz=new MessagesBizImpl();
	List<Messages> messages=messagesBiz.getMessagesBySenderId(userid);
	//获取senderid的username
	List<User> users = new ArrayList<User>();
	UserBiz userBiz = new UserBizImpl();
	for(Messages message:messages){
		User user1 = userBiz.getUserById(message.getReceiverid());
		users.add(user1);
	}
	
	
	System.out.println(messages.size());
	
	request.setAttribute("users", users);
	request.setAttribute("messages", messages);
%>

<body>
	<div id="main">
		<%@ include file="shared/header.jsp"%>



		<div id="receiveMail_content">

			<table>
				<tr>
					<th colspan="4">我的发件箱</th>
				</tr>
				<tr>
					<th width="50%">邮件列表</th>
					<th width="20%">收件人</th>
					<th width="20%">发件时间</th>
					<th width="10%">删除</th>
				</tr>
				<c:forEach var="message" items="${messages}" varStatus="status">
					<tr>
						<td>${message.title }</td>
						<td>${users[status.index].username }</td>
						<td>${message.sendtime }</td>
						<td><a href="">删除</a>
						</td>
					</tr>
				</c:forEach>

			</table>

		</div>

		<%@ include file="shared/footer.jsp"%>

	</div>

</body>
</html>
