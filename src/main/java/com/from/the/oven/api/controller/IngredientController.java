package com.from.the.oven.api.controller;

import com.from.the.oven.api.dto.ApiResponse;
import com.from.the.oven.api.dto.IngredientDTO;
import com.from.the.oven.api.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/04/15
 */
@CrossOrigin
@RestController
@RequestMapping("api/v1/pizza/ingredients")
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;

	@GetMapping
	public ApiResponse<IngredientDTO> getAllIngredients(@RequestParam(defaultValue = "100") Integer limit) {
		return new ApiResponse<>(
				ingredientService.getAllIngredients(limit).stream()
						.map(IngredientDTO::new)
						.toList()
		);
	}
}
