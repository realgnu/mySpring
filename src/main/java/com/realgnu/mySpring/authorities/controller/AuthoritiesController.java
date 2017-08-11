package com.realgnu.mySpring.authorities.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthoritiesController {
	@RequestMapping("/authorities/authority1.do")
	public String authority1() {
		return "tiles.authority1";
	}
	@RequestMapping("/authorities/authority2.do")
	public String authority2() {
		return "tiles.authority2";
	}
	@RequestMapping("/authorities/authority3.do")
	public String authority3() {
		return "tiles.authority3";
	}
}
