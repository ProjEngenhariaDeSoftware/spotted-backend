package com.spotted.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotted.models.Notification;
import com.spotted.repositories.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	NotificationRepository notificatonRepository;
	
	public Notification save(Notification notification) {
		return this.notificatonRepository.save(notification);
	}
	
	
}
