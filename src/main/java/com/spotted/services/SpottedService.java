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
	
	public Spotted get(Long id) throws Exception {
		if (!this.spottedRepository.existsById(id)) {
			throw new Exception("This id is not registered in the system.");
		}
		return this.spottedRepository.getOne(id);
	}

	public Spotted addComment(Long id, Comment comment) throws Exception {
		if (!this.spottedRepository.existsById(id)) {
			throw new Exception("There is not a spotted registered with this id in the system");
		}
		
		this.commentService.save(comment);
		Spotted spotted = this.spottedRepository.getOne(id);
		spotted.addComment(comment);
		this.spottedRepository.save(spotted);
		return spotted;
	}

	public Set<Comment> getComments(Long id) {
		Spotted spotted = this.spottedRepository.findById(id).get();
		return spotted.getComments();
	}

	public Spotted setVisible(Long id) throws Exception {
		if (!this.spottedRepository.existsById(id)) {
			throw new Exception("This id is not registered in the system.");
		}
		Spotted spotted;
		spotted = this.spottedRepository.getOne(id);
		boolean visible = !spotted.getVisible();
		spotted.setVisible(visible);
		return this.spottedRepository.save(spotted);
	}
	
	public void delete(Long id) {
		this.spottedRepository.deleteById(id);
	}
}
