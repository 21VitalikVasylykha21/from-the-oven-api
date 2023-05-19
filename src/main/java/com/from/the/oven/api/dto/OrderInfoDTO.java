package com.from.the.oven.api.dto;

import com.from.the.oven.api.entity.OrderInfo;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/05/18
 */
public class OrderInfoDTO {
	private String pizzaName;
	private String pizzaSize;
	private Integer pizzaCount;


	public OrderInfoDTO(OrderInfo orderInfo) {
		this.pizzaName = orderInfo.getPizzaPrice().getPizza().getName();
		this.pizzaSize = orderInfo.getPizzaPrice().getSize().getName().getName();
		this.pizzaCount = orderInfo.getCount();
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getPizzaSize() {
		return pizzaSize;
	}

	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public Integer getPizzaCount() {
		return pizzaCount;
	}

	public void setPizzaCount(Integer pizzaCount) {
		this.pizzaCount = pizzaCount;
	}
}
