package com.from.the.oven.api.repository;

import com.from.the.oven.api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/17
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}