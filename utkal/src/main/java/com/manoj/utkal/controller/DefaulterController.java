package com.manoj.utkal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.utkal.model.DefaulterVO;
import com.manoj.utkal.model.SearchCriteria;
import com.manoj.utkal.service.DefaulterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/defaulter")
@Slf4j
@CrossOrigin
public class DefaulterController {
	
	@Autowired
	DefaulterService defaulterService;
	
	@PostMapping("/jar")
	public ResponseEntity<List<DefaulterVO>> getJarDefaulterList(@RequestBody 
			SearchCriteria criteria) {
		log.info("Search Criteira --> {}",criteria);
		return new ResponseEntity<List<DefaulterVO>>(defaulterService.getJarDefaulter(criteria),HttpStatus.OK);
		
	}

}
