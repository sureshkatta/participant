package com.casemgmt.participant.dto;

import java.util.Date;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Data;

@Data
public class ParticipantSearchParameters {
	
	String firstName;
	String lastName;
	Date dateOfBirth;
	
	String street1;
	String street2;
	String city;
	String state;
	String zipCode;
}