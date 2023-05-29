package com.from.the.oven.api.controller;

import com.from.the.oven.api.dto.ApiResponse;
import com.from.the.oven.api.dto.OrderDTO;
import com.from.the.oven.api.entity.Order;
import com.from.the.oven.api.exception.EntityNotFoundException;
import com.from.the.oven.api.exception.ValidationException;
import com.from.the.oven.api.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ApiResponse<OrderDTO> getAllOrders(@RequestParam(name = "page", defaultValue = "1") Integer page,
											  @RequestParam(name = "limit", defaultValue = "20") Integer limit) {
		Page<Order> orders = orderService.getAllOrders(page, limit);
		return new ApiResponse<>(orders.getTotalElements(),
				orders.getContent().stream()
						.map(OrderDTO::new)
						.toList()
		);
	}

	@GetMapping("/{id}")
	public ApiResponse<OrderDTO> findOrderById(@PathVariable Long id) {
		try {
			return new ApiResponse<>(List.of(new OrderDTO(orderService.findOrderById(id))));
		} catch (EntityNotFoundException exception) {
			return new ApiResponse<>(HttpStatus.BAD_REQUEST, exception);
		}
	}

	@PostMapping
	public ApiResponse<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
		try {
			return new ApiResponse<>(HttpStatus.CREATED, List.of(new OrderDTO(orderService.createOrder(orderDTO))));
		} catch (ValidationException validationException) {
			return new ApiResponse<>(HttpStatus.BAD_REQUEST, validationException);
		}
	}

	@DeleteMapping("/{id}")
	public ApiResponse<OrderDTO> deleteOrder(@PathVariable Long id) {
		try {
			return new ApiResponse<>(List.of(new OrderDTO(orderService.deleteOrder(id))));
		} catch (EntityNotFoundException exception) {
			return new ApiResponse<>(HttpStatus.BAD_REQUEST, exception);
		}
	}
}
