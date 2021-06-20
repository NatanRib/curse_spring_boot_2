package com.nataribeiro.cursospringboot2.services;

import java.util.List;

import com.nataribeiro.cursospringboot2.resources.dto.product.GetProductDTO;

public interface ProductService {
	
	public List<GetProductDTO> findAll();
	
	public GetProductDTO findById(Long id);
}
