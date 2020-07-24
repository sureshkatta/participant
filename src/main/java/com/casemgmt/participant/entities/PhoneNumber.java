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
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.casemgmt.participant.core.validators.intf.PhoneNumberCheck;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PhoneNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long Id;
	
	@Column(nullable = false)
	@NotEmpty(message = "Please select an phone number type")
	String phoneType = "";
	
	@Pattern(regexp = "(\\d){3,3}-\\d{3,3}-\\d{2,4}", message = "The phone number must match 111-111-1111 format")
	//@PhoneNumberCheck 
	String phone = "";
	
	Instant startDate;
	
	Instant endDate;
	
	@Version
	int version;
	@CreationTimestamp
	Date createDateTime;
	@UpdateTimestamp
	Date updateDateTime;
}