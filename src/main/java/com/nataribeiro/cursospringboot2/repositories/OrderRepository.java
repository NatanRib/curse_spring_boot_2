package com.nataribeiro.cursospringboot2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nataribeiro.cursospringboot2.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{	
}
