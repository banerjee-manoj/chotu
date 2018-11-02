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

import com.manoj.utkal.mapper.OrderMapper;
import com.manoj.utkal.model.CustomerOrder;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderDaoImpl implements OrderDao {

	@Autowired
	Environment env;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public CustomerOrder getOrderDetails(String id, String date) {
		log.info("Begin : getOrderDetails");
		String query = env.getProperty("getOrderId");
		List<CustomerOrder> customerOrderList = jdbcTemplate.query(query,new Object[] {id,date},new OrderMapper());
		
		if(customerOrderList.isEmpty()) {
			return new CustomerOrder();
		}
		
		
		
		return customerOrderList.get(0);
		
		
	}

	@Override
	public CustomerOrder createOrder(CustomerOrder customerOrder) {
		log.info("Begin : createOrder");
		String query = env.getProperty("createOrder");
		log.debug("Query to be used : "+query);
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, customerOrder.getCustomerId());
				ps.setString(2,customerOrder.getOrderDate() );
				ps.setString(3,customerOrder.getNormalJarOrdered());
				ps.setString(4, customerOrder.getColdJarOrdered());
				ps.setString(5, customerOrder.getNormalEmptyJarReturned());
				ps.setString(6, customerOrder.getColdEmptyJarReturned());
				ps.setString(7, customerOrder.getNormalFilledJarReturned());
				ps.setString(8,customerOrder.getColdFilledJarReturned());
				ps.setString(9,customerOrder.getTotalBill());
				ps.setString(10,customerOrder.getContainerOrdered());
				ps.setString(11,customerOrder.getContainerReturned());
				
				return ps;
			}
		},holder);
		
		int newOrderId = holder.getKey().intValue();
		customerOrder.setOrderId(newOrderId);
		log.debug("Order Id generated : "+customerOrder.getOrderId());
		log.debug("end : saveCustomer()");
		return customerOrder;
		
	}
	
	@Override
	public CustomerOrder updateOrder(CustomerOrder order) {
		log.info("Begin updateOrder for customer id and order id   "+order.getCustomerId()+" order id "+order.getOrderId());
		String updateQuery=env.getProperty("updateOrder");
		int i = jdbcTemplate.update(updateQuery, order.getOrderDate(),order.getNormalJarOrdered(),order.getColdJarOrdered(),
				order.getNormalEmptyJarReturned(),order.getColdEmptyJarReturned(),order.getNormalFilledJarReturned(),
				order.getColdFilledJarReturned(),order.getTotalBill(),order.getContainerOrdered(),order.getContainerReturned(),order.getOrderId());
		log.info("updated customer id with status code "+i+" for customr id "+order.getCustomerId());
		
		return order;
		
	}
	
	@Override
	public CustomerOrder updatePayment(CustomerOrder order) {
		log.info("Begin update Payment for customer id and order id and payment id  "+order.getCustomerId()+" order id "+order.getOrderId() + "  payment id " +order.getPaymentId());
		String updateQuery=env.getProperty("updatePayment");
		int i = jdbcTemplate.update(updateQuery, order.getPayment(),order.getPaymentId());
		log.info("updated payment Id status code "+i+" for customr id "+order.getCustomerId());
		
		return order;
		
	}
	
	
	
	
	
	@Override
	public CustomerOrder createPayment(CustomerOrder customerOrder) {
		log.info("Begin : createPayment");
		String query = env.getProperty("createPayment");
		log.debug("Query to be used : "+query);
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, customerOrder.getPaymentDate());
				ps.setInt(2,customerOrder.getCustomerId());
				ps.setInt(3,Integer.parseInt(customerOrder.getPayment()));
				
				
				return ps;
			}
		},holder);
		
		int paymentId = holder.getKey().intValue();
		customerOrder.setPaymentId(paymentId);
		log.debug("Order Id generated : "+customerOrder.getOrderId());
		log.debug("end : saveCustomer()");
		return customerOrder;
		
	}

	@Override
	public CustomerOrder getTotalBillByCustId(String custId) {
		log.info("Begin : getTotalBillByCustId()");
		CustomerOrder customerOrder = new CustomerOrder();
		
		String query = env.getProperty("getTotalBillByCustId");
		String toalPaymentQuery = env.getProperty("getTotalPaymentByCustId");
		customerOrder.setTotalBill((String)jdbcTemplate.queryForObject(query,new Object[] {custId}, String.class));
		customerOrder.setTotalPayment(jdbcTemplate.queryForObject(toalPaymentQuery,new Object[] {custId}, String.class));
		return customerOrder;
		
	}
	
	
	
	
	
	

}
