package com.spotted.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotted.models.Comment;
import com.spotted.models.Spotted;
import com.spotted.repositories.SpottedRepository;

@Service
public class SpottedService {

	@Autowired
	SpottedRepository spottedRepository;

	@Autowired
	CommentService commentService;

	public Spotted save(Spotted spotted) {
		spotted.setDatetime(LocalDateTime.now());
		return this.spottedRepository.save(spotted);
	}

	public List<Spotted> getAll() {
		return this.spottedRepository.findAll();
	}

	public Optional<Spotted> get(Long id) {
		return this.spottedRepository.findById(id);
	}

	public Spotted addComment(Long id, Comment comment) {
		this.commentService.save(comment);
		Spotted spotted = null;
		if (this.spottedRepository.existsById(id)) {
			spotted = this.spottedRepository.getOne(id);
			spotted.addComment(comment);
			this.spottedRepository.save(spotted);
		}
		return spotted;
	}

	public Set<Comment> getComments(Long id) {
		Spotted spotted = this.spottedRepository.findById(id).get();
		return spotted.getComments();
	}

	public Spotted denounce(Long id) {
		Spotted spotted = null;
		if (this.spottedRepository.existsById(id)) {
			spotted = this.spottedRepository.getOne(id);
			boolean visible = !spotted.getVisible();
			
		}
		return spotted;
	}
}
