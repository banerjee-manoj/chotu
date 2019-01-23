package com.manoj.utkal.dao;

import java.util.List;

import com.manoj.utkal.model.DefaulterVO;
import com.manoj.utkal.model.SearchCriteria;

public interface DefaulterDao {

	
	public List<DefaulterVO> getJarDefaulter(SearchCriteria criteria);
	public List<DefaulterVO> getPaymentDefaulter(SearchCriteria criteria);
}
