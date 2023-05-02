package com.from.the.oven.api.service;

import com.from.the.oven.api.dto.PizzaDTO;
import com.from.the.oven.api.entity.Category;
import com.from.the.oven.api.entity.Ingredient;
import com.from.the.oven.api.entity.Pizza;
import com.from.the.oven.api.entity.PizzaCategory;
import com.from.the.oven.api.entity.PizzaCategoryId;
import com.from.the.oven.api.entity.PizzaIngredient;
import com.from.the.oven.api.entity.PizzaIngredientId;
import com.from.the.oven.api.repository.CategoryRepository;
import com.from.the.oven.api.repository.IngredientRepository;
import com.from.the.oven.api.repository.PizzaCategoryRepository;
import com.from.the.oven.api.repository.PizzaIngredientRepository;
import com.from.the.oven.api.repository.PizzaPriceRepository;
import com.from.the.oven.api.repository.PizzaRepository;
import io.micrometer.common.util.StringUtils;
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

	public Optional<Pizza> findById(Long id) {
		return pizzaRepository.findById(id);
	}

	public List<Pizza> search(String name, List<String> ingredients, List<String> categories, Integer limit, Integer page) {
		Integer offset = (page - 1) * limit;
		return pizzaRepository.findByNameAndIngredientsAndCategories(name, ingredients, categories, limit, offset);
	}

	public Optional<Pizza> update(Long id, PizzaDTO updatePizzaDto) {
		Optional<Pizza> optionalPizza = findById(id);
		if (optionalPizza.isEmpty()) {
			return Optional.empty();
		}
		Pizza existingPizza = optionalPizza.get();
		updatePriceTable(existingPizza, updatePizzaDto);
		updatePizzaInfo(existingPizza, updatePizzaDto);
		updatePizzaCategory(existingPizza, updatePizzaDto);
		updatePizzaIngredient(existingPizza, updatePizzaDto);
		return findById(id);
	}

	private void updatePizzaInfo(Pizza existingPizza, PizzaDTO updatePizzaDto) {
		existingPizza.setName(StringUtils.isNotBlank(updatePizzaDto.getName()) ? updatePizzaDto.getName() : existingPizza.getName());
		existingPizza.setDescription(StringUtils.isNotBlank(updatePizzaDto.getDescription()) ? updatePizzaDto.getDescription() : existingPizza.getDescription());
		existingPizza.setImage(StringUtils.isNotBlank(updatePizzaDto.getImage()) ? updatePizzaDto.getImage() : existingPizza.getImage());
		pizzaRepository.save(existingPizza);
	}

	private void updatePizzaIngredient(Pizza existingPizza, PizzaDTO updatePizzaDto) {
		addIngredient(existingPizza, updatePizzaDto);
		removeIngredient(existingPizza, updatePizzaDto);
	}

	private void updatePizzaCategory(Pizza existingPizza, PizzaDTO updatePizzaDto) {
		addCategory(existingPizza, updatePizzaDto);
		removeCategory(existingPizza, updatePizzaDto);
	}

	private void updatePriceTable(Pizza existingPizza, PizzaDTO updatePizzaDto) {
//		existingPizza.getPrices().stream()
//				.filter(price -> price.getSize().getName().equals(PizzaSize.SMALL))
//				.forEach(price -> {
//					if (!price.getMass().equals(updatePizzaDto.getMassSmall())
//							|| !price.getMass().equals(updatePizzaDto.getMassSmall())) {
//
//						pizzaPriceRepository.save(new PizzaPrice(new Size(PizzaSize.SMALL), updatePizzaDto.getMassSmall(), updatePizzaDto.getPriceSmall()));
//					}
//				});
	}

	private void addIngredient(Pizza existingPizza, PizzaDTO updatePizzaDto) {
		for (String ingredientName : updatePizzaDto.getIngredients()) {
			if (existingPizza.getIngredients().contains(new Ingredient(ingredientName))) {
				continue;
			}
			Optional<Ingredient> optionalIngredient = ingredientRepository.findByName(ingredientName);
			if (optionalIngredient.isEmpty()) {
				throw new IllegalArgumentException("Not found ingredient: " + ingredientName);
			}
			Ingredient ingredient = optionalIngredient.get();
			pizzaIngredientRepository.save(new PizzaIngredient(new PizzaIngredientId(existingPizza.getId(), ingredient.getId())));
			existingPizza.getIngredients().add(ingredient);
		}
	}

	private void removeIngredient(Pizza existingPizza, PizzaDTO updatePizzaDto) {
		for (int i = 0; i < existingPizza.getIngredients().size(); i++) {
			Ingredient ingredient = existingPizza.getIngredients().get(i);
			if (updatePizzaDto.getIngredients().contains(ingredient.getName())) {
				continue;
			}
			pizzaIngredientRepository.delete(new PizzaIngredient(new PizzaIngredientId(existingPizza.getId(), ingredient.getId())));
			existingPizza.getIngredients().remove(ingredient);
		}
	}

	private void addCategory(Pizza existingPizza, PizzaDTO updatePizzaDto) {
		for (String categoryName : updatePizzaDto.getCategories()) {
			if (existingPizza.getCategories().contains(new Category(categoryName))) {
				continue;
			}
			Optional<Category> optionalCategory = categoryRepository.findByName(categoryName);
			if (optionalCategory.isEmpty()) {
				throw new IllegalArgumentException("Not found category: " + categoryName);
			}
			Category category = optionalCategory.get();
			pizzaCategoryRepository.save(new PizzaCategory(new PizzaCategoryId(existingPizza.getId(), category.getId())));
			existingPizza.getCategories().add(category);
		}
	}

	private void removeCategory(Pizza existingPizza, PizzaDTO updatePizzaDto) {
		for (int i = 0; i < existingPizza.getCategories().size(); i++) {
			Category category = existingPizza.getCategories().get(i);
			if (updatePizzaDto.getCategories().contains(category.getName())) {
				continue;
			}
			pizzaCategoryRepository.delete(new PizzaCategory(new PizzaCategoryId(existingPizza.getId(), category.getId())));
			existingPizza.getCategories().remove(category);
		}
	}
}
