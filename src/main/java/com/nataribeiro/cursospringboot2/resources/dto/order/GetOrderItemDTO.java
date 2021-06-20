package com.nataribeiro.cursospringboot2.resources.dto.order;

import java.io.Serializable;

import com.nataribeiro.cursospringboot2.entities.OrderItem;

public class GetOrderItemDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long productId;
	private Integer quantity;
	private Double price;
	
	public GetOrderItemDTO() {}

	public GetOrderItemDTO(Long productId, Integer quantity, Double price) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}
	
	public static GetOrderItemDTO fromOrderItem(OrderItem i) {
		return new GetOrderItemDTO(i.getProduct().getId(), i.getQuantity(), i.getPrice());
	}
}
