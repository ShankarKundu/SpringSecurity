package com.example.Springsecurity.service;

import com.example.Springsecurity.domain.User;

public interface LoginService {
	String register(User user);

	String delete(String username);
}
