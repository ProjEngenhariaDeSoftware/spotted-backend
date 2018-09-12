package com.spotted.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "email", unique=true)
	@NotNull(message = "User email can not be null")
	@NotEmpty(message = "User email can not be empty")
	private String email;
	
	public User() {}

	public User(String nickname, String email) {
		this.nickname = nickname;
		this.email = email;
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
