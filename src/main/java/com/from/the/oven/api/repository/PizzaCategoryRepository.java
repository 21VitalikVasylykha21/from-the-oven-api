package com.from.the.oven.api.repository;

import com.from.the.oven.api.entity.PizzaCategory;
import com.from.the.oven.api.entity.PizzaCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/04/30
 */
@Repository
public interface PizzaCategoryRepository extends JpaRepository<PizzaCategory, PizzaCategoryId> {
}
