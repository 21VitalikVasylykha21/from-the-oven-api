package com.from.the.oven.api.controller;

import com.from.the.oven.api.dto.PizzaDTO;
import com.from.the.oven.api.entity.Pizza;
import com.from.the.oven.api.service.PizzaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/12
 */
@RestController
@RequestMapping("api/v1/pizzas")
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;

	@GetMapping
	public ResponseEntity<List<PizzaDTO>> getAllPizzas(@RequestParam(defaultValue = "20") Integer limit) {
		return ResponseEntity.ok(
				pizzaService.getAllPizzas(limit).stream()
						.map(PizzaDTO::new)
						.toList()
		);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PizzaDTO> findPizzaById(@PathVariable Long id) {
		Optional<Pizza> pizza = pizzaService.findPizzaById(id);
		if (pizza.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new PizzaDTO(pizza.get()));
	}

	@GetMapping("/search")
	public ResponseEntity<List<PizzaDTO>> searchPizzasByName(@RequestParam("name") String name) {
		List<Pizza> pizzas = pizzaService.findPizzaByName(name);
		return ResponseEntity.ok(
				pizzas.stream()
						.map(PizzaDTO::new)
						.toList()
		);
	}
}