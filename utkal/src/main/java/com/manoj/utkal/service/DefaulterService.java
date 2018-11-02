package com.manoj.utkal.service;

import java.util.List;

import com.manoj.utkal.model.CustomerOrder;
import com.manoj.utkal.model.SearchCriteria;

public interface DefaulterService {
	
	public List<CustomerOrder> getJarDefaulter(SearchCriteria criteria);

}
