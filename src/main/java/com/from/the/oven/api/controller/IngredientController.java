package com.from.the.oven.api.controller;

import com.from.the.oven.api.dto.IngredientDTO;
import com.from.the.oven.api.service.IngredientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/15
 */

@RestController
@RequestMapping("api/v1/pizza/ingredients")
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;

	@GetMapping
	public ResponseEntity<List<IngredientDTO>> getAllIngredients(@RequestParam(defaultValue = "20") Integer limit) {
		return ResponseEntity.ok(
				ingredientService.getAllIngredients(limit).stream()
						.map(IngredientDTO::new)
						.toList()
		);
	}
}
