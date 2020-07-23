package com.casemgmt.participant.core.validators.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.casemgmt.participant.core.validators.intf.PhoneNumber;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

	private String phoneNumber;

	@Override
	public void initialize(PhoneNumber constraint) {
		this.phoneNumber = constraint.value();
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		if (s.equalsIgnoreCase(this.phoneNumber))
			return true;

		return s != null && s.matches("[0-9]+") && (s.length() > 8) && (s.length() < 14);
	}
}