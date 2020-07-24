package com.casemgmt.participant.entities;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class EmailAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long Id;
	
	@Email
	@NotEmpty(message = "Please enter an Email")
	String email = "";
	
	Instant startDate;
	
	Instant endDate;
	
	@Version
	int version;
	@CreationTimestamp
	Date createDateTime;
	@UpdateTimestamp
	Date updateDateTime;
}