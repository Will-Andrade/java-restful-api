package com.andradev.restful_api.service.impl;

import com.andradev.restful_api.model.User;
import com.andradev.restful_api.repository.UserRepository;
import com.andradev.restful_api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(UUID id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	@Override
	public User create(User newUser) {
		if (newUser.getId() != null && userRepository.existsById(newUser.getId())) {
			throw new IllegalArgumentException("This User id already exists.");
		}
		
		return userRepository.save(newUser);
	}
}
