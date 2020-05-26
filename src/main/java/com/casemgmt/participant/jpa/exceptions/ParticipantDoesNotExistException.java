package com.casemgmt.participant.jpa.exceptions;

class ParticipantDoesNotExistException extends RuntimeException {
	public ParticipantDoesNotExistException(long Id) {
		super("Participant " + Id + " does not exist.");
	}
}