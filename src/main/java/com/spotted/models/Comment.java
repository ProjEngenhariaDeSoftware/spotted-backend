package com.spotted.models;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
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

    @ElementCollection
    private List<String> usersMentioned;

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

    public Comment(List<String> usersMentioned, String comment, User commenter) {
        this.usersMentioned = usersMentioned;
        this.comment = comment;
        this.commenter = commenter;
    }

    public List<String> getUsersMentioned() {
        return usersMentioned;
    }

    public void setUsersMentioned(List<String> usersMentioned) {
        this.usersMentioned = usersMentioned;
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
	
	public void addUserMentioned(String username) {
    	this.usersMentioned.add(username);
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(id, comment1.id) &&
                Objects.equals(usersMentioned, comment1.usersMentioned) &&
                Objects.equals(comment, comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usersMentioned, comment);
    }
	
	@Override
	public String toString() {
		String s ="";
		for(int i = 0; i < usersMentioned.size(); i++) {
			s += usersMentioned.get(i);
		}
		return s;
	}
}