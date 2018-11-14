package com.spotted.models;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

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
	
	@Column(name = "datetime")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime datetime;

    public Comment() {
    }
    public Comment(List<String> usersMentioned, String comment, User commenter, Long spottedId) {
        this.usersMentioned = usersMentioned;
        this.comment = comment;
        this.commenter = commenter;
        this.spottedId = spottedId;
        this.spottedId = spottedId;
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
	
	public LocalDateTime getDatetime() {
		return datetime;
	}
	
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(id, comment1.id) &&
                Objects.equals(Arrays.asList(usersMentioned.toArray()), Arrays.asList(comment1.usersMentioned.toArray())) &&
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