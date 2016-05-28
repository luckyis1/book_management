package com.lucky.persistence;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lucky.domain.MemberVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class MemberDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Inject
	private MemberDAO dao;

	@Test
	public void insertTest() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setId("Insung");
		vo.setPwd("1234");
		vo.setName("cocomong");
		vo.setEmail("test@naver.com");
		vo.setJumin("8301237");
		
		dao.insertMember(vo);
	}
	
	@Test
	public void selectTest() throws Exception {
		List<MemberVO> list=dao.selectAll();
		for (MemberVO memberVO : list) {
			logger.info(memberVO.toString());
		}
	}
	@Test
	public void deleteTest() throws Exception {
		String id="Insung";
		dao.deleteMember(id);
	}

	@Test
	public void updateTest() throws Exception {
		String id="Insung";
		MemberVO vo= dao.selectMember(id);
		vo.setPwd("rlaguswns3");
		vo.setEmail("test2@naver.com");
		dao.updateMember(vo);
	}

}
