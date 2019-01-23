package com.manoj.utkal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manoj.utkal.model.CustomerOrder;

public class PaymentMapper implements RowMapper<CustomerOrder> {

	@Override
	public CustomerOrder mapRow(ResultSet rs, int arg1) throws SQLException {
		CustomerOrder customerPayment = new CustomerOrder();
		customerPayment.setCustomerName(rs.getString(1));
		customerPayment.setPaymentDate(rs.getString(2));
		customerPayment.setPayment(rs.getString(3));
		
		return customerPayment;
	}

}
