package com.from.the.oven.api.dto;

import com.from.the.oven.api.entity.Category;
import com.from.the.oven.api.entity.Ingredient;
import com.from.the.oven.api.entity.Pizza;
import java.util.List;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/04/11
 */
public class PizzaDTO {
	private Long id;
	private String name;
	private String description;
	private String image;
	private List<String> ingredients;
	private List<String> categories;
	private Integer massSmall;
	private Integer massLarge;
	private Integer sizeSmall;
	private Integer sizeLarge;
	private Integer rating;
	private Double priceSmall;
	private Double priceLarge;

	public PizzaDTO() {
	}

	public PizzaDTO(Pizza pizza) {
		this.id = pizza.getId();
		this.name = pizza.getName();
		this.image = pizza.getImage();
		this.rating = pizza.getRating();
		this.description = pizza.getDescription();
		this.ingredients = pizza.getIngredients().stream().map(Ingredient::getName).toList();
		this.categories = pizza.getCategories().stream().map(Category::getName).toList();
		pizza.getPrices().forEach(price -> {
			switch (price.getSize().getName()) {
				case SMALL -> {
					massSmall = price.getMass();
					sizeSmall = price.getSize().getSize();
					priceSmall = price.getPrice();
				}
				case LARGE -> {
					massLarge = price.getMass();
					sizeLarge = price.getSize().getSize();
					priceLarge = price.getPrice();
				}
			}
		});
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
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

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public Integer getSizeSmall() {
		return sizeSmall;
	}

	public void setSizeSmall(Integer sizeSmall) {
		this.sizeSmall = sizeSmall;
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

	public Integer getMassSmall() {
		return massSmall;
	}

	public void setMassSmall(Integer massSmall) {
		this.massSmall = massSmall;
	}

	public Integer getMassLarge() {
		return massLarge;
	}

	public void setMassLarge(Integer massLarge) {
		this.massLarge = massLarge;
	}
}
