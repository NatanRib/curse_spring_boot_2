package com.nataribeiro.cursospringboot2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nataribeiro.cursospringboot2.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{}
