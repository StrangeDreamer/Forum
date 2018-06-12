package com.forum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.biz.InformationBiz;
import com.forum.biz.impl.InformationBizImpl;
import com.forum.entity.Information;

public class AddTopicInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		Information information = new Information();
		information.setContent(request.getParameter("content"));
		information.setTopicId(topicId);
		information.setUserId(Integer.parseInt(request.getParameter("userId")));
		
		InformationBiz informationBiz = new InformationBizImpl();
		int count = informationBiz.addInformation(information);
		if(count>0){
			request.setAttribute("topicId", topicId);
			request.getRequestDispatcher("GetTopicInformationServlet").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
