package com.sunmengjie.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.sunmengjie.hgshop.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	public boolean login(String userName, String passWord) {
		return "admin".equals(userName) && "123456".equals(passWord);
	}

}
