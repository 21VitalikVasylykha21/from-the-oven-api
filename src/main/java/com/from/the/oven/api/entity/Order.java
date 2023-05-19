package com.from.the.oven.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/05/17
 */
@Entity
@Table(name = "pizza_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pizza_order_id")
	private Long id;
	@Column(name = "order_date")
	private Timestamp orderDate;
	@Column(name = "is_delivered")
	private Boolean delivered;
	@Column(name = "call_user")
	private Boolean callUser;
	@Column(name = "delivery_address")
	private String deliveryAddress;
	@Column(name = "total_amount")
	private Double totalAmount;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_telephone")
	private String customerTelephone;
	@Column(name = "customer_comment")
	private String customerComment;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "pizza_order_info",
			joinColumns = @JoinColumn(name = "pizza_order_id"),
			inverseJoinColumns = @JoinColumn(name = "pizza_order_info_id")
	)
	private List<OrderInfo> orderInfo;

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
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

	public List<OrderInfo> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(List<OrderInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}
}
