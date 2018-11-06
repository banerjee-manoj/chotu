package com.manoj.utkal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manoj.utkal.model.DefaulterVO;

public class DefaulterVOMapper implements RowMapper<DefaulterVO> {

	@Override
	public DefaulterVO mapRow(ResultSet rs, int arg1) throws SQLException {

		DefaulterVO defaulter = new DefaulterVO();
		defaulter.setCustomerId(rs.getString(1));
		defaulter.setCustomerName(rs.getString(2));
		defaulter.setNormalJarTaken(rs.getString("normalJarTaken"));
		defaulter.setNormalEmptyJarReturned(rs.getString("normalEmptyJarReturned"));
		defaulter.setNormalFilledJarReturned(rs.getString("normalFilledJarReturned"));
		defaulter.setColdJarTaken(rs.getString("coldJarTaken"));
		defaulter.setColdEmptyJarReturned(rs.getString("coldEmptyJarReturned"));
		defaulter.setColdFilledJarReturned(rs.getString("coldFilledJarReturned"));
		int i = Integer.parseInt(rs.getString("normalJarTaken"))
				- (Integer.parseInt(rs.getString("normalEmptyJarReturned"))
						+ Integer.parseInt(rs.getString("normalFilledJarReturned")));
		int j = Integer.parseInt(rs.getString("coldJarTaken"))
				- (Integer.parseInt(rs.getString("coldEmptyJarReturned"))
						+ Integer.parseInt(rs.getString("coldFilledJarReturned")));
		defaulter.setNormalJarPending(i);
		defaulter.setColdJarPending(j);
		return defaulter;
	}

}
