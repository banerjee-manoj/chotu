package com.manoj.utkal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.manoj.utkal.mapper.CustomerLoaderMapper;
import com.manoj.utkal.mapper.CustomerMapper;
import com.manoj.utkal.model.Customer;
import com.manoj.utkal.model.CustomerLoader;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	@Override
	public Customer saveCustomer(final Customer customer) {
		log.debug("begin :  saveCustomer()");
		String query = environment.getProperty("saveCustomer");
		log.debug("Query to be used : "+query);
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, customer.getCustomerName());
				ps.setString(2,customer.getCustomerMobileNumber() );
				ps.setString(3,customer.getStartDate());
				
				ps.setString(4, customer.getCustomerType());
				ps.setString(5, customer.getSecurityDeposit());
				ps.setString(6, customer.getNormalJarRate());
				ps.setString(7, customer.getColdJarRate());
				ps.setString(8,customer.getNoOfContainer());
				
				return ps;
			}
		},holder);
		
		int newUserId = holder.getKey().intValue();
		customer.setCustomerId(newUserId);
		log.debug("Customer Id generated : "+customer.getCustomerId());
		log.debug("end : saveCustomer()");
		return customer;
	}

	@Override
	public Customer saveAddress(final Customer customer) {
	     log.info("Save Customer Address");
	 	String query = environment.getProperty("saveAddress");
		jdbcTemplate.update(query, customer.getCustomerId(),customer.getAddress());
		return customer;
		
	}

	@Override
	public List<String> getCustomeList() {
	log.info("getCustomeList");
	String query = environment.getProperty("getCustomerList");
	List<String> customerName = jdbcTemplate.queryForList(query, String.class);
	
		return customerName;
	}

	@Override
	public Customer getCustomerById(String id) {
		log.info("Begin getCustomerByName");
		String query = environment.getProperty("getCustomerById");
		return (Customer) jdbcTemplate.query(query, new Object[] {id}, new CustomerMapper()).get(0);
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		log.info("Begin getAllCustomer");
		String query = environment.getProperty("getAllCustomer");
		return jdbcTemplate.query(query, new CustomerMapper());
		
	}

	@Override
	public String getCustomerAddressById(String id) {
		log.info("Begin getCustomer Address");
		String query = environment.getProperty("getAddressById");
		return (String)jdbcTemplate.queryForObject(query,new Object[] {id}, String.class);
		
		
	}
//	update customer set 
	//customer_name=?,
		//	mobile_number=?,created_date=?,type=?,security_deposit=?,normal_jar_rate=?,
	//		cold_jar_rate=? where id=?
	@Override
	public Customer updateCustomerDetails(Customer customer) {
		log.info("Update Customer Details");
		String query=environment.getProperty("updateCustomer");
		jdbcTemplate.update(query,customer.getCustomerName(),customer.getCustomerMobileNumber(),customer.getStartDate(),customer.getCustomerType(),customer.getSecurityDeposit(),
			customer.getNormalJarRate(),customer.getColdJarRate(),customer.getCustomerId());
		return customer;
	}

	@Override
	public List<Customer> loadCustomer() {
		log.info("Loading customer");
		String query="select * from customer_details";
		List<Customer> customerLoaderList = jdbcTemplate.query(query, new CustomerLoaderMapper());
		log.info("Size of the customer Table...{}",customerLoaderList.size());
		
	
		
		return customerLoaderList;
	}

}
