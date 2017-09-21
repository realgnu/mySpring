package com.realgnu.mySpring.security.config;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;

import com.realgnu.mySpring.security.service.AuthService;

public class SessionDestroyListener implements ApplicationListener<SessionDestroyedEvent> {
	private static Logger logger = Logger.getLogger(SessionDestroyListener.class);
	@Autowired
	AuthService authService;
	
	public SessionDestroyListener() {
		super();
		logger.debug("SessionDestroyListener is created.");
	}
	
	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		logger.debug("SessionDestroyListener.onApplicationEvent is called.");
		List<SecurityContext> contexts = event.getSecurityContexts();
		if (!contexts.isEmpty() ) {
			for(SecurityContext sc : contexts) {
				logger.debug("Menu Cache Clear : " + sc.getAuthentication().getName());
				authService.clearCacheAuthMenuList(sc.getAuthentication().getName());
			}
		}
	}

}
