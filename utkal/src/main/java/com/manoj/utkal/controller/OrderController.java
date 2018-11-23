package com.manoj.utkal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manoj.utkal.model.CustomerOrder;
import com.manoj.utkal.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/order")
@Slf4j
@CrossOrigin(allowedHeaders="*")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/getOrderDetails/{id}/{date}")
	public ResponseEntity<CustomerOrder> getOrderDetails(@PathVariable String id,@PathVariable String date){
		log.info("Customer Id "+id+"  Date "+date);;
		return new ResponseEntity<CustomerOrder>(orderService.getOrderDetails(id, date),HttpStatus.OK);
		
	}
	
	@PostMapping("/createOrder")
	public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrder customerOrder) {
	  	try {ObjectMapper mapper = new ObjectMapper();
	  	log.info(mapper.writeValueAsString(customerOrder));}catch(Exception ex) {
	  		ex.printStackTrace();
	  	}
		return new ResponseEntity<CustomerOrder>(orderService.createOrder(customerOrder),HttpStatus.OK);
	}
	
	@GetMapping("/getTotalBillByCustomerId/{customerId}")
	public ResponseEntity<CustomerOrder> getTotalBillById(@PathVariable String customerId){
		return new ResponseEntity<CustomerOrder>(orderService.getTotalBillByCustId(customerId),HttpStatus.OK);
		
	}
	
	@PostMapping("/createPayment")
	public ResponseEntity<CustomerOrder> createPayment(@RequestBody CustomerOrder customerPayment){
		
		return new ResponseEntity<CustomerOrder>(orderService.createPayment(customerPayment),HttpStatus.OK);
		
	}

}
