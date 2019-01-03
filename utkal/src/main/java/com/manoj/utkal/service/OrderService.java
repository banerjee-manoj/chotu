package com.manoj.utkal.service;

import com.manoj.utkal.model.CustomerOrder;
import com.manoj.utkal.model.OrderHistory;
import com.manoj.utkal.model.SearchCriteria;

public interface OrderService {
	
	public CustomerOrder getOrderDetails(String id,String date);

	public CustomerOrder createOrder(CustomerOrder customerOrder);
	
	
	public CustomerOrder getTotalBillByCustId(String id);
	
	public CustomerOrder createPayment(CustomerOrder customerOrder);
	
	public OrderHistory getOrderHistory(SearchCriteria criteria);
}
