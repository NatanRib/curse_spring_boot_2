package com.nataribeiro.cursospringboot2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nataribeiro.cursospringboot2.resources.dto.category.GetCategoryDTO;
import com.nataribeiro.cursospringboot2.services.CategoryService;

@RestController
@RequestMapping(path = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<GetCategoryDTO>> findAll(){
		List<GetCategoryDTO> categories = service.findAll();
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<GetCategoryDTO> findById(@PathVariable Long id){
		GetCategoryDTO category = service.findById(id);
		return ResponseEntity.ok().body(category);
	}
}
