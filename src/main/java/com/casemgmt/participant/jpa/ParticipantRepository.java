package com.casemgmt.participant.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import com.casemgmt.participant.entities.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

	List<Participant> findAll(Pageable pageable);
	List<Participant> findByLastName(String lastName, Pageable pageable);
	List<Participant> findByAddresses_Street1(String street1, Pageable pageable);
	List<Participant> findByAddresses_City(String City, Pageable pageable);
	
	Participant findById(long participantId);
	
	@Nullable
	@Query("SELECT p FROM Participant p LEFT OUTER JOIN p.addresses a "
			+ " WHERE (p.firstName like %:firstName%) and (p.lastName like %:lastName%) AND (a.street1 like %:street1%)")
	List<Participant> searchByParam(
			@Param("firstName") String firstName, 
			@Param("lastName") String lastName, 
			@Param("street1") String street1, 
			Pageable pageable);
}