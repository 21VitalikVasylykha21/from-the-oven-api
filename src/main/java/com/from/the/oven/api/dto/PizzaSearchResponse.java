package com.from.the.oven.api.dto;

import com.from.the.oven.api.entity.Pizza;
import java.util.List;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/20
 */
public record PizzaSearchResponse(Long total, List<Pizza> pizzas) {
}
