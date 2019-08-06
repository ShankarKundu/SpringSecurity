package com.example.Springsecurity.controller;

import com.example.Springsecurity.domain.Roles;
import com.example.Springsecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping("/role")
	ResponseEntity insertRole(@RequestBody Roles roles){
		return ResponseEntity.ok().body(roleService.insert(roles));
	}

}
