package com.nataribeiro.cursospringboot2.resources.dto.category;

import java.io.Serializable;

import com.nataribeiro.cursospringboot2.entities.Category;

public class GetCategoryDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	GetCategoryDTO(){}

	public GetCategoryDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public static GetCategoryDTO fromCategory(Category cat) {
		return new GetCategoryDTO(cat.getId(), cat.getName());
	}
}