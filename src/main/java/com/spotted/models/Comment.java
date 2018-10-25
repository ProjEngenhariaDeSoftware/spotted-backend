package com.spotted.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comment")
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

    public Comment() {
    }

    public Comment(String userMentioned, String comment) {
        this.userMentioned = userMentioned;
        this.comment = comment;
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
}