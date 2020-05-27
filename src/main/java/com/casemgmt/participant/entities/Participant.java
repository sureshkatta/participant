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

@Entity
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long participantId;

	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;

	private Date dateOfBirth;

	@OneToMany(targetEntity = com.casemgmt.participant.entities.Address.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "participantId")
	private List<Address> addresses;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Participant() {
	}

	public Participant(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Participant[id=%d, firstName='%s', lastName='%s']", participantId, firstName, lastName);
	}

	public Long getParticipantId() {
		return participantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}