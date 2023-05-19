package com.from.the.oven.api.controller;

import com.from.the.oven.api.dto.ApiResponse;
import com.from.the.oven.api.dto.PizzaDTO;
import com.from.the.oven.api.entity.Pizza;
import com.from.the.oven.api.service.PizzaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
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
		Optional<Pizza> pizza = pizzaService.findById(id);
		if (pizza.isEmpty()) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND);
		}
		return new ApiResponse<>(List.of(new PizzaDTO(pizza.get())));
	}

	@GetMapping("/search")
	public ApiResponse<PizzaDTO> searchPizzas(@RequestParam(name = "name", required = false) String name,
											  @RequestParam(name = "ingredients", defaultValue = " ", required = false) List<String> ingredients,
											  @RequestParam(name = "categories", defaultValue = " ", required = false) List<String> categories,
											  @RequestParam(name = "page", defaultValue = "1") Integer page,
											  @RequestParam(name = "limit", defaultValue = "20") Integer limit) {
		List<Pizza> pizzas = pizzaService.search(name, ingredients, categories, limit, page);
		return new ApiResponse<>(pizzas.stream()
				.map(PizzaDTO::new)
				.toList());
	}

	@PatchMapping("/{id}")
	public ApiResponse<PizzaDTO> updatePizza(@PathVariable Long id,
											 @RequestBody PizzaDTO updatedPizza) {
		Optional<Pizza> pizza = pizzaService.update(id, updatedPizza);
		if (pizza.isEmpty()) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND);
		}
		return new ApiResponse<>(List.of(new PizzaDTO(pizza.get())));
	}

	@PostMapping("/")
	public ApiResponse<PizzaDTO> updatePizza(@RequestBody PizzaDTO updatedPizza) {
		return new ApiResponse<>(List.of(new PizzaDTO(pizzaService.create(updatedPizza))));
	}

	@DeleteMapping("/{id}")
	public ApiResponse<PizzaDTO> deletePizza(@PathVariable Long id) {
		pizzaService.delete(id);
		return new ApiResponse<>(HttpStatus.OK);
	}
}