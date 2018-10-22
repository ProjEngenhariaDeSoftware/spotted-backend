package com.spotted.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotted.models.Post;
import com.spotted.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public Post save(Post post) {
		post.setDatetime(LocalDateTime.now());
		return this.postRepository.save(post);
	}
	
	public List<Post> getAll() {
		return this.postRepository.findAll();
	}
}
