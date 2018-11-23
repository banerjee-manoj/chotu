package com.manoj.utkal.dao;

import java.util.List;

import com.manoj.utkal.model.Customer;

public interface CustomerDao {
	
	public Customer saveCustomer(Customer customer);
	public Customer saveAddress(Customer customer);
	public List<String> getCustomeList();
	public Customer getCustomerById(String id);
    public List<Customer> getAllCustomer();
    public String getCustomerAddressById(String id);
    public Customer updateCustomerDetails(Customer customer);
    public List<Customer> loadCustomer();
}
