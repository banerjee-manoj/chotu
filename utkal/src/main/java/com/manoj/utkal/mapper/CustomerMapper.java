package com.manoj.utkal.mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manoj.utkal.model.Customer;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
	Customer customer =  new Customer();
	customer.setCustomerName(rs.getString(2));
	customer.setCustomerId(rs.getInt(1));
	customer.setCustomerMobileNumber(rs.getString(3));
	customer.setStartDate(rs.getString(4));
	customer.setActive(rs.getString(5));
	customer.setCustomerType(rs.getString(6));
	customer.setSecurityDeposit(rs.getString(7));
	customer.setNormalJarRate(rs.getString(8));
	customer.setColdJarRate(rs.getString(9));
		return customer;
	}



}
