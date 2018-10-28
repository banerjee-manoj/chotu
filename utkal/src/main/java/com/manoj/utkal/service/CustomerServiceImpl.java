package com.manoj.utkal.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manoj.utkal.dao.CustomerDao;
import com.manoj.utkal.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public Customer saveCustomer(Customer customer) {

		log.info("Begin saveCustomer : " + customer.getCustomerId());
		if (customer.getCustomerId() == 0) {
			customerDao.saveCustomer(customer);
			customerDao.saveAddress(customer);
		} else {
			log.info("Exisitng Customer need to update here...");
			customerDao.updateCustomerDetails(customer);
		}
		return customer;

	}

	@Override
	public List<String> getCustomerList() {
		return customerDao.getCustomeList();
	}

	@Override
	public Customer getCustomerById(String Id)  {
		Customer customer=customerDao.getCustomerById(Id);
		customer.setAddress(customerDao.getCustomerAddressById(Id));
		try{SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		customer.setStartDate(sdf.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(customer.getStartDate())));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		log.info("Date from the Server "+ customer.getStartDate());
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return customerDao.getAllCustomer();
	}

}
