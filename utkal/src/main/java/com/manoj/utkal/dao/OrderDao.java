package com.manoj.utkal.dao;

import com.manoj.utkal.model.CustomerOrder;

public interface OrderDao {
	
	public CustomerOrder getOrderDetails(String id,String date);
    public CustomerOrder createOrder(CustomerOrder customerOrder);
    public CustomerOrder createPayment(CustomerOrder customerOrder);
    
    public CustomerOrder getTotalBillByCustId(String custId);
    
    public CustomerOrder updateOrder(CustomerOrder order);
    public CustomerOrder updatePayment(CustomerOrder order);
}
