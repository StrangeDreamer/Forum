package com.forum.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.forum.biz.MessagesBiz;
import com.forum.biz.UserBiz;
import com.forum.biz.impl.MessagesBizImpl;
import com.forum.biz.impl.UserBizImpl;
import com.forum.entity.User;

public class UserCheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		System.out.println("username"+username);
		String password = request.getParameter("password");
		UserBiz userBiz = new UserBizImpl();
		User user = userBiz.checkLogin(username, password);
		if(user!=null){	//登录成功
			//保存session
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			MessagesBiz messagesBiz = new MessagesBizImpl();
			int count= messagesBiz.isRead(user.getId());
			if(count>0){
				session.setAttribute("count", count);
			}			
			response.sendRedirect("GetTopicByPageServlet"); //response.sendRedirect 的功能是地址重定向(页面跳转)
		}else{
			request.setAttribute("error", "用户名或密码错误");	
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
