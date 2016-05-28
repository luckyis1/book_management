package com.lucky.persistence;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lucky.datasource.ConnectionTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SimpleDAOTest{

	private static final Logger logger = LoggerFactory.getLogger(ConnectionTest.class);
	
	@Inject
	SimpleDAO dao;
	
	@Test
	public void test() throws Exception {
		logger.info(dao.getTimeNow());
	}

}
