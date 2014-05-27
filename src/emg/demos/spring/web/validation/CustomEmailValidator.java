package emg.demos.spring.web.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = CustomEmailValidatorImpl.class)
public @interface CustomEmailValidator {

	String message() default "Email no es valido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min() default 10;

	int max() default 255;
}
