package com.spotted.models;

import java.awt.Image;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.spotted.enums.*;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
	
	@Column(name = "username")
	@NotNull(message = "Username can not be null")
	@NotEmpty(message = "Username can not be empty")
	private String username;
	
	@Column(name = "type")
	@NotNull(message = "Type can not be null")
	@NotEmpty(message = "Type can not be empty")
	private PostTypes type;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "image")
	private Image image;
	
	@Column(name = "datetime")
	@NotNull(message = "Datetime can not be null")
	@NotEmpty(message = "Datetime can not be empty")
	private Date datetime;
	
	public Post() {}
	
	public Post(Long id, String username, PostTypes type, String text, Image image, Date datetime) {
		this.id = id;
		this.username = username;
		this.type = type;
		this.text = text;
		this.image = image;
		this.datetime = datetime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
