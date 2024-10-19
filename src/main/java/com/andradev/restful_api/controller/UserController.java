package com.andradev.restful_api.controller;

import com.andradev.restful_api.model.User;
import com.andradev.restful_api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User newUser) {
		var userCreated = userService.create(newUser);
		
		// this returns an url with the id of the newly created user
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(userCreated.getId())
			.toUri();
		
		return ResponseEntity.created(location).body(userCreated);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable UUID id) {
		return ResponseEntity.ok(userService.findById(id));
	}
}
