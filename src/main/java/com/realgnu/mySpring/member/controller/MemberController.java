package com.realgnu.mySpring.member.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.realgnu.mySpring.security.domain.User;
import com.realgnu.mySpring.security.service.AuthService;
import com.realgnu.mySpring.security.service.UserService;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static Logger logger = Logger.getLogger(MemberController.class);
	@Autowired
	UserService userService;

	@Autowired
	AuthService authService;
	
	@RequestMapping("/login.do")
	public String login(Authentication auth) {
		if(auth != null && auth.isAuthenticated()) {
			logger.debug("Already logged in.");
			return "redirect:/";
		}
		logger.debug("login.");
		return "notiles.login";
	}
	
	@RequestMapping("/register.do")
	public String register(Authentication auth) {
		if(auth != null && auth.isAuthenticated()) {
			logger.debug("Already logged in.");
			return "redirect:/";
		}
		logger.debug("register.");
		
		return "notiles.register";
	}
	
	@RequestMapping(value="/registerDo.do", method=RequestMethod.POST)
	public String registerDo (
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("repassword") String repassword
			) {
		logger.debug("email : " + email);
		logger.debug("password: " + password);
		logger.debug("repassword: " + repassword);
		
		User user = new User();
		user.setUsername(email);
		user.setPassword(password);

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>() ;
		
		String guestAuthNo = authService.readAuthorityByName("ANONYMOUS").get("authNo").toString();
		logger.debug("guestAuthNo :" + guestAuthNo);
		authorities.add(new SimpleGrantedAuthority(guestAuthNo));
		user.setAuthorities(authorities);
		userService.createUser(user);
		return "notiles.login";
	}
}