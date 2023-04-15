package com.from.the.oven.api.service;

import com.from.the.oven.api.entity.Ingredient;
import com.from.the.oven.api.repository.IngredientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/15
 */
@Service
public class IngredientService {
	@Autowired
	private IngredientRepository ingredientRepository;

	public List<Ingredient> getAllIngredients(int limit) {
		if (limit <= 0) {
			throw new IllegalArgumentException("Limit must be greater than zero.");
		}
		return ingredientRepository.findAll(PageRequest.of(0, limit)).getContent();
	}
}
