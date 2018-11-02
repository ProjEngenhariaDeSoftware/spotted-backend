package com.spotted.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "spotted")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	@JoinColumn(name = "comment_id", referencedColumnName = "id")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Set<Comment> comments;
	
	@Column(name = "datetime")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime datetime;
	
	public Spotted() {
	}
	
	public Spotted(String location, String course, String text, byte[] image, boolean visible) {
		this.location = location;
		this.course = course;
		this.text = text;
		this.image = image;
		this.visible = visible;
		this.comments = new HashSet<>();
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
	
	public boolean getVisible() {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Spotted spotted = (Spotted) o;
		return visible == spotted.visible &&
				Objects.equals(id, spotted.id) &&
				Objects.equals(location, spotted.location) &&
				Objects.equals(course, spotted.course) &&
				Objects.equals(text, spotted.text) &&
				Arrays.equals(image, spotted.image) &&
				Objects.equals(comments, spotted.comments);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id, location, course, text, visible, comments);
		result = 31 * result + Arrays.hashCode(image);
		return result;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}
	
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
}
