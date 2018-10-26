package com.spotted.controllers;

import java.util.List;

import com.spotted.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spotted.models.Spotted;
import com.spotted.services.SpottedService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
public class SpottedController {
	
	@Autowired
	SpottedService spottedService;
	
	private boolean notText(String text) {
		return text == null || text.isEmpty();
	}
	
	private boolean notImage(byte[] image) {
		return image == null || image.length == 0;
	}
	
	@RequestMapping(value = "/spotted", method = RequestMethod.POST)
	public Spotted save(@RequestBody Spotted spotted) throws Exception {
		if (this.notText(spotted.getText()) && this.notImage(spotted.getImage())) {
			throw new Exception("Text and image can not be empty or null simultaneously'");
		}
		return this.spottedService.save(spotted);
	}
	
	@RequestMapping(value = "/spotted", method = RequestMethod.GET)
	public List<Spotted> getAll() {
		return this.spottedService.getAll();
	}
	
	@RequestMapping(value = "/spotted/{spottedId}/comment", method = RequestMethod.PUT)
	public Spotted addComment(@PathVariable Long spottedId, @RequestBody Comment comment) {
		return this.spottedService.addComment(spottedId, comment);
	}
}
