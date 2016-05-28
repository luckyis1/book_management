package com.lucky.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class SimpleDAO {
	@Inject

	private DataSource dataSource;
	
	public String getTimeNow() throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select now()");
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
	    return rs.getString(1);
		
		
	}
	
	
}
