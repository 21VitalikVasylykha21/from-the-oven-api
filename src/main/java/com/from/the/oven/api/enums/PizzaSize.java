package com.from.the.oven.api.enums;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/04/17
 */
public enum PizzaSize {
	SMALL("Small"),
	LARGE("Large");

	private final String name;

	PizzaSize(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
