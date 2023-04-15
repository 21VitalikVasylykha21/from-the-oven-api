package com.from.the.oven.api.dto;

import com.from.the.oven.api.entity.Ingredient;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/15
 */
public class IngredientDTO {
	private Long id;
	private String name;
	private String description;
	private String image;

	public IngredientDTO(Ingredient ingredient) {
		this.id = ingredient.getId();
		this.name = ingredient.getName();
		this.image = ingredient.getImage();
		this.description = ingredient.getDescription();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
