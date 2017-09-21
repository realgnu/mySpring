package com.realgnu.mySpring.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	private static Logger logger = Logger.getLogger(CustomAccessDeniedHandler.class);
	
	/**
	 * Description : 로그인한 후에만 호출된다.
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			logger.debug("User: " + auth.getName() + " attempted to access the protected URL: "
						+ request.getRequestURI());
			logger.debug("hi > " + accessDeniedException.getMessage());
      }
      response.sendRedirect(request.getContextPath() + "/error/403.do");
	}

}
