package com.forum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.biz.InformationBiz;
import com.forum.biz.TopicBiz;
import com.forum.biz.UserBiz;
import com.forum.biz.impl.InformationBizImpl;
import com.forum.biz.impl.TopicBizImpl;
import com.forum.biz.impl.UserBizImpl;
import com.forum.entity.Information;
import com.forum.entity.Topic;
import com.forum.entity.User;

public class GetTopicInformationServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		Topic topic = new Topic();
		TopicBiz topicBiz = new TopicBizImpl();
		
		topic=topicBiz.getTopicById(topicId);
		
		User user = new User();
		UserBiz userBiz = new UserBizImpl();
		user=userBiz.getUserById(topic.getUserId());
		System.out.println("user.id+++++++++++:"+user.getId());
		
		int pageNo=1;//页码
		int pageSize=3;//每页回复数
		
		//回复信息
		List<Information> informations = new ArrayList<Information>();
		InformationBiz informationBiz = new InformationBizImpl();
		//总topic记录数
		int rows = informationBiz.getTopicsInfoRows(topicId);
		//获取页码
		if(request.getParameter("pageNo")!=null){
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}
		//总页数
		int pageCount=(int)Math.ceil((double)(rows+1)/(pageSize));
		
		informations = informationBiz.getTopicInformations(topicId,pageNo,pageSize);
		
		List<User> users = new ArrayList<User>();
		
		for(Information information:informations){
			users.add(userBiz.getUserById(information.getUserId()));
		}		
		

		
		request.setAttribute("user", user);//楼主信息
		request.setAttribute("topic", topic);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("topicId", topicId);
		request.setAttribute("informations", informations);
		request.setAttribute("users", users);
		request.getRequestDispatcher("topic_info.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
