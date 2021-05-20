package com.nataribeiro.cursospringboot2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nataribeiro.cursospringboot2.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{}
