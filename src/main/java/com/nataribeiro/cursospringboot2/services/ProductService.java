package com.nataribeiro.cursospringboot2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataribeiro.cursospringboot2.entities.Product;
import com.nataribeiro.cursospringboot2.repositories.ProductRepository;
import com.nataribeiro.cursospringboot2.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		List<Product> products = repository.findAll();
		return products;
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
