package com.spotted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spotted.models.Post;
import com.spotted.services.PostService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public Post save(@RequestBody Post post) {
		return this.postService.save(post);	
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public List<Post> getAll() {
		return this.postService.getAll();
	}

}
