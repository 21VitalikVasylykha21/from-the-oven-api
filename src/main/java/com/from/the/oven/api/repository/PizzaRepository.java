package com.from.the.oven.api.repository;

import com.from.the.oven.api.entity.Pizza;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/11
 */
@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

	@Query(value = "SELECT DISTINCT p.* FROM pizza p " +
			"LEFT JOIN pizza_ingredient pi ON p.pizza_id = pi.pizza_id " +
			"LEFT JOIN ingredient i ON pi.ingredient_id = i.ingredient_id " +
			"LEFT JOIN pizza_category pc ON p.pizza_id = pc.pizza_id " +
			"LEFT JOIN category c ON pc.category_id = c.category_id " +
			"WHERE (:name != '' AND LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
			"AND (i.name IN (:ingredientNames) " +
			"AND c.name IN (:categories)) " +
			"ORDER BY pizza_id", nativeQuery = true)
	List<Pizza> findByNameAndIngredientsAndCategories(@Param("name") String name,
													  @Param("ingredientNames") List<String> ingredients,
													  @Param("categories") List<String> categories);
}