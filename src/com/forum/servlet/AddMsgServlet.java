package com.forum.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.biz.MessagesBiz;
import com.forum.biz.impl.MessagesBizImpl;
import com.forum.entity.Messages;
import com.forum.entity.User;


public class AddMsgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String title=request.getParameter("title");
		int receiverid=Integer.parseInt(request.getParameter("receiverid"));
		User user=(User)request.getSession().getAttribute("user");
		int senderid=user.getId();
		String content=request.getParameter("content");
		Messages message=new Messages();
		MessagesBiz messagesBiz=new MessagesBizImpl();
		message.setContent(content);
		message.setReceiverid(receiverid);
		message.setSenderid(senderid);
		message.setTitle(title);
		message.setSendtime(new Date());
		int count=messagesBiz.addMsg(message);
		if(count>0)
		{
			response.sendRedirect("sendMail.jsp");					
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	}

}
