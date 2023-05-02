package com.from.the.oven.api.repository;

import com.from.the.oven.api.entity.PizzaPrice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/30
 */
public interface PizzaPriceRepository extends JpaRepository<PizzaPrice, Long> {
}
