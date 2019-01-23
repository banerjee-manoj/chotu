package com.manoj.utkal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.manoj.utkal.model.User;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class UserDaoImpl implements UserDao{

	@Autowired
	Environment env;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public String createUser(User user) {
		log.debug("Begin : Create user");
		String query = env.getProperty("createUser");
		try{
			jdbcTemplate.update(query,new Object[]{user.getUserName(),user.getFullName(),user.getPassword()});
			return user.getFullName();
		}catch(Exception ex){
			log.error("Exception while creating User ",ex);
		}
		
		
		return null;
	}


	@Override
	public String validateUser(User user) {
		log.debug("Begin : Validate user");
		String query = env.getProperty("getUserDetails");
		log.debug("Validate user query: {}",query);
		try{
			
			String userFullName= jdbcTemplate.queryForObject(query,new Object[]{user.getUserName(),user.getPassword()},String.class);
		log.info("valid user name : {}",userFullName);
		return userFullName;
		}catch(Exception ex){
			log.error("Exception occurred while validating user", ex);
			return null;
		}
		
	}

}
