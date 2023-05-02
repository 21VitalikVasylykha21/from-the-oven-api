package com.from.the.oven.api.controller;

import com.from.the.oven.api.dto.ApiResponse;
import com.from.the.oven.api.dto.CategoryDTO;
import com.from.the.oven.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/17
 */
@CrossOrigin
@RestController
@RequestMapping("api/v1/pizza/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ApiResponse<CategoryDTO> getAllCategories(@RequestParam(defaultValue = "20") Integer limit) {
		return new ApiResponse<>(
				categoryService.getAllCategories(limit).stream()
						.map(CategoryDTO::new)
						.toList()
		);
	}
}
