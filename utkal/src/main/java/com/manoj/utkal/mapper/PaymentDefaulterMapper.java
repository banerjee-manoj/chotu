package com.manoj.utkal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manoj.utkal.model.DefaulterVO;

public class PaymentDefaulterMapper implements RowMapper<DefaulterVO> {

	@Override
	public DefaulterVO mapRow(ResultSet rs, int arg1) throws SQLException {
	    DefaulterVO defaulter = new DefaulterVO();
	    defaulter.setCustomerName(rs.getString(2));
	    defaulter.setTotalBill(rs.getString(3));
	    defaulter.setTotalPayment(rs.getString(4));
		return null;
	}

}
