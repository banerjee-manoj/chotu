package com.manoj.utkal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manoj.utkal.dao.UserDao;
import com.manoj.utkal.model.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDaoImpl;
	
	@Override
	public String createUser(User user) {
		log.debug("Begin: Create User");
		
		return userDaoImpl.createUser(user);
	}

	@Override
	public String validateUser(User user) {
		log.debug("Begin : validate User");
		return userDaoImpl.validateUser(user);
	}

	
	
	
	
}
