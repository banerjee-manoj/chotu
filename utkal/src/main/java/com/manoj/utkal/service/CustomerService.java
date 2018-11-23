package com.manoj.utkal.service;

import java.text.ParseException;
import java.util.List;

import com.manoj.utkal.model.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);
	
	public List<String> getCustomerList();
	
	public Customer getCustomerById(String name) ;
	
	public List<Customer> getAllCustomer();
	
	public String loadCustomer();

	
	
}
