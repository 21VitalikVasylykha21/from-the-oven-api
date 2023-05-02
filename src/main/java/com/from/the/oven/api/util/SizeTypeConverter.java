package com.from.the.oven.api.util;

import com.from.the.oven.api.enums.PizzaSize;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/17
 */
@Converter(autoApply = true)
public class SizeTypeConverter implements AttributeConverter<PizzaSize, String> {

	@Override
	public String convertToDatabaseColumn(PizzaSize pizzaSize) {
		return pizzaSize.getName();
	}

	@Override
	public PizzaSize convertToEntityAttribute(String dbValue) {
		if (dbValue == null) {
			return null;
		}
		for (PizzaSize pizzaSize : PizzaSize.values()) {
			if (pizzaSize.getName().equalsIgnoreCase(dbValue)) {
				return pizzaSize;
			}
		}
		throw new IllegalArgumentException("Unknown value: " + dbValue);
	}
}