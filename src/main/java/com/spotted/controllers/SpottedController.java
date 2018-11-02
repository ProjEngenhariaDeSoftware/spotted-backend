package com.spotted.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spotted.models.Comment;
import com.spotted.models.Spotted;
import com.spotted.services.SpottedService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
public class SpottedController {

	@Autowired
	SpottedService spottedService;

	@RequestMapping(value = "/spotted", method = RequestMethod.POST)
	public Spotted save(@RequestBody Spotted spotted) throws Exception {
		return this.spottedService.save(spotted);
	}

	@RequestMapping(value = "/spotted", method = RequestMethod.GET)
	public List<Spotted> getAll() {
		return this.spottedService.getAll();
	}

	@RequestMapping(value = "/spotted/{id}", method = RequestMethod.GET)
	public Spotted get(@PathVariable Long id) throws Exception {
		return this.spottedService.get(id);
	}

	@RequestMapping(value = "/spotted/{id}/comment", method = RequestMethod.PUT)
	public Spotted addComment(@PathVariable Long id, @RequestBody Comment comment) throws Exception {
		return this.spottedService.addComment(id, comment);
	}

	@RequestMapping(value = "/spotted/{id}/comment", method = RequestMethod.GET)
	public Set<Comment> getComments(@PathVariable Long id) {
		return this.spottedService.getComments(id);
	}

	@RequestMapping(value = "/spotted/{id}", method = RequestMethod.PUT)
	public Spotted setVisible(@PathVariable Long id) throws Exception {
		return this.spottedService.setVisible(id);
	}
}