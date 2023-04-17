package com.from.the.oven.api.util;

import com.from.the.oven.api.entity.SizeType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/17
 */
@Converter(autoApply = true)
public class SizeTypeConverter implements AttributeConverter<SizeType, String> {

	@Override
	public String convertToDatabaseColumn(SizeType sizeType) {
		return sizeType.getName();
	}

	@Override
	public SizeType convertToEntityAttribute(String dbValue) {
		if (dbValue == null) {
			return null;
		}
		for (SizeType sizeType : SizeType.values()) {
			if (sizeType.getName().equalsIgnoreCase(dbValue)) {
				return sizeType;
			}
		}
		throw new IllegalArgumentException("Unknown value: " + dbValue);
	}
}