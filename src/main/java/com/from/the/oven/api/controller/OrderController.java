package com.from.the.oven.api.controller;

import com.from.the.oven.api.dto.ApiResponse;
import com.from.the.oven.api.dto.OrderDTO;
import com.from.the.oven.api.entity.Order;
import com.from.the.oven.api.service.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/05/17
 */
@CrossOrigin
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@GetMapping
	public ApiResponse<OrderDTO> getAllOrders(@RequestParam(name = "limit", defaultValue = "20") Integer limit) {
		return new ApiResponse<>(
				orderService.getAll(limit).stream()
						.map(OrderDTO::new)
						.toList()
		);
	}

	@GetMapping("/{id}")
	public ApiResponse<OrderDTO> findOrderById(@PathVariable Long id) {
		Optional<Order> order = orderService.findById(id);
		if (order.isEmpty()) {
			return new ApiResponse<>(HttpStatus.NOT_FOUND);
		}
		return new ApiResponse<>(List.of(new OrderDTO(order.get())));
	}

}
