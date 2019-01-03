package com.manoj.utkal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manoj.utkal.dao.OrderDao;
import com.manoj.utkal.model.Customer;
import com.manoj.utkal.model.CustomerOrder;
import com.manoj.utkal.model.OrderHistory;
import com.manoj.utkal.model.SearchCriteria;

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

	@Override
	public OrderHistory getOrderHistory(SearchCriteria criteria) {
		OrderHistory orderHistory = new OrderHistory();
		List<CustomerOrder> customerOrderList = orderDao.getOrderHistory(criteria); 
		int totalBbill = 0;
		int totalPayment = 0;
		int totalNormalJarOrdered=0;
		int totalColdJarOrdered=0;
		int totalNormalJarReturned=0;
		int totalColdJarReturned=0;
		int totalNormalFilledJarReturned=0;
		int totalColdFilledJarReturned=0;
		for(CustomerOrder order: customerOrderList){
		totalBbill=totalBbill+Integer.parseInt(order.getTotalBill());
		totalPayment=totalPayment+Integer.parseInt(order.getPayment());
		totalNormalJarOrdered=totalNormalJarOrdered+Integer.parseInt(order.getNormalJarOrdered());
		totalNormalJarReturned=totalNormalJarReturned+Integer.parseInt(order.getNormalEmptyJarReturned());
		totalNormalFilledJarReturned=totalNormalFilledJarReturned+Integer.parseInt(order.getNormalFilledJarReturned());
		totalColdJarOrdered=totalColdJarOrdered+Integer.parseInt(order.getColdJarOrdered());
		totalColdFilledJarReturned=totalColdFilledJarReturned+Integer.parseInt(order.getColdFilledJarReturned());
		totalColdJarReturned=totalColdJarReturned+Integer.parseInt(order.getColdEmptyJarReturned());
	}
		
		orderHistory.setTotalBill(totalBbill);
		orderHistory.setTotalPaymentRcvd(totalPayment);
	    orderHistory.setTotalNormalJarOrdered(totalNormalJarOrdered);
	    orderHistory.setTotalColdJarOrdered(totalColdJarOrdered);
	    orderHistory.setTotalNormalEmptyJarReturned(totalNormalJarReturned);
	    orderHistory.setTotalNormalFilledJarReturned(totalNormalFilledJarReturned);
	    orderHistory.setTotalColdEmptyJarReturned(totalColdJarReturned);
	    orderHistory.setTotalColdFilledJarReturned(totalColdFilledJarReturned);		
		orderHistory.setCustomerOrderList(customerOrderList);
		
		return orderHistory;
	}

}
