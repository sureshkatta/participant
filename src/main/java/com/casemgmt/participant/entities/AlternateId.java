package com.casemgmt.participant.entities;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
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
public class AlternateId {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long Id;
	
	@Column(nullable = false)
	@NotEmpty(message = "Please select a type of ID")
	String alternateIdType = "";
	
	String alternateId = "";
	
	Instant startDate;
	
	Instant endDate;
	
	@Version
	int version;
	@CreationTimestamp
	Date createDateTime;
	@UpdateTimestamp
	Date updateDateTime;
}