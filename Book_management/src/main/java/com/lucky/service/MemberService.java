package com.lucky.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lucky.domain.MemberVO;
import com.lucky.persistence.MemberDAO;

@Service
public class MemberService {
	
	@Inject
	MemberDAO dao;
	
	public List<MemberVO> getMemberList(){
		return dao.selectAll();
	}
	
	public MemberVO getMember(String id){
		return dao.selectMember(id);
	}
	
	public void insertMember(MemberVO vo){
		dao.insertMember(vo);
	}
	
	public void deleteMember(String id){
		dao.deleteMember(id);
	}
	
	public void updateMember(MemberVO vo){
		dao.updateMember(vo);
	}
}
