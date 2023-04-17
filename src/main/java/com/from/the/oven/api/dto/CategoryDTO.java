package com.from.the.oven.api.dto;

import com.from.the.oven.api.entity.Category;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/17
 */
public class CategoryDTO {
	private Long id;
	private String name;

	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
