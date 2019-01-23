package com.manoj.utkal.dao;

import com.manoj.utkal.model.User;

public interface UserDao {

	public String createUser(User user);
	public String validateUser(User user);
}
