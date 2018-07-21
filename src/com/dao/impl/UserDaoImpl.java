package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.*;
import com.domain.User;
import com.utils.Dbobj;
import com.utils.JdbcUtils;
public class UserDaoImpl implements UserDao {

	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		//将数据存入数据库中
		String sql="insert into user(username,password,nickname,email,state,code) value('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getNickname()+"','"+user.getEmail()+"',"
				+ "'"+user.getState()+"','"+user.getCode()+"')";
		
		JdbcUtils jdbcutils=new JdbcUtils();
		jdbcutils.executeUpdate(sql);
	
		
	}

	@Override
	public User findByCode(String code) {
		// TODO Auto-generated method stub
		User user=new User();
		String sql="select * from user where code='"+code+"'";
		   Dbobj dj=new Dbobj();
		   JdbcUtils jdbcu=new JdbcUtils();
		   dj=jdbcu.executeQuery(sql);
		   ResultSet rs=dj.getRs(); 
		   System.out.println(""+sql);		   
		   try {
			while(rs.next())
				{
					user.setUid(Integer.parseInt(""+rs.getString("uid")));
					user.setUsername(""+rs.getString("username"));
					user.setPassword(""+rs.getString("password"));
					user.setNickname(""+rs.getString("nickname"));
					user.setEmail(""+rs.getString("email"));
					user.setCode(""+rs.getString("code"));
					user.setState(Integer.parseInt(""+rs.getString("state")));
				}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//返回Javabean对象
		return user;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql="update  user set username='"+user.getUsername()+"',password='"+user.getPassword()+"',nickname='"+user.getNickname()+"',email='"+user.getEmail()+"',state='"+user.getState()+"',code='"+user.getCode()+"' where uid='"+user.getUid()+"'";
		
		/*System.out.println("#######################"+sql);
		System.out.println("检测有没有运行到这里"+user.getCode()+"+++++++++++++++++++"+user.getState());*/
		JdbcUtils jdbcutils=new JdbcUtils();
		jdbcutils.executeUpdate(sql);
		
	}

}
