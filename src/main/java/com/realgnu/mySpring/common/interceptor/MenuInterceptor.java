package com.realgnu.mySpring.common.interceptor;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.realgnu.mySpring.common.mybatis.CustomCamelMap;
import com.realgnu.mySpring.security.config.SecurityConst;
import com.realgnu.mySpring.security.service.AuthService;

@Component
public class MenuInterceptor extends HandlerInterceptorAdapter{
	private static Logger logger = Logger.getLogger(MenuInterceptor.class);
	@Autowired
	AuthService authService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		Principal principal = request.getUserPrincipal();
		
		if (principal != null) {
			String username = request.getUserPrincipal().getName();
			List<CustomCamelMap> myMenuList = authService.readAuthMenuList(username);
			request.getSession().setAttribute(SecurityConst.SESSION_USER_MENU_LIST, myMenuList);
			String requestUri = request.getRequestURI();
			if (requestUri.contains("?"))
				requestUri = requestUri.substring(0, requestUri.indexOf("?"));
			request.getSession().setAttribute("requestUri", requestUri);
		}
		return true;
	}
}
