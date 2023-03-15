package com.springboot.admin.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.admin.service.UserService;

@RestController
@CrossOrigin("*")
public class UserRestController {

	private UserService userService;

	public UserRestController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public boolean checkIfEmailExists(@RequestParam(name="email", defaultValue = "")String email) {
		return userService.loadUserByEmail(email) != null;
	}
}
