package com.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ActiveServlet
 */
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//首先通过用户点击链接返回的地址，获得激活码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		//根据激活码到数据库查询用户
		UserService userService=new UserServiceImpl();
		User user=new User();
		user= userService.findByCode(code);
		System.out.println(""+user.getUid());
		if(user.getUid() !=null) {
			//已经查询到了，修改该用户的状态，并且将激活码清楚掉
			user.setState(1);
			user.setCode(null);
			userService.update(user);
			request.setAttribute("msg", "账号注册成功，并已经激活");
		}else {
			request.setAttribute("msg", "你的激活码有误！请重新发送");
		}
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
