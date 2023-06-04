package com.from.the.oven.api.exception;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/20
 */
public class LimitApiRequestException extends RuntimeException {
	public LimitApiRequestException() {
		super("Limit must be greater than zero.");
	}
}
