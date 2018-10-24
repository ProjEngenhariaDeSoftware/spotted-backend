package com.spotted.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer")
public class User {
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "nickname", unique=true)
	@NotNull(message = "User nickname can not be null")
	@NotEmpty(message = "User nickname can not be empty")
	private String nickname;
	
	public User() {}
	
	public User(String email, String nickname) {
		this.email = email;
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
