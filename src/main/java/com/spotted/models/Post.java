package com.spotted.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spotted.enums.PostTypes;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "email")
	@NotNull(message = "email can not be null")
	@NotEmpty(message = "email can not be empty")
	private String email;
	
	@Column(name = "type")
	@NotNull(message = "Type can not be null")
	@Enumerated(EnumType.STRING)
	private PostTypes type;
	
	@Column(name = "text")
	private String text;
	
	@Lob
	@Column(name = "image")
	private byte[] image;
	
	@Column(name = "datetime")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime datetime;
	
	public Post() {}
	
	public Post(String email, String text, byte[] image) {
		this.email = email;
		this.text = text;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PostTypes getType() {
		return type;
	}

	public void setType(PostTypes type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
}
