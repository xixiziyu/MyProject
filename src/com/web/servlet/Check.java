package com.web.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.Dbobj;
import com.utils.JdbcUtils;

/**
 * Servlet implementation class Check
 */
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		   String code=request.getParameter("code");
		   String inputname=request.getParameter("inputname");
		   String sql="select * from user where code='"+code+"'";
		   System.out.println(""+sql);
		   JdbcUtils jdbc=new JdbcUtils();
		   Dbobj dbobj=new Dbobj();
		   dbobj=jdbc.executeQuery(sql);
		   ResultSet rs=dbobj.getRs();
		   String username="";
		  
		   try {
			while(rs.next())
			   {
				   
				   username=rs.getString("username");
				   
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  // System.out.println("http://localhost:8080/regist_web/ActiveServlet?code="+code+"");
		if(username.equals(inputname))
		{
			
			request.getRequestDispatcher("ActiveServlet?code="+code+"").forward(request, response);
			
		}else {
			request.setAttribute("msg", "你输入的用户名与激活码对应的用户名不匹配，请重新发送激活码");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		   
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
