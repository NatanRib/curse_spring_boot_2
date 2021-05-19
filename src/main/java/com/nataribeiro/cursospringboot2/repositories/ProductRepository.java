package com.nataribeiro.cursospringboot2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nataribeiro.cursospringboot2.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{}