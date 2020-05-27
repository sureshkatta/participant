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

	@GetMapping("/participants")
	public List<Participant> getAllParticipants() {
		return repository.findAll();
	}

	@PostMapping("/participants")
	Participant newParticipant(@RequestBody Participant newParticipant) {
		return repository.save(newParticipant);
	}

	@GetMapping("/participants/{participantId}")
	public Participant getParticipant(@PathVariable long participantId) {
		return Optional.ofNullable(repository.findByParticipantId(participantId))
			.orElseThrow(() -> new RuntimeException("Not Found" + participantId));
	}
	
	/*
	 * @GetMapping("/participants/{name}") public List<Participant>
	 * getAllParticipantsByName(@PathVariable String name) { return
	 * repository.findByLastName(name); }
	 */
}