package com.from.the.oven.api.exception;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/05/20
 */
public class EntityNotFoundException extends RuntimeException {
	public EntityNotFoundException(Class object, Long id) {
		super("Not fount object " + object.getSimpleName() + " in database by id: " + id);
	}
}
