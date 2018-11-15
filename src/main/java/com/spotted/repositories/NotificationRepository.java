package com.spotted.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spotted.models.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{
	
	@Query("select n from Notification n where n.commenter.email = ?1")
	List<Notification> findByEmail(String email);

}
