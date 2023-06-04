package com.from.the.oven.api.repository;

import com.from.the.oven.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/17
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
