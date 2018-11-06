package com.spotted.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotted.models.Notification;
import com.spotted.models.User;
import com.spotted.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	NotificationService notificationService;
	
	public User save(User user) {
		return this.userRepository.save(user);
	}
	
	public List<User> getAll() {
		return this.userRepository.findAll();
	}

	public List<User> findUserByUsername(String username) {
		return this.userRepository.findUserByUsername(username);
	}

	public User get(String email) throws Exception {
		if (!this.userRepository.existsById(email)) {
			throw new Exception("There is not a user registered with this id in the system");
		}
		return this.userRepository.findById(email).get();
	}
	
	public User findUserByEmail(String email) {
		return this.userRepository.findUserByEmail(email);
	}

	public User update(User user) {
		if (!this.userRepository.existsById(user.getEmail())) {
			return null;
		}
		User find = this.findUserByEmail(user.getEmail());
		find.setUsername(user.getUsername());
		this.save(find);
		return find;
	}

	public User notify(String id, Notification notification) throws Exception {
		if(!this.userRepository.existsById(id)) {
			throw new Exception("There is not a user registered with this id in the system");
		}
		this.notificationService.save(notification);
		User user = this.userRepository.getOne(id);
		user.addNotification(notification);
		return this.userRepository.save(user);
	}
}
