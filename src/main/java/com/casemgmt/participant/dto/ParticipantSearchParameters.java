package com.casemgmt.participant.dto;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipantSearchParameters {
	
	public String firstName;
	public String lastName;
	public Date dateOfBirth;
	
	public String street1;
	public String street2;
	public String city;
	public String state;
	public String zipCode;
}