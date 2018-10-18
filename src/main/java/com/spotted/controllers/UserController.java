package com.spotted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> getAll() {
		return this.userRepository.findAll();
	}

}
