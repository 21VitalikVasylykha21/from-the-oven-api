package com.from.the.oven.api.repository;

import com.from.the.oven.api.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/05/21
 */
@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
}
