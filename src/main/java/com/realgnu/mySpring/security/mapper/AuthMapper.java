package com.realgnu.mySpring.security.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.realgnu.mySpring.common.mybatis.CustomCamelMap;

@Mapper
public interface AuthMapper {
	public List<CustomCamelMap> readAuthorities(String authName);
	public List<GrantedAuthority> readAuthoritiesByUri(String uri);
	public List<CustomCamelMap> readAuthMenuList(String username);
}
