package com.from.the.oven.api.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/04/30
 */
@Entity
@Table(name = "pizza_category")
public class PizzaCategory {

	@EmbeddedId
	private PizzaCategoryId id;

	public PizzaCategory() {
	}

	public PizzaCategory(PizzaCategoryId id) {
		this.id = id;
	}

	public PizzaCategoryId getId() {
		return id;
	}

	public void setId(PizzaCategoryId id) {
		this.id = id;
	}
}
