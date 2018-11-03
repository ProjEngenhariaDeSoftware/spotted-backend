package com.spotted.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "notification")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Notification {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "publication_type")
	@NotNull(message = "Publication type can not be null")
	@NotEmpty(message = "Publication type can not be empty")
	private String publicationType;

	@Column(name = "publication_id")
	@NotNull(message = "Publication id can not be null")
	private Long publicationId;

	@Column(name = "username_commenter")
	@NotNull(message = "Username commenter can not be null")
	@NotEmpty(message = "Username commenter can not be empty")
	private String usernameUserMentioned;
	
	@Lob
	@Column(name = "img_commenter")
	private String imgCommenter;
	
	@Column(name = "username_user_commented")
	@NotNull(message = "Username of the user who commented can not be null")
	@NotEmpty(message = "Username of the user who commented can not be empty")
	private String usernameCommenter;
	
	public Notification() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsernameUserMentioned() {
		return usernameUserMentioned;
	}

	public void setUsernameUserMentioned(String usernameUserMentioned) {
		this.usernameUserMentioned = usernameUserMentioned;
	}

	public String getImgCommenter() {
		return imgCommenter;
	}

	public void setImgCommenter(String imgCommenter) {
		this.imgCommenter = imgCommenter;
	}

	public String getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}

	public Long getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(Long publicationId) {
		this.publicationId = publicationId;
	}
	
	public String getUsernameCommenter() {
		return usernameCommenter;
	}
	
	public void setUsernameCommenter(String usernameCommenter) {
		this.usernameCommenter = usernameCommenter;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notification other = (Notification) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
