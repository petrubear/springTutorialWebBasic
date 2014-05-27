package emg.demos.spring.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class CustomEmailValidatorImpl implements
		ConstraintValidator<CustomEmailValidator, String> {
	// par1: Anotacion par2: El tipo de dato que voy a validar
	private int min;

	@Override
	public void initialize(CustomEmailValidator constraintAnnotation) {
		min = constraintAnnotation.min();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (email.length() < min) {
			return false;
		}

		return EmailValidator.getInstance(true).isValid(email);
		// return true;
	}

}
