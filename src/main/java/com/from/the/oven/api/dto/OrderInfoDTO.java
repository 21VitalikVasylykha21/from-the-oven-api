package com.from.the.oven.api.dto;

import com.from.the.oven.api.entity.OrderInfo;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/18
 */
public class OrderInfoDTO {
	private String name;
	private Integer size;
	private Integer count;

	public OrderInfoDTO() {
	}
	public OrderInfoDTO(OrderInfo orderInfo) {
		this.name = orderInfo.getPizzaPrice().getPizza().getName();
		this.size = orderInfo.getPizzaPrice().getSize().getSize();
		this.count = orderInfo.getCount();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
