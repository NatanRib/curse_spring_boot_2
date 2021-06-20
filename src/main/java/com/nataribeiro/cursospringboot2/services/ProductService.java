package com.nataribeiro.cursospringboot2.services;

import java.util.List;

import com.nataribeiro.cursospringboot2.entities.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public Product findById(Long id);
}
