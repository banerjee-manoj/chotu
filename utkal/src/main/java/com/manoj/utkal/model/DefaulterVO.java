package com.manoj.utkal.model;

import lombok.Data;

@Data
public class DefaulterVO {
	
	private String customerId;
	private String customerName;
	private String startDate;
	private String endDate;
	private String normalJarTaken;
	private String normalEmptyJarReturned;
	private String normalFilledJarReturned;
	private String coldJarTaken;
	private String coldEmptyJarReturned;
	private String coldFilledJarReturned;
	private int normalJarPending;
	private int coldJarPending;
	

}
