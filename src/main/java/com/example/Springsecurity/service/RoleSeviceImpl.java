package com.example.Springsecurity.service;

import com.example.Springsecurity.domain.Roles;
import com.example.Springsecurity.domain.infrastucture.RolesRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleSeviceImpl implements RoleService {
	@Autowired
	RolesRepositary rolesRepositary;

	@Override
	public Roles insert(Roles role) {
		return rolesRepositary.save(role);
	}

	@Override
	public Roles getRole(String name) {
		return rolesRepositary.findByRoleEvent(name);
	}
}
