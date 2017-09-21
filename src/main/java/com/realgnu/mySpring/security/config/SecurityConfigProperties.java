package com.realgnu.mySpring.security.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "custom-access-decision-manager")
public class SecurityConfigProperties {
	private List<String> excludeUriPrefix;
	public List<String> getExcludeUriPrefix() {
		return this.excludeUriPrefix;
	}
	public void setExcludeUriPrefix(List<String> excludeUriPrefix) {
		this.excludeUriPrefix = excludeUriPrefix;
	}
}
