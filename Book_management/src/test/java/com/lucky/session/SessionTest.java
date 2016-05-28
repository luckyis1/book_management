package com.lucky.session;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lucky.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SessionTest {

	private static final Logger logger = LoggerFactory.getLogger(SessionTest.class);
	
	
	@Inject
	SqlSession session;
	String namespace="com.lucky.mapper.MemberMapper";
	
	@Test
	public void test() {
		List<MemberVO> list=session.selectList(namespace+".selectAll");
		
		for (MemberVO memberVO : list) {
			logger.info(memberVO.toString());
		}
	}

}
