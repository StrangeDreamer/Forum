package com.forum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.biz.InformationBiz;
import com.forum.biz.impl.InformationBizImpl;

public class DeleteInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		int information_id = Integer.parseInt(request.getParameter("id").trim());
		InformationBiz informationBiz = new InformationBizImpl();
		int count= informationBiz.deleteInformation(information_id);
		if(count>0){
			int topicId = Integer.parseInt(request.getParameter("topicId"));
			int pageNo=Integer.parseInt(request.getParameter("pageNo"));
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("topicId", topicId);
			
			request.getRequestDispatcher("GetTopicInformationServlet").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
