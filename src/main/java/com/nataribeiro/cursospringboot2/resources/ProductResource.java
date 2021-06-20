package com.nataribeiro.cursospringboot2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nataribeiro.cursospringboot2.resources.dto.product.GetProductDTO;
import com.nataribeiro.cursospringboot2.services.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<GetProductDTO>> findAll(){
		List<GetProductDTO> products = service.findAll();
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<GetProductDTO> findById(@PathVariable Long id){
		GetProductDTO product = service.findById(id);
		return ResponseEntity.ok().body(product);
	}
}
