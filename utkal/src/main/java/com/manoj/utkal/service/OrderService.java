package com.manoj.utkal.service;

import com.manoj.utkal.model.CustomerOrder;

public interface OrderService {
	
	public CustomerOrder getOrderDetails(String id,String date);

	public CustomerOrder createOrder(CustomerOrder customerOrder);
	
	
	public CustomerOrder getTotalBillByCustId(String id);
	
	public CustomerOrder createPayment(CustomerOrder customerOrder);
}
