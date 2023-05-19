package com.from.the.oven.api.service;

import com.from.the.oven.api.entity.Order;
import com.from.the.oven.api.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/05/17
 */
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAll(Integer limit) {
		if (limit <= 0) {
			throw new IllegalArgumentException("Limit must be greater than zero.");
		}
		return orderRepository.findAll(PageRequest.of(0, limit)).getContent();
	}

	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}
}
