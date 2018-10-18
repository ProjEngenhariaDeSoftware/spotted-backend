package com.spotted.services;

import com.spotted.models.Spotted;
import com.spotted.repositories.SpottedRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpottedService {

	@Autowired
	SpottedRepository spottedRepository;

	public Spotted save(Spotted spotted) {
		return this.spottedRepository.save(spotted);
	}

	public List<Spotted> getAll() {
		return this.spottedRepository.findAll();
	}
}
