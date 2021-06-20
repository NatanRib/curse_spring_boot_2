package com.nataribeiro.cursospringboot2.services;

import java.util.List;

import com.nataribeiro.cursospringboot2.resources.dto.category.GetCategoryDTO;

public interface CategoryService {

	public List<GetCategoryDTO> findAll();
	
	public GetCategoryDTO findById(Long id);
}
