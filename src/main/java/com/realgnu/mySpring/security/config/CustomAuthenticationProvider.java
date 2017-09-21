package com.realgnu.mySpring.security.config;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.realgnu.mySpring.security.domain.User;
import com.realgnu.mySpring.security.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	UserService userService;
	
	private static Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		Collection<? extends GrantedAuthority> authorities;
		User user = (User) userService.loadUserByUsername(username);
		String dbPassword = user.getPassword();
		if(!userService.getPasswordEncoder().matches(password, dbPassword)) {
			logger.debug("Incorrect Password.");
			throw new BadCredentialsException("Incorrect Password.");
		}
		authorities = user.getAuthorities();

		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
