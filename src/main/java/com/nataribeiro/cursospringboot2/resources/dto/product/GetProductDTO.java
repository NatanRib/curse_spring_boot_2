package com.nataribeiro.cursospringboot2.resources.dto.product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.nataribeiro.cursospringboot2.entities.Product;
import com.nataribeiro.cursospringboot2.resources.dto.category.GetCategoryDTO;

public class GetProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	private Set<GetCategoryDTO> categories = new HashSet<>();
	
	public GetProductDTO() {}

	public GetProductDTO(Long id, String name, String description, 
			Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public Set<GetCategoryDTO> getCategories() {
		return categories;
	}
	
	public static GetProductDTO fromProduct(Product p) {
		GetProductDTO product = new GetProductDTO(p.getId(), p.getName(),
				p.getDescription(), p.getPrice(), p.getImgUrl());
		p.getCategories().forEach(c -> product.categories
				.add(GetCategoryDTO.fromCategory(c)));
		return product;
	}
}
