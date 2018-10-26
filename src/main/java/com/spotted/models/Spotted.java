package com.spotted.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "spotted")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Spotted {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "course")
	private String course;
	
	@Column(name = "text")
	@NotNull(message = "Spotted text can not be null")
	@NotEmpty(message = "Spotted text can not be empty")
	private String text;
	
	@Lob
	@Column(name = "image")
	private byte[] image;
	
	@Column(name = "visible")
	private boolean visible;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "spotted_id", referencedColumnName = "id")
	private Set<Comment> comments;
	
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
	
	public Set<Comment> getComments() {
		return comments;
	}
	
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
}
