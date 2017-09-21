package com.realgnu.mySpring.security.config;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class SecureErrorController {
	private static Logger logger = Logger.getLogger(SecureErrorController.class);
	@RequestMapping("/403.do")
	public String error403() {
		return "tiles.error.403";
	}
	@RequestMapping("/404.do")
	public String error404() {
		return "notiles.error.404";
	}
}
