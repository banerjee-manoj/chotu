package com.manoj.utkal.dao;

import java.util.List;

import com.manoj.utkal.model.CustomerOrder;
import com.manoj.utkal.model.SearchCriteria;

public interface OrderDao {
	
	public CustomerOrder getOrderDetails(String id,String date);
    public CustomerOrder createOrder(CustomerOrder customerOrder);
    public CustomerOrder createPayment(CustomerOrder customerOrder);
    
    public CustomerOrder getTotalBillByCustId(String custId);
    
    public CustomerOrder updateOrder(CustomerOrder order);
    public CustomerOrder updatePayment(CustomerOrder order);
    
    public List<CustomerOrder> getOrderHistory(SearchCriteria criteria);
}
