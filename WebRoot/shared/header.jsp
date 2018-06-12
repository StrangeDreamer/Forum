<%@page import="com.forum.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="header">
	<div id="header_logo" >
		<img src="images/logo.jpg" alt=""></img>
	</div>
	<div id="header_right">
		<a href="login.jsp">登录</a>
		<a href="IsLoginServlet">发表主题</a>
		<a href="GetTopicByPageServlet">浏览主题</a>
		<a href="contact_us.jsp">联系我们</a>
		<c:if test="${sessionScope.user!=null}">
			<a href="GetMessageServlet">收件箱
				<c:if test="${sessionScope.count>0 }">
					<img src="images/newMail.png" alt="" />
				</c:if>
			</a>
			<a href="sendMail.jsp">发件箱</a>
		</c:if>
		<c:if test="${sessionScope.user==null}">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</c:if>
		<div id="show_user">
		<c:if test="${sessionScope.user!=null}">
			<label id="welcome">  				
				您好，${sessionScope.user.username}
				
			</label>
		</c:if>
		<a href="LogoutServlet">注销</a>
	</div>	
		 
	</div>
	
	
</div>
