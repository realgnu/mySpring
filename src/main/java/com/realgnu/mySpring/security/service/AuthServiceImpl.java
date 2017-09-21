package com.realgnu.mySpring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.realgnu.mySpring.common.mybatis.CustomCamelMap;
import com.realgnu.mySpring.security.mapper.AuthMapper;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthMapper authMapper;
	
	@Override
	public List<CustomCamelMap> readAuthorities() {
		return authMapper.readAuthorities("");
	}

	@Override
	public CustomCamelMap readAuthorityByName(String authName) {
		return authMapper.readAuthorities(authName).get(0);
	}

	@Override
	@Cacheable(key = "#uri", value = "uriAuthorities")
	public List<GrantedAuthority> readAuthoritiesByUri(String uri) {
		return authMapper.readAuthoritiesByUri(uri);
	}

	@Override
	@Cacheable(key = "#username", value = "myMenuList")
	public List<CustomCamelMap> readAuthMenuList(String username) {
		return authMapper.readAuthMenuList(username);
	}

	@Override
	@CacheEvict(key = "#username", value = "myMenuList")
	public void clearCacheAuthMenuList(String username) {}
	
	
}
