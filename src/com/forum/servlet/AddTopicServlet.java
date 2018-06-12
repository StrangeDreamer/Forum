package com.forum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.biz.TopicBiz;
import com.forum.biz.impl.TopicBizImpl;
import com.forum.entity.Topic;
import com.forum.entity.User;

public class AddTopicServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		Topic topic = new Topic();
		topic.setContent(request.getParameter("content"));
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try{
		  date=df.parse(request.getParameter("date"));
		}
		catch(Exception e){
		}
		topic.setDate(date);
		topic.setTitle(request.getParameter("title"));
		//获得登录的账号
		User user =(User)request.getSession().getAttribute("user");	
		
		topic.setUserId(user.getId());
		TopicBiz topicBiz = new TopicBizImpl();
		int count=topicBiz.addTopic(topic);
		if(count>0){
			response.sendRedirect("GetTopicByPageServlet");
		}else{
			request.getRequestDispatcher("addTopic.jsp").forward(request, response);
		}
			
		
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

}
