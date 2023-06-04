package com.from.the.oven.api.dto;

import com.from.the.oven.api.entity.Order;
import com.from.the.oven.api.util.DateHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/17
 */
public class OrderDTO {
	private Long id;
	private String orderDate;
	private Boolean delivered;
	private Boolean callUser;
	private String deliveryAddress;
	private Double totalAmount;
	private String customerName;
	private String customerTelephone;
	private String customerComment;
	private List<OrderInfoDTO> orderInfo;

	public OrderDTO() {
	}

	public OrderDTO(Order order) {
		this.id = order.getId();
		this.orderDate = DateHelper.formatDate(order.getOrderDate());
		this.delivered = order.getDelivered();
		this.callUser = order.getCallUser();
		this.deliveryAddress = order.getDeliveryAddress();
		this.totalAmount = order.getTotalAmount();
		this.customerName = order.getCustomerName();
		this.customerTelephone = order.getCustomerTelephone();
		this.customerComment = order.getCustomerComment();
		this.orderInfo = new ArrayList<>(order.getOrderInfo().size());
		order.getOrderInfo().forEach(orderInfo -> this.orderInfo.add(new OrderInfoDTO(orderInfo)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Boolean getDelivered() {
		return delivered;
	}

	public void setDelivered(Boolean delivered) {
		this.delivered = delivered;
	}

	public Boolean getCallUser() {
		return callUser;
	}

	public void setCallUser(Boolean callUser) {
		this.callUser = callUser;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerTelephone() {
		return customerTelephone;
	}

	public void setCustomerTelephone(String customerTelephone) {
		this.customerTelephone = customerTelephone;
	}

	public String getCustomerComment() {
		return customerComment;
	}

	public void setCustomerComment(String customerComment) {
		this.customerComment = customerComment;
	}

	public List<OrderInfoDTO> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(List<OrderInfoDTO> orderInfo) {
		this.orderInfo = orderInfo;
	}
}
