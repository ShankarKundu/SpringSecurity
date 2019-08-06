package com.example.Springsecurity.service;

import com.example.Springsecurity.domain.Roles;

public interface RoleService {
	Roles insert(Roles role);
	Roles getRole(String name);
}
