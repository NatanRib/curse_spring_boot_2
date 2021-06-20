package com.nataribeiro.cursospringboot2.resources.dto.order;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.nataribeiro.cursospringboot2.entities.Order;

public class GetOrderDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

	private Instant moment;

	private Long userId;

	private String orderStatus;

	private Double total;
	
	private Set<GetOrderItemDTO> items = new HashSet<>();

	private GetPaymentDTO payment;

	public GetOrderDTO() {}

	public GetOrderDTO(Long id, Instant moment, Long userId, String orderStatus, Double total) {
			this.id = id;
			this.moment = moment;
			this.userId = userId;
			this.orderStatus = orderStatus;
			this.total = total;
		}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public Long getUserId() {
		return userId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public Set<GetOrderItemDTO> getOrderitems() {
		return items;
	}

	public GetPaymentDTO getPayment() {
		return payment;
	}
	
	public void setGetPaymentDTO(GetPaymentDTO p) {
		payment = p;
	}

	public Double getTotal() {
		return total;
	}
	
	public static GetOrderDTO fromOrder(Order o) {
		GetOrderDTO order = new GetOrderDTO(o.getId(), o.getMoment(),
				o.getUser().getId(),o.getOrderStatus().name(), o.getTotal());
		if (o.getPayment() != null) order.setGetPaymentDTO(GetPaymentDTO.fromPayment(o.getPayment())); 
		o.getOrderitems().forEach(i -> order.items.add(GetOrderItemDTO.fromOrderItem(i)));
		return order;
	}
}
