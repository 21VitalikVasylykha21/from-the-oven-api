package com.from.the.oven.api.entity;

import com.from.the.oven.api.enums.PizzaSize;
import com.from.the.oven.api.util.SizeTypeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/04/15
 */

@Entity
@Table(name = "size")
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "size_id")
	private Long id;

	@Column(name = "name", unique = true)
	@Convert(converter = SizeTypeConverter.class)
	private PizzaSize name;

	@Column(name = "size_cm")
	private Integer size;

	public Size() {
	}

	public Size(PizzaSize name, Integer size) {
		this.name = name;
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PizzaSize getName() {
		return name;
	}

	public void setName(PizzaSize name) {
		this.name = name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}
