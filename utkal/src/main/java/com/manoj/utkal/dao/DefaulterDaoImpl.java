package com.manoj.utkal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.manoj.utkal.model.CustomerOrder;
import com.manoj.utkal.model.SearchCriteria;

public class DefaulterDaoImpl implements DefaulterDao {

	@Autowired
	Environment environment;
	
	@Override
	public List<CustomerOrder> getJarDefaulter(SearchCriteria criteria) {
		String baseQuery = environment.getProperty("getJarDefaulter");
		StringBuilder strBuilder = new StringBuilder();
		if(!(criteria.getCustomerId()==0))
			baseQuery=baseQuery+"where customerId="+criteria.getCustomerId();
		if(!criteria.getCustomerType().equalsIgnoreCase("")) {
			strBuilder.append("where customerType='"+criteria.getCustomerType()+"'");
		}
		
		return null;
	}

}
