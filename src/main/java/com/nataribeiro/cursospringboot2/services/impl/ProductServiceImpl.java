package com.nataribeiro.cursospringboot2.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataribeiro.cursospringboot2.repositories.ProductRepository;
import com.nataribeiro.cursospringboot2.resources.dto.product.GetProductDTO;
import com.nataribeiro.cursospringboot2.services.ProductService;
import com.nataribeiro.cursospringboot2.services.exceptions.ResourceNotFoundException;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repository;
	
	public List<GetProductDTO> findAll(){
		 return repository.findAll().stream()
				 .map(p -> GetProductDTO.fromProduct(p))
				 	.collect(Collectors.toList());
	}
	
	public GetProductDTO findById(Long id) {
		return repository.findById(id)
				.map(p -> GetProductDTO.fromProduct(p))
					.orElseThrow(
							() -> new ResourceNotFoundException(id));
	}
}
