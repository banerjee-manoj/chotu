package com.manoj.utkal.service;

import java.util.List;

import com.manoj.utkal.model.DefaulterVO;
import com.manoj.utkal.model.SearchCriteria;

public interface DefaulterService {
	
	public List<DefaulterVO> getJarDefaulter(SearchCriteria criteria);

}
