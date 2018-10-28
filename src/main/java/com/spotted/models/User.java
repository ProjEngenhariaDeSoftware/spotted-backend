package com.spotted.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class User {

	@Id
	@Column(name = "email")
	@NotEmpty(message = "email can not be empty")
	private String email;
	
	@Column(name = "username", unique=true)
	@NotNull(message = "username can not be null")
	@NotEmpty(message = "username can not be empty")
	private String username;
	
	public User() {}
	
	public User(String email, String username) {
		this.email = email;
		this.username = username;
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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(email, user.email) &&
				Objects.equals(username, user.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, username);
	}

}
