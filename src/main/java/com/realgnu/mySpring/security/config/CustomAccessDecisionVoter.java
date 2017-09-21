package com.realgnu.mySpring.security.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import com.realgnu.mySpring.security.service.AuthService;

public class CustomAccessDecisionVoter implements AccessDecisionVoter<FilterInvocation> {

	private static Logger logger = Logger.getLogger(CustomAccessDecisionVoter.class);
	
	@Autowired
	AuthService authService;
	
	@Autowired
	SecurityConfigProperties securityConfigProperties;
	
	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int vote(Authentication authentication, FilterInvocation object, Collection<ConfigAttribute> attributes) {
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> userAuthorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
		String uri = object.getRequestUrl();
		logger.debug("URI : " + uri + " | Current User : " + authentication.getName());
		if (isExcludeUri(uri)) {
			logger.debug(">> Access check excluded. so access granted.");
			return ACCESS_GRANTED;
		}
		logger.debug("User's Authorities : " + Arrays.asList(userAuthorities) );
		Collection<GrantedAuthority> uriAuthorities = getGrantedAuthoritiesByUri(uri);
		if (uriAuthorities == null || uriAuthorities.size() == 0) {
			logger.debug("Uri has no authorities. so access abstrain..");
			return ACCESS_ABSTAIN;
		}
		for (GrantedAuthority userAuthority : userAuthorities) {
			for (GrantedAuthority uriAuthority : uriAuthorities) {
				if (userAuthority.equals(uriAuthority)) {
					logger.debug("Uri has " + uriAuthority.toString() + " authority. so access granted.");
					return ACCESS_GRANTED;
				}
			}
		}
		logger.debug("uri has no authority. so access denied.");
		return ACCESS_DENIED;
	}

	private Collection<GrantedAuthority> getGrantedAuthoritiesByUri (String uri) {
		if ("".equals(uri)) {
			return null;
		}
		if (uri.contains("?")) {
			uri = uri.substring(0, uri.indexOf("?"));
		}
		return authService.readAuthoritiesByUri(uri);
	}
	
	private boolean isExcludeUri(String uri) {
		if ("/".equals(uri)) {
			return true;
		}
		List<String> excludeUriPrefixes = securityConfigProperties.getExcludeUriPrefix();
		for (String excludeUriPrefix : excludeUriPrefixes) {
			if (uri.startsWith(excludeUriPrefix)) {
				return true;
			}
		}
		return false;
	}
}
