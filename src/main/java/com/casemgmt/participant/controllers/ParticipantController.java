package com.casemgmt.participant.controllers;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Participant> getAllParticipants() {
		return repository.findAll();
	}

	@PostMapping("/participants")
	Participant newParticipant(@RequestBody Participant newParticipant) {
		return repository.save(newParticipant);
	}

	@GetMapping("/participants/{id}")
	public Participant getParticipant(@PathVariable long id) {
		return Optional.ofNullable(repository.findById(id))
			.orElseThrow(() -> new RuntimeException("Not Found"));
	}
	
	@GetMapping("/participants/{name}")
	public List<Participant> getAllParticipantsByName(@PathVariable String name) {
		return repository.findByLastName(name);
	}
}