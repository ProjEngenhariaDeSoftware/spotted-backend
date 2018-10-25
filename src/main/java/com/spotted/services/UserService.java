package com.spotted.services;

import java.util.List;

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
	
	public List<User> getAll() {
		return this.userRepository.findAll();
	}

	public List<User> findUserByNickname(String nickname) {
		return this.userRepository.findUserByNickname(nickname);
	}

	public User findUserByEmail(String email) {
		return this.userRepository.findUserByEmail(email);
	}

	public User change(User user, String newNickname) throws Exception {
		if (!this.userRepository.existsById(user.getEmail())) {
			throw new Exception("Email not found!");
		}
		user.setNickname(newNickname);
		this.save(user);
		return user;
	}

}
