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
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();//����һ��64λ�����������
		
		
		//�����ݷ�װ��Javabean��
		User user=new User();
		//**********************����ʹ��
		//user.setUid(01);
		
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setEmail(email);
		user.setState(0);//0:δ���� 1���Ѿ�����
		user.setCode(code);
		//�����󴫵�com.service,Ŀ����ע���˺�
		UserService userService =new UserServiceImpl();
		userService.regist(user);
		//��ʾ�û�ʹ�����伤��ע���˺�
		request.setAttribute("msg", "�˺���Ϣ�ύ�ɹ����뵽��������ʼ���ʾ�����˺ţ������ע��");
	
	    request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	

}
