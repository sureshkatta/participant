package com.casemgmt.participant.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.casemgmt.participant.core.validators.intf.PhoneNumber;

import lombok.Data;

@Entity
@Data
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long Id;

	@Column(nullable = false)
	@NotEmpty(message = "Please provide a first name")
	String firstName = "";
	
	@Column(nullable = false)
	@NotEmpty(message = "Please provide a last name")
	String lastName = "";
	
	String registeredName = "";
	
	@Past
	Date dateOfBirth;
	Date timeOfBirth;
	
	String birthPlace;
	
	String gender;
	String race;
	String religion;
	String maritalStatus;
	String militaryService;
	
	@PhoneNumber 
	String phoneNumber = "";
	//Attachment photo;
	//
	
	@OneToMany(targetEntity = com.casemgmt.participant.entities.Address.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "participantId")
	List<Address> addresses;
	
	@Version
	int version;
	@CreationTimestamp
	Date createDateTime;
	@UpdateTimestamp
	Date updateDateTime;
}