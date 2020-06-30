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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long Id;

	@Column(nullable = false)
	@NonNull String firstName = "";
	@Column(nullable = false)
	@NonNull String lastName = "";
	Date dateOfBirth;

	@OneToMany(targetEntity = com.casemgmt.participant.entities.Address.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "participantId")
	List<Address> addresses;
	
	@Version
	int version;
	@CreationTimestamp
	Date createDateTime;
	@UpdateTimestamp
	Date updateDateTime;
}