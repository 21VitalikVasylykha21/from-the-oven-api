package com.from.the.oven.api.service;

import com.from.the.oven.api.dto.OrderDTO;
import com.from.the.oven.api.dto.OrderInfoDTO;
import com.from.the.oven.api.entity.Order;
import com.from.the.oven.api.entity.OrderInfo;
import com.from.the.oven.api.entity.Pizza;
import com.from.the.oven.api.entity.PizzaPrice;
import com.from.the.oven.api.exception.EntityNotFoundException;
import com.from.the.oven.api.exception.LimitApiRequestException;
import com.from.the.oven.api.exception.ValidationException;
import com.from.the.oven.api.repository.OrderInfoRepository;
import com.from.the.oven.api.repository.OrderRepository;
import com.from.the.oven.api.validator.Validator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/17
 */
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderInfoRepository orderInfoRepository;
	@Autowired
	private PizzaService pizzaService;

	public Page<Order> getAllOrders(Integer page, Integer limit) {
		if (limit <= 0) {
			throw new LimitApiRequestException();
		}
		return orderRepository.findAll(PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "orderDate")));
	}

	public Order findOrderById(Long id) throws EntityNotFoundException {
		Optional<Order> order = orderRepository.findById(id);
		if (order.isEmpty()) {
			throw new EntityNotFoundException(Order.class, id);
		}
		return order.get();
	}

	public Order createOrder(OrderDTO orderDTO) {
		Order createOrder = new Order(orderDTO);
		Validator.validate(createOrder);
		createOrder = orderRepository.save(createOrder);
		createOrderInfos(createOrder, orderDTO);
		return createOrder;
	}

	public void deleteOrder(Long id) {
		Order deleteOrder = findOrderById(id);
		orderRepository.delete(deleteOrder);
	}

	private void createOrderInfos(Order createOrder, OrderDTO orderDTO) {
		if (orderDTO.getOrderInfo().isEmpty()) {
			orderRepository.delete(createOrder);
			throw new ValidationException("Information about pizzas is missing in the user's order");
		}
		createOrder.setOrderInfo(
				orderDTO.getOrderInfo()
						.stream()
						.map(orderInfoDTO -> createOrderInfo(createOrder, orderInfoDTO))
						.toList()
		);
	}

	private OrderInfo createOrderInfo(Order createOrder, OrderInfoDTO orderInfoDTO) {
		OrderInfo createOrderInfo = new OrderInfo();
		List<Pizza> pizzas = pizzaService.searchByName(orderInfoDTO.getName()).pizzas();
		if (pizzas.size() != 1) {
			orderRepository.delete(createOrder);
			throw new ValidationException("Pizza with the name: " + orderInfoDTO.getName() + " was not found");
		}
		Optional<PizzaPrice> optionalPizzaPrice = pizzas.get(0).getPrices().stream().filter(pizzaPrice -> pizzaPrice.getSize().getSize().equals(orderInfoDTO.getSize())).findFirst();
		if (optionalPizzaPrice.isEmpty()) {
			orderRepository.delete(createOrder);
			throw new ValidationException("Pizza price for the pizza size: " + orderInfoDTO.getSize() + " sm in the pizza named: " + orderInfoDTO.getName() + " was not found");
		}
		createOrderInfo.setOrder(createOrder);
		createOrderInfo.setPizzaPrice(optionalPizzaPrice.get());
		createOrderInfo.setCount(orderInfoDTO.getCount());
		Validator.validate(createOrderInfo);
		return orderInfoRepository.save(createOrderInfo);
	}
}
