package com.nataribeiro.cursospringboot2.services;

import java.util.List;

import com.nataribeiro.cursospringboot2.resources.dto.order.GetOrderDTO;

public interface OrderService {
	
	public List<GetOrderDTO> findAll();
	
	public GetOrderDTO findById(Long id);
}
