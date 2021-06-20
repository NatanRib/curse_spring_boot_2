package com.nataribeiro.cursospringboot2.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nataribeiro.cursospringboot2.resources.dto.user.CreateUserDTO;
import com.nataribeiro.cursospringboot2.resources.dto.user.GetUserDTO;
import com.nataribeiro.cursospringboot2.resources.dto.user.UpdateUserDTO;
import com.nataribeiro.cursospringboot2.services.impl.UserServiceImpl;

@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	@Autowired
	private UserServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<GetUserDTO>> findAll() {
		List<GetUserDTO> list = service.FindAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GetUserDTO> findById(@PathVariable Long id){
		GetUserDTO user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<GetUserDTO> insert(@RequestBody @Valid CreateUserDTO obj){
		GetUserDTO user = service.insert(obj.toUser());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<GetUserDTO> update(@PathVariable Long id,@RequestBody UpdateUserDTO obj){
		GetUserDTO user = service.update(id, obj.toUser());
		return ResponseEntity.ok().body(user);
	}
}
		