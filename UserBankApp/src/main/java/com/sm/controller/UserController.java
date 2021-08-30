package com.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.entity.User;
import com.sm.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("/signup")
	public ResponseEntity<String> signupUser(@RequestBody User user) {
		userServiceImpl.signUpUser(user);
		return ResponseEntity.ok("User Signup Successfully");
	}

	@GetMapping("/signin/{emailId}/{password}")
	public ResponseEntity<Boolean> userSignIn(@PathVariable String emailId, @PathVariable String password) {
		return ResponseEntity.ok(userServiceImpl.signInUser(emailId, password));

	}

}
