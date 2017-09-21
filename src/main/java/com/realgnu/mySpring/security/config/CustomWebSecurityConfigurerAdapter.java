package com.realgnu.mySpring.security.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.realgnu.mySpring.security.service.UserService;

@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
	@Autowired 
	UserService userService;
	
	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;
	
//	@Autowired
//	CustomAccessDecisionManager customAccessDecisionManager;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userService)
		.passwordEncoder(userService.getPasswordEncoder())
		.and()
		.authenticationProvider(customAuthenticationProvider)
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf()
		    .and()
		    .authorizeRequests()
		    .antMatchers(
		    		"/member/register.do"
		    		, "/member/registerDo.do"
		    		).permitAll()
		    .anyRequest().fullyAuthenticated()
		    .accessDecisionManager(getAccessDecisionManager())
		    .and()
		.formLogin()
			.loginPage("/member/login.do")
			.loginProcessingUrl("/member/loginDo.do")
			.failureHandler(getCustomAuthenticationFailureHandler())
			.permitAll()
			.and()
		.logout()
			.addLogoutHandler(getCustomLogoutHandler())
			.logoutRequestMatcher(new AntPathRequestMatcher("/member/logoutDo.do"))
			.logoutSuccessUrl("/")
			.permitAll()
			.and()
		    .exceptionHandling().accessDeniedHandler(getAccessDeniedHandler())
		;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**/*");
	}
	
	@Bean
	public CustomAuthenticationFailureHandler getCustomAuthenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}
	@Bean
	public CustomLogoutHandler getCustomLogoutHandler() {
		return new CustomLogoutHandler();
	}
	@Bean
	public CustomAccessDeniedHandler getAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	@Bean
	public AccessDecisionManager getAccessDecisionManager() {
		List<AccessDecisionVoter<?>> voters = new ArrayList<AccessDecisionVoter<?>>();
		  voters.add(getExpressionVoter());
		  voters.add(getCustomAccessDecisionVoter());
		  return new CustomAccessDecisionManager(voters);
	}
	@Bean
	public WebExpressionVoter getExpressionVoter() {
		WebExpressionVoter voter = new WebExpressionVoter();
		DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
		handler.setDefaultRolePrefix("");
		voter.setExpressionHandler(handler);
		return voter;
	}
	@Bean
	public AccessDecisionVoter<FilterInvocation> getCustomAccessDecisionVoter() {
		return new CustomAccessDecisionVoter();
	}
	
	@Bean
	public ServletListenerRegistrationBean<HttpSessionEventPublisher> sessionListener()
    {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }
	@Bean
	public SessionDestroyListener sessionDestroyListener() {
		return new SessionDestroyListener();
	}
}
