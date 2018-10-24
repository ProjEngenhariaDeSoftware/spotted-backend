package com.spotted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spotted.models.User;
import com.spotted.services.UserService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> getAll() {
		return this.userService.getAll();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User save(@RequestBody User user) {
		return this.userService.save(user);
	}
	
	@RequestMapping(value = "/user/{newNickname}", method = RequestMethod.PUT)
	public User change(@RequestBody User user, @PathVariable String newNickname) throws Exception {
		return this.userService.change(user, newNickname);
	}
	
	
	@RequestMapping(value = "/user/nickname/{nickname}", method = RequestMethod.GET)
	public List<User> findUserByNickname(@PathVariable String nickname) {
		return this.userService.findUserByNickname(nickname);
	}
	
	@RequestMapping(value = "/user/email/{email}", method = RequestMethod.GET)
	public User findUserByEmail(@PathVariable String email) {
		return this.userService.findUserByEmail(email);
	}

}
