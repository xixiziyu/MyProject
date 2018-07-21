package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.domain.User;
import com.service.UserService;
import com.utils.MailUtils;
import com.utils.MailUtils1;

public class UserServiceImpl implements UserService {
   //�����ݴ������ݿ�
	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		UserDao userDao =new UserDaoImpl();
		userDao.regist(user);
		//����һ�⼤��ȷ���ʼ�
		try {
			MailUtils1.sendMail(user.getEmail(), user.getCode());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

@Override
public User findByCode(String code) {
	// TODO Auto-generated method stub
	UserDao userDao =new UserDaoImpl();
	
	return userDao.findByCode(code);
}

@Override
public void update(User user) {
	// TODO Auto-generated method stub
	UserDao userDao=new UserDaoImpl();
	userDao.update(user);
}

}
