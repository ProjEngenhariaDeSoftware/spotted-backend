package com.spotted.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.spotted.enums.PostTypes;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
	
	@Column(name = "nickname")
	@NotNull(message = "nickname can not be null")
	@NotEmpty(message = "nickname can not be empty")
	private String nickname;
	
	@Column(name = "type")
	@NotNull(message = "Type can not be null")
	@NotEmpty(message = "Type can not be empty")
	private PostTypes type;
	
	@Column(name = "text")
	private String text;
	
	@Lob
	@Column(name = "image")
	private byte[] image;
	
	@Column(name = "datetime")
	@NotNull(message = "Datetime can not be null")
	@NotEmpty(message = "Datetime can not be empty")
	private Date datetime;
	
	public Post() {}
	
	public Post(Long id, String nickname, PostTypes type, String text, byte[] image, Date datetime) {
		this.id = id;
		this.nickname = nickname;
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

	public String getnickname() {
		return nickname;
	}

	public void setnickname(String nickname) {
		this.nickname = nickname;
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

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
