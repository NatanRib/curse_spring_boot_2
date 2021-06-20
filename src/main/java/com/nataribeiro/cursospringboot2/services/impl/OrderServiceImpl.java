package com.nataribeiro.cursospringboot2.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataribeiro.cursospringboot2.entities.Order;
import com.nataribeiro.cursospringboot2.repositories.OrderRepository;
import com.nataribeiro.cursospringboot2.services.OrderService;
import com.nataribeiro.cursospringboot2.services.exceptions.ResourceNotFoundException;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		List<Order>list = repository.findAll();
		return list;
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
