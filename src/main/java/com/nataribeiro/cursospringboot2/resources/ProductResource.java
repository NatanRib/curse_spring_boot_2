package com.nataribeiro.cursospringboot2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nataribeiro.cursospringboot2.entities.Product;
import com.nataribeiro.cursospringboot2.services.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> products = service.findAll();
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product product = service.findById(id);
		return ResponseEntity.ok().body(product);
	}
}
