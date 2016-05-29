package com.lucky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String loginGET(){
		return "/login/login";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String loginPOST(String id, String pwd){
		//로그인이 완료되면 기존에 보고있던 페이지로 이동을 시켜줘야된다.
		return "redirect:/";
	}
	
}
