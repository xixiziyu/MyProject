package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.utils.UUIDUtils;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

public class RegistServlet extends HttpServlet{
	
    private static final long  serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String nickname=request.getParameter("nickname");
		String email=request.getParameter("email");
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();//产生一串64位的随机生成码
		
		
		//将数据封装到Javabean中
		User user=new User();
		//**********************测试使用
		//user.setUid(01);
		
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setEmail(email);
		user.setState(0);//0:未激活 1：已经激活
		user.setCode(code);
		//将对象传到com.service,目的是注册账号
		UserService userService =new UserServiceImpl();
		userService.regist(user);
		//提示用户使用邮箱激活注册账号
		request.setAttribute("msg", "账号信息提交成功，请到邮箱根据邮件提示激活账号，以完成注册");
	
	    request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	

}
