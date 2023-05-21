package com.from.the.oven.api.entity;

import static com.from.the.oven.api.util.DateHelper.nowTimestamp;

import com.from.the.oven.api.dto.OrderDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

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
	@NotBlank(message = "Delivery address is required")
	@Column(name = "delivery_address")
	private String deliveryAddress;

	@NotNull(message = "Total amount must be specified")
	@Positive(message = "Total amount must be a positive value")
	@Column(name = "total_amount")
	private Double totalAmount;

	@NotBlank(message = "Customer name is required")
	@Size(max = 100, message = "Customer name must be up to 100 characters")
	@Column(name = "customer_name")
	private String customerName;

	@NotBlank(message = "Customer telephone is required")
	@Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid telephone number")
	@Size(max = 20, message = "Customer telephone must be up to 20 characters")
	@Column(name = "customer_telephone")
	private String customerTelephone;

	@Size(max = 500, message = "Customer comment must be up to 500 characters")
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

	public Order(OrderDTO orderDTO) {
		this.customerName = orderDTO.getCustomerName();
		this.customerTelephone = orderDTO.getCustomerTelephone();
		this.deliveryAddress = orderDTO.getDeliveryAddress();
		this.totalAmount = orderDTO.getTotalAmount();
		this.customerComment = orderDTO.getCustomerComment();
		this.callUser = orderDTO.getCallUser();
		this.delivered = orderDTO.getDelivered();
		this.orderDate = Objects.isNull(orderDTO.getOrderDate()) ? null : Timestamp.valueOf(orderDTO.getOrderDate());
	}

	@PrePersist
	public void prePersist() {
		if (Objects.isNull(orderDate)) {
			orderDate = nowTimestamp();
		}
		if (Objects.isNull(callUser)) {
			callUser = true;
		}
		if (Objects.isNull(delivered)) {
			delivered = false;
		}
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
