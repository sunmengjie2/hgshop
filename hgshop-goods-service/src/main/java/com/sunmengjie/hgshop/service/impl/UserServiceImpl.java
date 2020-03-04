package com.sunmengjie.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.sunmengjie.hgshop.config.AdminProperties;
import com.sunmengjie.hgshop.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	AdminProperties adminProperties;
	
	@Override
	public boolean login(String userName, String passWord) {
		//判断用户名和密码是否与配置文件一致
		return adminProperties.getAdmingName().equals(userName) 
				&& adminProperties.getPassword().equals(passWord);
	}

}
