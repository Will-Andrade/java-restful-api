package com.andradev.restful_api.service;

import com.andradev.restful_api.model.User;

import java.util.UUID;

public interface UserService {
	
	User findById(UUID id);
	
	User create(User newUser);
}
