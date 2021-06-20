package com.nataribeiro.cursospringboot2.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataribeiro.cursospringboot2.entities.Order;
import com.nataribeiro.cursospringboot2.repositories.OrderRepository;
import com.nataribeiro.cursospringboot2.resources.dto.order.GetOrderDTO;
import com.nataribeiro.cursospringboot2.services.OrderService;
import com.nataribeiro.cursospringboot2.services.exceptions.ResourceNotFoundException;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository repository;
	
	public List<GetOrderDTO> findAll(){
		return repository.findAll().stream().map(
				o -> GetOrderDTO.fromOrder(o)).collect(Collectors.toList());
	}
	
	public GetOrderDTO findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return GetOrderDTO.fromOrder(obj.orElseThrow(() -> new ResourceNotFoundException(id)));
	}
}
