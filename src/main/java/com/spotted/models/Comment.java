package com.spotted.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    
    @ManyToOne
    @NotNull(message = "Commenter can not be null")
	@JoinColumn(name = "commenter_id", referencedColumnName = "email")
    private User commenter;
    
    @Column(name = "spotted_id")
    private Long spottedId;

    public Comment() {
    }

    public Comment(String userMentioned, String comment, User commenter) {
        this.userMentioned = userMentioned;
        this.comment = comment;
        this.commenter = commenter;
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

    public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}
	
	public Long getSpottedId() {
		return spottedId;
	}
	
	public void setSpottedId(Long spottedId) {
		this.spottedId = spottedId;
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