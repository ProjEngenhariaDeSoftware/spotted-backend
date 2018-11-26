package com.spotted.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;

import com.spotted.models.User;
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
	
	public Notification viewNotification(@PathVariable Long id) {
		Notification notification = this.notificationRepository.getOne(id);
		notification.setVisualized(true);
		return this.notificationRepository.save(notification);
	}
	
	public void save(String publicationType, Long publicationId, User commenter, List<String> markedEmails) throws Exception {
		for (int i = 0; i < markedEmails.size(); i++) {
			String email = this.userRepository.getEmail(markedEmails.get(i));
			Notification notification = new Notification(publicationType, publicationId, commenter, email);
			notification.setDatetime(LocalDateTime.now(ZoneId.of("America/Recife")));
			System.out.print(this.notificationRepository.save(notification).getMarkedEmail());
		}
	}

	public List<Notification> findByEmail(String email) {
		List<Notification> notifications = this.notificationRepository.findByEmail(email);
		Collections.sort(notifications);
		return notifications;
	}
}
