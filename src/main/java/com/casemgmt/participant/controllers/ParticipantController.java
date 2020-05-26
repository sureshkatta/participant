package com.casemgmt.participant.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casemgmt.participant.entities.Participant;
import com.casemgmt.participant.jpa.ParticipantRepository;

@RestController
public class ParticipantController {

	@Autowired
	ParticipantRepository repository;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/participants")
	public List<Participant> getAllParticipants(@RequestParam(value = "name", defaultValue = "World") String name) {
		return repository.findAll();
	}	
}