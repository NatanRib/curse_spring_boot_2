package com.nataribeiro.cursospringboot2.resources.dto.order;

import java.io.Serializable;
import java.time.Instant;

import com.nataribeiro.cursospringboot2.entities.Payment;

public class GetPaymentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private Instant moment;
	
	public GetPaymentDTO() {}

	public GetPaymentDTO(long id, Instant moment) {
		super();
		this.id = id;
		this.moment = moment;
	}

	public long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}
	
	public static GetPaymentDTO fromPayment(Payment p) {
		return new GetPaymentDTO(p.getId(), p.getMoment());
	}
}
