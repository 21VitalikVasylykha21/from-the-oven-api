package com.from.the.oven.api.validator;

import com.from.the.oven.api.exception.ValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/05/19
 */
public class Validator {
	public static void validate(Object object) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		jakarta.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<Object>> violations = validator.validate(object);
		if (!violations.isEmpty()) {
			for (ConstraintViolation<Object> violation : violations) {
				throw new ValidationException(violation.getMessage());
			}
		}
		factory.close();
	}
}
