package com.dao;

import com.domain.User;

public interface UserDao {

	void regist(User user);

	User findByCode(String code);

	void update(User user);

}
