package com.manoj.utkal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manoj.utkal.model.Customer;
import com.manoj.utkal.model.CustomerLoader;

public class CustomerLoaderMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
		Customer customer = new Customer();
		customer.setCustomerId(0);
		customer.setAddress(rs.getString("Address"));
		customer.setCustomerName(rs.getString("customer_name"));
		customer.setCustomerMobileNumber(rs.getString("mobile_number"));
		customer.setStartDate(rs.getString("activationDate"));
		customer.setColdJarRate(rs.getString("cold_jar_rate"));
		customer.setNormalJarRate(rs.getString("normal_jar_rate"));
		customer.setNoOfContainer(rs.getString("container"));
		customer.setCustomerType(rs.getString("customer_type"));
		customer.setSecurityDeposit(rs.getString("security_deposit"));
		customer.setActive("yes");
		
		return customer;
	}

}
