package com.realgnu.mySpring.security.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realgnu.mySpring.security.domain.User;
import com.realgnu.mySpring.security.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.readUser(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
        user.setAuthorities(getAuthorities(username));
		return user;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities(String username) {
		List<GrantedAuthority> authorities = userMapper.readAuthorities(username); 
		return authorities; 
	}

	@Override
	public User readUser(String username) {
		User user = userMapper.readUser(username);
		user.setAuthorities(userMapper.readAuthorities(username));
		return user;
	}

	@Override
	@Transactional
	public void createUser(User user) {
		String password = user.getPassword();
		user.setPassword(this.passwordEncoder.encode(password));
		user.setUserNo(userMapper.readNewUserNo(user.getUsername()));
		userMapper.createUser(user);
		userMapper.createAuthority(user);
	}

	@Override
	public void deleteUser(String username) {
		userMapper.deleteUser(username);
		userMapper.deleteAuthority(username);
	}

	@Override
	public PasswordEncoder getPasswordEncoder() {
		return this.passwordEncoder;
	}
}
