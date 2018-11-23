package com.manoj.utkal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.manoj.utkal.mapper.DefaulterVOMapper;
import com.manoj.utkal.model.DefaulterVO;
import com.manoj.utkal.model.SearchCriteria;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaulterDaoImpl implements DefaulterDao {

	@Autowired
	Environment environment;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<DefaulterVO> getJarDefaulter(SearchCriteria criteria) {
		String baseQuery = "select customer.id as customerId, customer.customer_name,SUM(orderTable.n_jar_taken) as normalJarTaken, " + 
				" SUM(orderTable.n_empty_jar_return) normalEmptyJarReturned,SUM(orderTable.n_filled_jar_return) as normalFilledJarReturned, " + 
				" SUM(orderTable.c_jar_taken) as coldJarTaken ,SUM(orderTable.c_empty_jar_return) as coldEmptyJarReturned,SUM(orderTable.c_filled_jar_return) as coldFilledJarReturned " + 
				" from order_table orderTable, customer customer  where 1=1 and customer.id=orderTable.customer_id";
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(baseQuery);
		if(!(criteria.getCustomerId()==0)) {
              strBuilder.append(" and orderTable.customer_id="+criteria.getCustomerId());
		}else {
			if(!criteria.getCustomerType().isEmpty()) {
				strBuilder.append(" and customer.type='"+criteria.getCustomerType()+"'");
			}}
		
		
		if(!criteria.getStartDate().isEmpty() && !criteria.getEndDate().isEmpty()) {
			strBuilder.append(" and transaction_date>='"+criteria.getStartDate()+"' "
					+ "and transaction_date<='"+criteria.getEndDate()+"'");
		}
		strBuilder.append(" group by customerId");
		log.info("Jar defaulter Query : {}",strBuilder.toString());
		
		List<DefaulterVO> defaulterList = jdbcTemplate.query(strBuilder.toString(),new DefaulterVOMapper());
		return defaulterList;
	}

}
