package com.manoj.utkal.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manoj.utkal.model.Customer;
import com.manoj.utkal.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/customer")
@Slf4j
@CrossOrigin(allowedHeaders="*")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/loadCustomer")
	public ResponseEntity<String> loadCustomer() {
		
		customerService.loadCustomer();
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	
	@GetMapping("/test")
	public ResponseEntity<Customer> testMethod() {
		log.info("Test method for testing.");
		Customer customer = new Customer();
		customer.setAddress("sampleAddress");
		customer.setCustomerMobileNumber("983011");
		customer.setCustomerName("Manoj Banerjee");
		customer.setCustomerType("Regular");
		customer.setNormalJarRate("30");
		customer.setColdJarRate("30");
		customer.setSecurityDeposit("500");
		customer.setStartDate("2018/09/08");
		customer.setNoOfContainer("5");
		try {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValueAsString(customer);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		//Customer returnCustomer = customerService.saveCustomer(customer);
		
		 return new ResponseEntity<Customer>(customer,HttpStatus.OK );
	}
	

	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		log.info("Begin:  saveCustomer()");
		Customer returnCustomer = customerService.saveCustomer(customer);
		log.info("End:  saveCustomer()");
		return new ResponseEntity<Customer>(returnCustomer,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/customerList")
	public ResponseEntity<List<String>> getCustomerList(){
		return new ResponseEntity<List<String>>(customerService.getCustomerList(),HttpStatus.OK);
	}
	
	@GetMapping("/customerById/{customerId}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable String customerId) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId),HttpStatus.OK);
	}

	/**
	 * Returns all customer objects.
	 * @return
	 */
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		try{
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(),HttpStatus.OK);
		}catch(Exception ex){
			log.error("Exception occurred while retriving all customer details ",ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
