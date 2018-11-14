package com.spotted.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotted.models.Notification;
import com.spotted.repositories.NotificationRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class NotificationService {
	
	@Autowired
	NotificationRepository notificatonRepository;
	
	public Notification save(Notification notification) {
		return this.notificatonRepository.save(notification);
	}
	
	public Notification viewNotification(@PathVariable Long id) {
		Notification notification = this.notificatonRepository.getOne(id);
		notification.setVisualized(true);
		return this.notificatonRepository.save(notification);
	}
}
