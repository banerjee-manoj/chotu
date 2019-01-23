package com.manoj.utkal.model;

import lombok.Data;

@Data
public class CustomerLoader {
	
	private int customerId;
	private String customerName;
	private String customerAddress;
	private String mobile;
	private String type;
	private String createdDate;
	private int securityDeposit;
	private int container;
	private int  normalJarRate;
	private int coldJarRate;

}
