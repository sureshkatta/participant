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
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long participantId;

	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	private Date dateOfBirth;

	@Version
	private int version;
	private Date createDateTime;
	private Date updateDateTime;

	@OneToMany(targetEntity = com.casemgmt.participant.entities.Address.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "participantId")
	private List<Address> addresses;
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Participant(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Participant[id=%d, firstName='%s', lastName='%s']", participantId, firstName, lastName);
	}

	@PrePersist
	protected void onCreate() {
		createDateTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updateDateTime = new Date();
	}
}