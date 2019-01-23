package com.manoj.utkal.model;

import java.util.List;

import lombok.Data;

@Data
public class OrderHistory {
	
	private int totalBill;
	private int totalPaymentRcvd;
	private int totalNormalJarOrdered;
	private int totalColdJarOrdered;
	private int totalNormalEmptyJarReturned;
	private int totalColdEmptyJarReturned;
	private int totalNormalFilledJarReturned;
	private int totalColdFilledJarReturned;
	private List<CustomerOrder> customerOrderList;

}
