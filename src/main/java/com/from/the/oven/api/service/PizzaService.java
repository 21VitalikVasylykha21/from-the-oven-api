package com.from.the.oven.api.service;

import com.from.the.oven.api.dto.PizzaSearchResponse;
import com.from.the.oven.api.entity.Pizza;
import com.from.the.oven.api.exception.EntityNotFoundException;
import com.from.the.oven.api.repository.CategoryRepository;
import com.from.the.oven.api.repository.IngredientRepository;
import com.from.the.oven.api.repository.PizzaCategoryRepository;
import com.from.the.oven.api.repository.PizzaIngredientRepository;
import com.from.the.oven.api.repository.PizzaPriceRepository;
import com.from.the.oven.api.repository.PizzaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/04/11
 */
@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;
	@Autowired
	private PizzaIngredientRepository pizzaIngredientRepository;
	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private PizzaCategoryRepository pizzaCategoryRepository;
	@Autowired
	private PizzaPriceRepository pizzaPriceRepository;

	public List<Pizza> getAll(Integer limit) {
		if (limit <= 0) {
			throw new IllegalArgumentException("Limit must be greater than zero.");
		}
		return pizzaRepository.findAll(PageRequest.of(0, limit)).getContent();
	}

	public Pizza findById(Long id) {
		Optional<Pizza> pizza = pizzaRepository.findById(id);
		if (pizza.isEmpty()) {
			throw new EntityNotFoundException(Pizza.class, id);
		}
		return pizza.get();
	}

	public PizzaSearchResponse search(String name, List<String> ingredients, List<String> categories, Integer limit, Integer page) {
		Page<Pizza> pizzas = pizzaRepository.findByNameAndIngredientsAndCategories(name, ingredients, categories, PageRequest.of(page - 1, limit));
		return new PizzaSearchResponse(pizzas.getTotalElements(), pizzas.getContent());
	}

	public PizzaSearchResponse searchByName(String name) {
		return search(name, List.of(""), List.of(""), 20, 1);
	}
}
