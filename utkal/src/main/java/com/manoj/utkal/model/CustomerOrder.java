package com.manoj.utkal.model;

import lombok.Data;

@Data
public class CustomerOrder extends Customer{
	
	private int orderId;
	private String orderDate;
	private String normalJarOrdered;
	private String coldJarOrdered;
	private String containerOrdered;
	private String normalEmptyJarReturned;
	private String coldEmptyJarReturned;
	private String normalFilledJarReturned;
	private String coldFilledJarReturned;
	private String payment;
	private String containerOrderd;
	private String containerReturned;
	private String normalJarPending;
	private String coldJarPending;
	private String totalBill;
	private String paymentDate;
	private int paymentId;
	private String totalPayment;
	

}
