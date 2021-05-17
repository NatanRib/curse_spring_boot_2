package com.nataribeiro.cursospringboot2.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nataribeiro.cursospringboot2.entities.User;

@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		
		User u = new User(1L, "Natan Ribeiro", "natan@gmail.com", "999998877", "123456"); 
		return ResponseEntity.ok(u);
	}
}
