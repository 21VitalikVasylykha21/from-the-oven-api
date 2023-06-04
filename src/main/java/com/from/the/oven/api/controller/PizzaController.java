package com.from.the.oven.api.controller;

import com.from.the.oven.api.dto.ApiResponse;
import com.from.the.oven.api.dto.PizzaDTO;
import com.from.the.oven.api.dto.PizzaSearchResponse;
import com.from.the.oven.api.exception.EntityNotFoundException;
import com.from.the.oven.api.service.PizzaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/04/12
 */
@CrossOrigin
@RestController
@RequestMapping("api/v1/pizzas")
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;

	@GetMapping
	public ApiResponse<PizzaDTO> getAllPizzas(@RequestParam(name = "limit", defaultValue = "20") Integer limit) {
		return new ApiResponse<>(
				pizzaService.getAll(limit).stream()
						.map(PizzaDTO::new)
						.toList()
		);
	}

	@GetMapping("/{id}")
	public ApiResponse<PizzaDTO> findPizzaById(@PathVariable Long id) {
		try {
			return new ApiResponse<>(List.of(new PizzaDTO(pizzaService.findById(id))));
		} catch (EntityNotFoundException exception) {
			return new ApiResponse<>(HttpStatus.BAD_REQUEST, exception);
		}
	}

	@GetMapping("/search")
	public ApiResponse<PizzaDTO> searchPizzas(@RequestParam(name = "name", required = false) String name,
											  @RequestParam(name = "ingredients", defaultValue = " ", required = false) List<String> ingredients,
											  @RequestParam(name = "categories", defaultValue = " ", required = false) List<String> categories,
											  @RequestParam(name = "page", defaultValue = "1") Integer page,
											  @RequestParam(name = "limit", defaultValue = "20") Integer limit) {
		PizzaSearchResponse pizzaSearchResponse = pizzaService.search(name, ingredients, categories, limit, page);
		return new ApiResponse<>(pizzaSearchResponse.total(),
				pizzaSearchResponse.pizzas().stream()
						.map(PizzaDTO::new)
						.toList());
	}
}