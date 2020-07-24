package com.casemgmt.participant.core.validators.intf;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.casemgmt.participant.core.validators.impl.PhoneNumberValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface PhoneNumberCheck {
    String message() default "{state.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default "";
}