package com.from.the.oven.api.dto;

import com.from.the.oven.api.entity.Pizza;
import java.util.List;
import java.util.Map;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/11
 */
public class PizzaDTO {
	private Long id;
	private String name;
	private String description;

	private String image;
	private List<String> ingredients;
	private List<String> category;

	private Integer sizeSmall;
	private Integer sizeMedium;
	private Integer sizeLarge;

	private Double priceSmall;
	private Double priceMedium;
	private Double priceLarge;

	public PizzaDTO() {
	}

	public PizzaDTO(Pizza pizza) {
		this.id = pizza.getId();
		this.name = pizza.getName();
		this.image = pizza.getImage();
		this.description = pizza.getDescription();
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

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}

	public Integer getSizeSmall() {
		return sizeSmall;
	}

	public void setSizeSmall(Integer sizeSmall) {
		this.sizeSmall = sizeSmall;
	}

	public Integer getSizeMedium() {
		return sizeMedium;
	}

	public void setSizeMedium(Integer sizeMedium) {
		this.sizeMedium = sizeMedium;
	}

	public Integer getSizeLarge() {
		return sizeLarge;
	}

	public void setSizeLarge(Integer sizeLarge) {
		this.sizeLarge = sizeLarge;
	}

	public Double getPriceSmall() {
		return priceSmall;
	}

	public void setPriceSmall(Double priceSmall) {
		this.priceSmall = priceSmall;
	}

	public Double getPriceMedium() {
		return priceMedium;
	}

	public void setPriceMedium(Double priceMedium) {
		this.priceMedium = priceMedium;
	}

	public Double getPriceLarge() {
		return priceLarge;
	}

	public void setPriceLarge(Double priceLarge) {
		this.priceLarge = priceLarge;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
