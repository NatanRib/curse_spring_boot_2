package com.nataribeiro.cursospringboot2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nataribeiro.cursospringboot2.resources.dto.order.GetOrderDTO;
import com.nataribeiro.cursospringboot2.services.OrderService;

@RestController
@RequestMapping(path = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<GetOrderDTO>> findAll(){
		List<GetOrderDTO> orders = service.findAll();
		return ResponseEntity.ok().body(orders);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<GetOrderDTO> findById(@PathVariable Long id){
		GetOrderDTO order = service.findById(id);
		return ResponseEntity.ok().body(order);
	}
}
