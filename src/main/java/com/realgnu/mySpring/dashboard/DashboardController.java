package com.realgnu.mySpring.dashboard;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realgnu.mySpring.common.mybatis.CustomCamelMap;
import com.realgnu.mySpring.security.service.AuthService;

@Controller
public class DashboardController {
	private static Logger logger = Logger.getLogger(DashboardController.class);
	@Autowired
	AuthService authService;
	
	@RequestMapping("/dashboard.do")
	public String dashboard(Authentication auth) {
//		List<CustomCamelMap> list = authService.readAuthMenuList(auth.getName());
//		for (CustomCamelMap map : list) {
//			logger.debug(map.get("menuName"));
//		}
		return "tiles.dashboard";
	}
}
