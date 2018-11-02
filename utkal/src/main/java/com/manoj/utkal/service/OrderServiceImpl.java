package com.manoj.utkal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manoj.utkal.dao.OrderDao;
import com.manoj.utkal.model.Customer;
import com.manoj.utkal.model.CustomerOrder;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderServiceImpl implements OrderService{
	
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	CustomerService customerService;
	
	@Override	
	public CustomerOrder getOrderDetails(String id, String date) {
	
		Customer customer = customerService.getCustomerById(id);
		CustomerOrder customerOrder =orderDao.getOrderDetails(id, date);
		//if(customerOrder.getOrderId()==0) {
			customerOrder.setCustomerId(Integer.parseInt(id));
			customerOrder.setOrderDate(date);
			customerOrder.setCustomerName(customer.getCustomerName());
			customerOrder.setCustomerMobileNumber(customer.getCustomerMobileNumber());
			customerOrder.setNormalJarRate(customer.getNormalJarRate());
			customerOrder.setAddress(customer.getAddress());
			customerOrder.setColdJarRate(customer.getColdJarRate());
		//}
		return customerOrder;
	}

	@Override
	public CustomerOrder createOrder(CustomerOrder customerOrder) {
		if(customerOrder.getOrderId()==0) {
		orderDao.createOrder(customerOrder);}		
		else {
		orderDao.updateOrder(customerOrder);
		}
		
		if(customerOrder.getPaymentId()==0){
		customerOrder.setPaymentDate(customerOrder.getOrderDate());
		orderDao.createPayment(customerOrder);
		}else {
			customerOrder.setPaymentDate(customerOrder.getOrderDate());
			orderDao.updatePayment(customerOrder);
			
		}
		return customerOrder;
	}

	
	@Override
	public CustomerOrder getTotalBillByCustId(String id) {
		
		return orderDao.getTotalBillByCustId(id);
	}

	@Override
	public CustomerOrder createPayment(CustomerOrder customerOrder) {
	
		return orderDao.createPayment(customerOrder);
	}

}
