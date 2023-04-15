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
	@Query("SELECT p FROM Pizza p WHERE LOWER(p.name) LIKE %:name%")
	List<Pizza> findByName(@Param("name") String name);
}