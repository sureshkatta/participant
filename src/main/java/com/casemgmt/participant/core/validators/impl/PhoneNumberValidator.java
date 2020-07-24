package com.casemgmt.participant.core.validators.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.casemgmt.participant.core.validators.intf.PhoneNumberCheck;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberCheck, String> {

	private String phone;

	@Override
	public void initialize(PhoneNumberCheck constraint) {
		this.phone = constraint.value();
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		if (s.equalsIgnoreCase(this.phone))
			return true;

		return s != null && s.matches("[0-9]+") && (s.length() > 8) && (s.length() < 14);
	}
}