package com.realgnu.mySpring.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	@RequestMapping("/dashboard.do")
	public String dashboard() {
		return "tiles.dashboard";
	}
}
