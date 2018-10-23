package com.spotted.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

	public List<Post> searchByNickname(String nickname) {
		List<Post> posts = new ArrayList<Post>();
		for (Post post: this.getAll()) {
			if (post.getNickname().equals(nickname)) {
				posts.add(post);
			}
		}
		return posts;
	}
}
