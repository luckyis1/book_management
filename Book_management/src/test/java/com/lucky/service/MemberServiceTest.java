package com.lucky.service;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lucky.domain.MemberVO;
import com.lucky.persistence.MemberDAOTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberServiceTest {

	@Inject
	private MemberService service;

	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Test
	public void getMemberListTest(){
		List<MemberVO> vo = service.getMemberList();
		for (MemberVO memberVO : vo) {
			logger.info(memberVO.toString());
		}
	}
	
	//서비스와 관련된 모든 테스트 실행해볼것.

}
