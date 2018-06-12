package com.forum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.biz.MessagesBiz;
import com.forum.biz.UserBiz;
import com.forum.biz.impl.MessagesBizImpl;
import com.forum.biz.impl.UserBizImpl;
import com.forum.entity.Messages;
import com.forum.entity.User;

public class GetMessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		User user = (User)request.getSession().getAttribute("user");
		List<Messages> messages = new ArrayList<Messages>();
		MessagesBiz messagesBiz = new MessagesBizImpl();
		messages = messagesBiz.getMessagesById(user.getId());
		//获取senderid的username
		List<User> users = new ArrayList<User>();
		UserBiz userBiz = new UserBizImpl();
		for(Messages message:messages){
			User user1 = userBiz.getUserById(message.getSenderid());
			users.add(user1);
		}
		
		request.setAttribute("users", users);
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("receiveMail.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

}
