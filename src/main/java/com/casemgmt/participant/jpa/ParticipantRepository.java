package com.casemgmt.participant.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.casemgmt.participant.entities.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

	List<Participant> findAll();
	List<Participant> findByLastName(String lastName);
	List<Participant> findByAddresses_Street1(String street1);
	List<Participant> findByAddresses_City(String City);
	
	Participant findById(long participantId);
	
	@Query("SELECT p FROM Participant p "
			+ " WHERE (p.firstName like %:firstName%) and (p.lastName like %:lastName%)")
	List<Participant> searchByParam(@Param("firstName") String firstName, @Param("lastName") String lastName, Pageable pageable);
}