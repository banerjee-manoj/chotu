package com.manoj.utkal.dao;

import java.util.List;

import com.manoj.utkal.model.CustomerOrder;
import com.manoj.utkal.model.SearchCriteria;

public interface DefaulterDao {

	
	public List<CustomerOrder> getJarDefaulter(SearchCriteria criteria);
}
