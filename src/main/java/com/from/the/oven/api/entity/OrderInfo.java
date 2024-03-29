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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/18
 */
@Entity
@Table(name = "pizza_order_info")
public class OrderInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pizza_order_info_id")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pizza_order_id")
	@NotNull(message = "Order is required")
	private Order order;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pizza_price_id")
	@NotNull(message = "Pizza price is required")
	private PizzaPrice pizzaPrice;

	@Column(name = "pizza_count")
	@NotNull(message = "Pizza count is required")
	@Positive(message = "Pizza count must be positive")
	private Integer count;

	public OrderInfo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public PizzaPrice getPizzaPrice() {
		return pizzaPrice;
	}

	public void setPizzaPrice(PizzaPrice pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
