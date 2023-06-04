package com.from.the.oven.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/04/30
 */
@Embeddable
public class PizzaCategoryId implements Serializable {

	@Column(name = "pizza_id")
	private Long pizzaId;

	@Column(name = "category_id")
	private Long categoryId;

	public PizzaCategoryId() {}

	public PizzaCategoryId(Long pizzaId, Long categoryId) {
		this.pizzaId = pizzaId;
		this.categoryId = categoryId;
	}

	public Long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}

