package com.spotted.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spotted.models.Notification;
import com.spotted.repositories.NotificationRepository;
import com.spotted.repositories.UserRepository;

@Service
public class NotificationService {
	
	@Autowired
	NotificationRepository notificationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Notification save(Notification notification) {
		return this.notificationRepository.save(notification);
	}
	
	public Notification viewNotification(@PathVariable Long id) {
		Notification notification = this.notificationRepository.getOne(id);
		notification.setVisualized(true);
		return this.notificationRepository.save(notification);
	}
	
	public Notification notify(Notification notification) throws Exception {
		if(!this.userRepository.existsById(notification.getMarkedEmail())) {
			throw new Exception("There is not a user registered with this id in the system");
		}
		return this.save(notification);
	}

	public List<Notification> findByEmail(String email) {
		return this.notificationRepository.findByEmail(email);
	}
}
