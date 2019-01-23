package com.manoj.utkal.model;

import java.util.List;

import lombok.Data;

@Data
public class PaymentHistory {
	
	private int totalPaymentReceived;
	private List<CustomerOrder> customerPaymentDetails;

}
