package com.casemgmt.participant.core.exceptions;

public class RecordNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String message){
        super("Record with ID " + message + " Record Not Found");
    }
}