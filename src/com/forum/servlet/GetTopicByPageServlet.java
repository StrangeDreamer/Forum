package com.forum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.biz.TopicBiz;
import com.forum.biz.UserBiz;
import com.forum.biz.impl.TopicBizImpl;
import com.forum.biz.impl.UserBizImpl;
import com.forum.entity.Topic;
import com.forum.entity.User;

public class GetTopicByPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		int pageNo=1;//页码
		int pageSize=4;//条数
		//获取页码
		if(request.getParameter("pageNo")!=null){
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}				
		List<Topic> topics = new ArrayList<Topic>();
		TopicBiz topicBiz = new TopicBizImpl();
		topics=topicBiz.getTopicsByPage(pageNo,pageSize);
		
		List<User> users = new ArrayList<User>();
		UserBiz userBiz = new UserBizImpl();
		for(Topic topic:topics){
			users.add(userBiz.getUserById(topic.getUserId()));
		}
		
		//总topic记录数
		int rows = topicBiz.getTopicsRows();
		//总页数
		int pageCount = (int)Math.ceil((double)rows/pageSize);
		
		
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("topics", topics);
		request.setAttribute("users", users);
		request.getRequestDispatcher("topicList.jsp").forward(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
