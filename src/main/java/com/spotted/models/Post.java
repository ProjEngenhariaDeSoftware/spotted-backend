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
}
