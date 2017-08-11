package com.realgnu.mySpring.member.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realgnu.mySpring.security.service.UserService;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static Logger logger = Logger.getLogger(MemberController.class);
	@Autowired
	UserService userService;
	
	@RequestMapping("/login.do")
	public String login() {
		logger.debug("Come in.");
		return "notiles.login";
	}

}
