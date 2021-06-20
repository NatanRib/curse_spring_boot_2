package com.nataribeiro.cursospringboot2.services;

import java.util.List;

import com.nataribeiro.cursospringboot2.entities.Order;

public interface OrderService {
	
	public List<Order> findAll();
	
	public Order findById(Long id);
}
