package com.from.the.oven.api.repository;

import com.from.the.oven.api.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/15
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}