package com.from.the.oven.api.exception;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/19
 */
public class ValidationException extends RuntimeException {
	public ValidationException(String exMessage) {
		super(exMessage);
	}
}
