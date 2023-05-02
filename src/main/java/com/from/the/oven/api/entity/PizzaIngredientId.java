package com.from.the.oven.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/30
 */
@Embeddable
public class PizzaIngredientId implements Serializable {

	@Column(name = "pizza_id")
	private Long pizzaId;

	@Column(name = "ingredient_id")
	private Long ingredientId;

	public PizzaIngredientId() {
	}

	public PizzaIngredientId(Long pizzaId, Long ingredientId) {
		this.pizzaId = pizzaId;
		this.ingredientId = ingredientId;
	}

	public Long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}

	public Long getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}
}

