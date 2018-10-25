package com.spotted.services;

import com.spotted.models.Comment;
import com.spotted.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment save(Comment comment) {
        return this.commentRepository.save(comment);
    }
}
