package com.example.Springsecurity.controller;

import com.example.Springsecurity.domain.User;
import com.example.Springsecurity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	ResponseEntity register(@RequestBody User user){
		return ResponseEntity.ok().body(loginService.register(user));
	}
	@DeleteMapping("/delete/account/{username}")
	ResponseEntity detele(@PathVariable String username){
		return ResponseEntity.ok().body(loginService.delete(username));
	}
}
