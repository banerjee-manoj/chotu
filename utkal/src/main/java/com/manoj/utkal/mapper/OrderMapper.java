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
		order.setColdJarOrdered(rs.getString("c_jar_taken"));
		order.setColdJarOrdered(rs.getString("c_jar_taken"));
		order.setTotalBill(rs.getString("total_bill"));
		order.setNormalFilledJarReturned(rs.getString("n_filled_jar_return"));
	
		return order;
	}

	
}
