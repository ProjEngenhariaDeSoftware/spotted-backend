package com.spotted.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	
	@Id
	@Column(name = "email")
	@NotEmpty(message = "email can not be empty")
	private String email;
	
	@Column(name = "username", unique = true)
	@NotNull(message = "username can not be null")
	@NotEmpty(message = "username can not be empty")
	private String username;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JoinColumn(name = "notification_id", referencedColumnName = "id")
	@JsonManagedReference
	private Set<Notification> notifications;

	
	@Column(name = "image", columnDefinition = "TEXT")
	@NotNull(message = "image can not be null")
	@NotEmpty(message = "image can not be empty")
	private String image;
	
	public User() {}

	public User(String email, String username, String image) {
		this.email = email;
		this.username = username;
		this.image = image;
		this.notifications = new HashSet<>();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addNotification(Notification notification) {
		this.notifications.add(notification);
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	public Set<Notification> getNotifications() { return this.notifications; }


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(email, user.email) && Objects.equals(username, user.username);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, username);
	}
	
}
