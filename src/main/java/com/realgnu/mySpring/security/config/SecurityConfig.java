package com.realgnu.mySpring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.realgnu.mySpring.security.service.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired 
	UserService userService;
	
	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userService)
		.passwordEncoder(userService.getPasswordEncoder())
		.and()
		.authenticationProvider(customAuthenticationProvider);
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		.and().authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/member/login.do")
			.loginProcessingUrl("/member/loginDo.do")
			.failureHandler(getCustomAuthenticationFailureHandler())
			.permitAll()
			.and()
		.logout()
			.permitAll()
//		.loginPage("/member/login.do").loginProcessingUrl("/member/loginDo.do").failureUrl("/member/login.do")
		;
		;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/*.css");
		web.ignoring().antMatchers("/*.js");
	}
	
	@Bean
	public CustomAuthenticationFailureHandler getCustomAuthenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

}
