package com.from.the.oven.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/15
 */

@Entity
@Table(name = "pizza_price")
public class PizzaPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pizza_price_id")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "size_id")
	private Size size;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pizza_id")
	private Pizza pizza;

	@Column(name = "price")
	private Double price;

	@Column(name = "mass")
	private Integer mass;

	public PizzaPrice() {
	}

	public PizzaPrice(Size size, Integer mass, Double price) {
		this.size = size;
		this.price = price;
		this.mass = mass;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getMass() {
		return mass;
	}

	public void setMass(Integer mass) {
		this.mass = mass;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
}
