package com.nataribeiro.cursospringboot2.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataribeiro.cursospringboot2.repositories.CategoryRepository;
import com.nataribeiro.cursospringboot2.resources.dto.category.GetCategoryDTO;
import com.nataribeiro.cursospringboot2.services.CategoryService;
import com.nataribeiro.cursospringboot2.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository repository;
	
	public List<GetCategoryDTO> findAll(){
		List<GetCategoryDTO> categories = repository.findAll().stream()
				.map(c -> GetCategoryDTO.fromCategory(c))
				.collect(Collectors.toList());
		return categories;
	}
	
	public GetCategoryDTO findById(Long id) {
		return repository.findById(id)
			.map(c -> GetCategoryDTO.fromCategory(c))
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
