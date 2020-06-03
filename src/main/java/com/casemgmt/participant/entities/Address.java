package com.casemgmt.participant.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addressId;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zipCode;

	@Version
	private int version;
	private Date createDateTime;
	private Date updateDateTime;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY) private Participant participant;
	 */

	public Address(String street1, String street2, String city, String state, String zipCode) {
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	/*
	 * public Participant getParticipant() { return participant; }
	 * 
	 * public void setParticipant(Participant participant) { this.participant =
	 * participant; }
	 */

	@PrePersist
	protected void onCreate() {
		createDateTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updateDateTime = new Date();
	}
}
