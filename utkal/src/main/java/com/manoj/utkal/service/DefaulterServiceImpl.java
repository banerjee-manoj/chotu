package com.manoj.utkal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manoj.utkal.dao.DefaulterDao;
import com.manoj.utkal.model.DefaulterVO;
import com.manoj.utkal.model.SearchCriteria;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaulterServiceImpl implements DefaulterService {
	
	@Autowired
	DefaulterDao defaulterDao;

	@Override
	public List<DefaulterVO> getJarDefaulter(SearchCriteria criteria) {
		
		return defaulterDao.getJarDefaulter(criteria);
	}

}
