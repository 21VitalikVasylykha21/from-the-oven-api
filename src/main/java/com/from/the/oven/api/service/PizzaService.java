package com.from.the.oven.api.service;

import com.from.the.oven.api.entity.Pizza;
import com.from.the.oven.api.repository.PizzaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/11
 */
@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;

	public List<Pizza> getAllPizzas(int limit) {
		if (limit <= 0) {
			throw new IllegalArgumentException("Limit must be greater than zero.");
		}
		return pizzaRepository.findAll(PageRequest.of(0, limit)).getContent();
	}

	public Optional<Pizza> findPizzaById(Long id) {
		return pizzaRepository.findById(id);
	}

	public List<Pizza> findPizzaByName(String name) {
		return pizzaRepository.findByName(name.toLowerCase());
	}
}
