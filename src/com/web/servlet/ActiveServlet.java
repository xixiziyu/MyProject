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
		//����ͨ���û�������ӷ��صĵ�ַ����ü�����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		//���ݼ����뵽���ݿ��ѯ�û�
		UserService userService=new UserServiceImpl();
		User user=new User();
		user= userService.findByCode(code);
		System.out.println(""+user.getUid());
		if(user.getUid() !=null) {
			//�Ѿ���ѯ���ˣ��޸ĸ��û���״̬�����ҽ������������
			user.setState(1);
			user.setCode(null);
			userService.update(user);
			request.setAttribute("msg", "�˺�ע��ɹ������Ѿ�����");
		}else {
			request.setAttribute("msg", "��ļ��������������·���");
		}
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
