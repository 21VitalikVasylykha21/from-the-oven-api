package com.from.the.oven.api.entity;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/17
 */
public enum SizeType {
	SMALL("Small"),
	MEDIUM("Medium"),
	LARGE("Large");

	private final String name;

	SizeType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
