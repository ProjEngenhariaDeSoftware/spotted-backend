package com.spotted.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "spotted")
public class Spotted {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "location")
	private String location;

	@Column(name = "course")
	private String course;

	@Column(name = "text")
	@NotNull(message = "Spotted text can not be null")
	@NotEmpty(message = "Spotted text can not be empty")
	private String text;

	@Column(name = "image")
	private byte[] image;

	@Column(name = "visible")
	private boolean visible;

	public Spotted() {
	}

	public Spotted(String location, String course, String text, byte[] image, boolean visible) {
		this.location = location;
		this.course = course;
		this.text = text;
		this.image = image;
		this.visible = visible;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
