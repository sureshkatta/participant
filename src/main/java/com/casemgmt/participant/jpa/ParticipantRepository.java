package com.casemgmt.participant.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.casemgmt.participant.entities.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

	List<Participant> findByLastName(String lastName);

	Participant findById(long id);
}