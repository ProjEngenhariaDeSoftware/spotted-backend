package com.spotted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spotted.models.Notification;
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
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public User update(@RequestBody User user) {
		return this.userService.update(user);
	}
	
	
	@RequestMapping(value = "/user/username/{username}", method = RequestMethod.GET)
	public List<User> findUserByUsername(@PathVariable String username) {
		return this.userService.findUserByUsername(username);
	}
	
	@RequestMapping(value = "/user/email/{email}", method = RequestMethod.GET)
	public User findUserByEmail(@PathVariable String email) {
		return this.userService.findUserByEmail(email);
	}
	
	@RequestMapping(value = "/user/{email}/notify", method = RequestMethod.PUT)
	public User notify(@PathVariable String email, @RequestBody Notification notification) throws Exception {
		return this.userService.notify(email, notification);
	}
}
