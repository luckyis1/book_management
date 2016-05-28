package com.lucky.datasource;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ConnectionTest {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionTest.class);
	
	@Inject
	DataSource ds;
	
	@Test
	public void test() throws Exception {
		Connection con = ds.getConnection();
		logger.info(con.toString());
		con.close();
		
	}

}
