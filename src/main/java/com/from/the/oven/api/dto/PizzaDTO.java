package com.from.the.oven.api.dto;

import com.from.the.oven.api.entity.Category;
import com.from.the.oven.api.entity.Ingredient;
import com.from.the.oven.api.entity.Pizza;
import java.util.List;

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
	private List<String> categories;
	private Integer massSmall;
	private Integer massMedium;
	private Integer massLarge;
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
		this.ingredients = pizza.getIngredients().stream().map(Ingredient::getName).toList();
		this.categories = pizza.getCategories().stream().map(Category::getName).toList();
		pizza.getPrices().forEach(price -> {
			switch (price.getSize().getName()) {
				case SMALL -> {
					massSmall = price.getMass();
					sizeSmall = price.getSize().getSize();
					priceSmall = price.getPrice();
				}
				case MEDIUM -> {
					massMedium = price.getMass();
					sizeMedium = price.getSize().getSize();
					priceMedium = price.getPrice();
				}
				case LARGE -> {
					massLarge = price.getMass();
					sizeLarge = price.getSize().getSize();
					priceLarge = price.getPrice();
				}
			}
		});
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

	public Integer getMassSmall() {
		return massSmall;
	}

	public void setMassSmall(Integer massSmall) {
		this.massSmall = massSmall;
	}

	public Integer getMassMedium() {
		return massMedium;
	}

	public void setMassMedium(Integer massMedium) {
		this.massMedium = massMedium;
	}

	public Integer getMassLarge() {
		return massLarge;
	}

	public void setMassLarge(Integer massLarge) {
		this.massLarge = massLarge;
	}
}
