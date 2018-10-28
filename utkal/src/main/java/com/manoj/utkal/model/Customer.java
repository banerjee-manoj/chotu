package com.manoj.utkal.model;

import lombok.Data;

@Data
public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerMobileNumber;
	private String address;
	private String customerType;
	private String securityDeposit;
	private String normalJarRate;
	private String coldJarRate;
	private String startDate;
	private String active;
	private String NoOfContainer;
	

}
