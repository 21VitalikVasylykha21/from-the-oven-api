package com.from.the.oven.api.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/30
 */
@Entity
@Table(name = "pizza_ingredient")
public class PizzaIngredient {

	@EmbeddedId
	private PizzaIngredientId id;

	public PizzaIngredient() {
	}

	public PizzaIngredient(PizzaIngredientId id) {
		this.id = id;
	}

	public PizzaIngredientId getId() {
		return id;
	}

	public void setId(PizzaIngredientId id) {
		this.id = id;
	}
}