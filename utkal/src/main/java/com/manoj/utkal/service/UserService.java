package com.manoj.utkal.service;

import com.manoj.utkal.model.User;

public interface UserService {

	public String createUser(User user);
	
	public String validateUser(User user);
}
