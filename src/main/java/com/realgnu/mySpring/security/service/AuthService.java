package com.realgnu.mySpring.security.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.realgnu.mySpring.common.mybatis.CustomCamelMap;

public interface AuthService {
	List<CustomCamelMap> readAuthorities();
	CustomCamelMap readAuthorityByName(String authName);
	List<GrantedAuthority> readAuthoritiesByUri(String uri);
	List<CustomCamelMap> readAuthMenuList(String username);
	void clearCacheAuthMenuList(String username);
}
