package com.casemgmt.participant.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casemgmt.participant.core.exceptions.RecordNotFoundException;
import com.casemgmt.participant.dto.ParticipantSearchParameters;
import com.casemgmt.participant.entities.Participant;
import com.casemgmt.participant.jpa.ParticipantRepository;

@RestController
public class ParticipantController {

	@Autowired
	ParticipantRepository repository;

	@GetMapping("/participants")
	public ResponseEntity<List<Participant>> getAllParticipants(
		@RequestParam(defaultValue = "0") Integer pageNo, 
        @RequestParam(defaultValue = "5") Integer pageSize,
        @RequestParam(defaultValue = "lastName") String sortBy) {
	
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		List<Participant> list = repository.findAll(paging);
		
		return new ResponseEntity<List<Participant>>(list, new HttpHeaders(), HttpStatus.OK); 
	}

	@PostMapping("/participants")
	Participant newParticipant(@Valid @RequestBody Participant newParticipant) {
		
		return repository.save(newParticipant);
	}

	@GetMapping("/participants/{participantId}")
	public Participant getParticipant(@PathVariable long participantId) {
		return Optional.ofNullable(repository.findById(participantId))
				.orElseThrow(() -> new RecordNotFoundException(String.valueOf(participantId)));
	}

	@GetMapping("/participants/findByName/{name}")
	public ResponseEntity<List<Participant>> getAllParticipantsByName(
			@PathVariable String name,
			@RequestParam(defaultValue = "0") Integer pageNo, 
	        @RequestParam(defaultValue = "5") Integer pageSize,
	        @RequestParam(defaultValue = "id") String sortBy) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		List<Participant> list = repository.findByLastName(name, paging);
		
		return new ResponseEntity<List<Participant>>(list, new HttpHeaders(), HttpStatus.OK); 
	}

	@PostMapping("/participants/Search")
	public ResponseEntity<List<Participant>> getAllParticipantsBySearchParam(
			@RequestBody ParticipantSearchParameters searchParam, @RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		List<Participant> list = repository.searchByParam(searchParam.getFirstName(), searchParam.getLastName(),
				searchParam.getStreet1(), paging);

		return new ResponseEntity<List<Participant>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}