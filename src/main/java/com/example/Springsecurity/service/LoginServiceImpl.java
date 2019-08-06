package com.example.Springsecurity.service;

import com.example.Springsecurity.domain.Roles;
import com.example.Springsecurity.domain.User;
import com.example.Springsecurity.domain.infrastucture.UserRepositary;
import com.example.Springsecurity.domain.infrastucture.RolesRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserRepositary userRepositary;
	@Autowired
	RolesRepositary rolesRepositary;

	@Override
	public String register(User user) {
		User byuserName = userRepositary.findByUserName(user.getUserName()).get();
		if (byuserName != null) {
			return "Account already created";
		}
		List<Roles> rolesList = rolesRepositary.findByRoleEventIn(user.getRoles().stream().map(role -> role.getRoleEvent()).collect(Collectors.toList()));
		user.setRoles(rolesList);
		userRepositary.save(user);
		return "Successfully login";
	}

	@Override
	public String delete(String username) {
		userRepositary.deleteByuserName(username);
		return "Successfully deleted";
	}
}
