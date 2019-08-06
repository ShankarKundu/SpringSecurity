package com.example.Springsecurity.service;

import com.example.Springsecurity.domain.CustomUserDetails;
import com.example.Springsecurity.domain.User;
import com.example.Springsecurity.domain.infrastucture.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepositary userRepositary;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Optional<User> user = userRepositary.findByUserName(name);

		User user1 = user.orElseThrow(() -> new UsernameNotFoundException("UserName not Found"));
		return new CustomUserDetails(new CustomUserDetails(user1));
	}
}
