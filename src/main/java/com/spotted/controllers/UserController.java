package com.spotted.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import com.spotted.models.User;
import com.spotted.repositories.UserRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User save(@RequestBody User user) {
		return this.userRepository.save(user);
	}

}
