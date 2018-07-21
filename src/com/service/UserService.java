package com.service;

import com.domain.User;

public interface UserService {

	void regist(User user);

	User findByCode(String code);

	void update(User user);

	

}
