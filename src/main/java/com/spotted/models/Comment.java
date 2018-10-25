package com.spotted.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userMentioned")
    private String userMentioned;

    @Column(name = "commenter")
    @NotNull(message = "Commenter can not be null")
    @NotEmpty(message = "Commenter can not be empty")
    private String commenter;

    @Column(name = "comment")
    @NotNull(message = "Comment can not be null")
    @NotEmpty(message = "Comment can not be empty")
    private String comment;

    public String getUserMentioned() {
        return userMentioned;
    }

    public void setUserMentioned(String userMentioned) {
        this.userMentioned = userMentioned;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}