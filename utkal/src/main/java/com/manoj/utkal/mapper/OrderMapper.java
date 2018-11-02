package com.manoj.utkal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manoj.utkal.model.CustomerOrder;

public class OrderMapper implements RowMapper<CustomerOrder> {

	@Override
	public CustomerOrder mapRow(ResultSet rs, int arg1) throws SQLException {
		CustomerOrder order = new CustomerOrder();
		order.setOrderId(rs.getInt("order_id"));
		order.setOrderDate(rs.getString("transaction_date"));
		
		order.setNormalJarOrdered(rs.getString("n_jar_taken"));
		order.setNormalFilledJarReturned(rs.getString("n_filled_jar_return"));
		order.setNormalEmptyJarReturned(rs.getString("n_empty_jar_return"));
		
		order.setColdJarOrdered(rs.getString("c_jar_taken"));
		order.setColdEmptyJarReturned(rs.getString("c_empty_jar_return"));
		order.setColdFilledJarReturned(rs.getString("n_filled_jar_return"));
		
		order.setContainerOrdered(rs.getString("container_taken"));
		order.setContainerReturned(rs.getString("container_return"));
		
		order.setTotalBill(rs.getString("total_bill"));
		
	    order.setPayment(rs.getString("payment_recvd"));
	    order.setPaymentId(rs.getInt("payment_id"));
	    
	    
		return order;
	}

	
}
