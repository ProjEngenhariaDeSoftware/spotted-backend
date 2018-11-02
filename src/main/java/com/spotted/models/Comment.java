package com.spotted.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_mentioned")
    private String userMentioned;

    @Column(name = "comment")
    @NotNull(message = "Comment can not be null")
    @NotEmpty(message = "Comment can not be empty")
    private String comment;
	
	@Column(name = "username_commenter")
	@NotNull(message = "Username commenter can not be null")
	@NotEmpty(message = "Username commenter can not be empty")
    private String usernameCommenter;
	
	@Lob
	@Column(name = "img_commenter")
	private byte[] imgCommenter;

    public Comment() {
    }

    public Comment(String userMentioned, String comment, String usernameCommenter, byte[] imgCommenter) {
        this.userMentioned = userMentioned;
        this.comment = comment;
        this.usernameCommenter = usernameCommenter;
        this.imgCommenter = imgCommenter;
    }

    public String getUserMentioned() {
        return userMentioned;
    }

    public void setUserMentioned(String userMentioned) {
        this.userMentioned = userMentioned;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public String getUsernameCommenter() {
		return usernameCommenter;
	}
	
	public void setUsernameCommenter(String usernameCommenter) {
		this.usernameCommenter = usernameCommenter;
	}
	
	public byte[] getImgCommenter() {
		return imgCommenter;
	}
	
	public void setImgCommenter(byte[] imgCommenter) {
		this.imgCommenter = imgCommenter;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(id, comment1.id) &&
                Objects.equals(userMentioned, comment1.userMentioned) &&
                Objects.equals(comment, comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userMentioned, comment);
    }
}