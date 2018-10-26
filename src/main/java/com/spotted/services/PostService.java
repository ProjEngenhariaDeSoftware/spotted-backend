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

	public List<Post> searchByEmail(String email) {
		return this.postRepository.postsByEmail(email);
	}
	
	public Post searchById(Long id) {
		return this.postRepository.postsById(id);
	}

	public Post deleteById(Long id) {
		Post deleted = this.searchById(id);
		this.postRepository.deleteById(id);
		return deleted;
	}
}
