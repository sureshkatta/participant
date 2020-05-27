package com.casemgmt.participant.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.casemgmt.participant.entities.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

	List<Participant> findAll();
	List<Participant> findByLastName(String lastName);
	List<Participant> findByAddresses_Street1(String street1);
	List<Participant> findByAddresses_City(String City);
	
	Participant findByParticipantId(long participantId);
}