package com.manoj.utkal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.utkal.model.User;
import com.manoj.utkal.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
@CrossOrigin(allowedHeaders="*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/createUser")
	public ResponseEntity<String>  createUser(@RequestBody User user){
		
		log.debug("Begin:Create user");
	
	
		return new ResponseEntity<String>(userService.createUser(user),HttpStatus.OK);
		
	}

	@PostMapping("/validateUser")
	public ResponseEntity<String> validateUser(@RequestBody User user){
		
		log.debug("Begin: Validate user");
	
		String userfullname = userService.validateUser(user);
		if(null==userfullname){
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);	
		}else{
			return new ResponseEntity<String>(userfullname,HttpStatus.OK);
		}
		
	
		
		
	}
}
