package com.spotted.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotted.models.User;
import com.spotted.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    UserRepository userRepository;
	
	public User save(User user) {
		return this.userRepository.save(user);
	}

}
