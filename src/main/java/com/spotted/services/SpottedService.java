package com.spotted.services;

import com.spotted.models.Comment;
import com.spotted.models.Spotted;
import com.spotted.repositories.SpottedRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpottedService {
	
	@Autowired
	SpottedRepository spottedRepository;
	
	@Autowired
	CommentService commentService;
	
	public Spotted save(Spotted spotted) {
		return this.spottedRepository.save(spotted);
	}
	
	public List<Spotted> getAll() {
		return this.spottedRepository.findAll();
	}
	
	public Spotted addComment(Long spottedId, Comment comment) {
		this.commentService.save(comment);
		Spotted spotted = null;
		if (this.spottedRepository.existsById(spottedId)) {
			spotted = this.spottedRepository.getOne(spottedId);
			spotted.addComment(comment);
			this.spottedRepository.save(spotted);
		}
		return spotted;
	}
}
