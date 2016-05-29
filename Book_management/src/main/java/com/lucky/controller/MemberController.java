package com.lucky.controller;


import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucky.domain.MemberVO;
import com.lucky.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String memberListGET(Model model){
		model.addAttribute("memberList",memberService.getMemberList());
		return "member/member_list";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String memberJoinGET(){//화면을 보여주는애
		return "member/member_join";
	}
	
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public @ResponseBody MemberVO memberJoinGET(@PathVariable(value="id") String id
								//@PathVariable(value="name") String name, 
								//Model model 기존에 페이지 전환 방식을 json 방식으로 변환
								){//화면을 보여주는애
		logger.info(id);
		return memberService.getMember(id);
	}
	
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String memberJoinPOST(MemberVO vo){
		logger.info(vo.toString());
		memberService.insertMember(vo);
		return "redirect:/member";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public @ResponseBody String memberDeletePOST(@PathVariable(value="id") String id){
		memberService.deleteMember(id);
		return "SUCCESS";
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public @ResponseBody List<MemberVO> getMemberList(){
		return memberService.getMemberList();
	}
	
}
