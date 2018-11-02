package com.manoj.utkal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.utkal.model.Customer;
import com.manoj.utkal.model.SearchCriteria;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/defaulter")
@Slf4j
@CrossOrigin
public class DefaulterController {
	
	
	@PostMapping("/jar")
	public ResponseEntity<Customer> getJarDefaulterList(@RequestBody 
			SearchCriteria criteria) {
		log.info("Search Criteira --> {}",criteria);
		
		return null;
	}

}
