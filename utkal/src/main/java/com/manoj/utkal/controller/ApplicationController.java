package com.manoj.utkal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/application")
@Slf4j
@CrossOrigin(allowedHeaders="*")
public class ApplicationController {

	
	
	@GetMapping("/loadConfig")
	public ResponseEntity<String> getAppConfig(){
		log.debug("Loading application configurations");
		return new ResponseEntity<String>("Utkal Aqua Page",HttpStatus.OK);
	}
}
