package com.nataribeiro.cursospringboot2.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nataribeiro.cursospringboot2.entities.User;
import com.nataribeiro.cursospringboot2.repositories.UserRepository;
import com.nataribeiro.cursospringboot2.resources.dto.user.GetUserDTO;
import com.nataribeiro.cursospringboot2.services.exceptions.DataBaseException;
import com.nataribeiro.cursospringboot2.services.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private UserRepository repository;
	
	public List<GetUserDTO> FindAll(){
		return repository.findAll().stream()
				.map(u -> GetUserDTO.fromUser(u))
					.collect(Collectors.toList());
	}
	
	public GetUserDTO findById(Long id){
		return repository.findById(id)
				.map(u -> GetUserDTO.fromUser(u))
					.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public GetUserDTO insert(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return GetUserDTO.fromUser(repository.save(user));
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public GetUserDTO update(Long id, User obj) {
		try {			
			User entity= repository.getOne(id);
			if (obj.getName() != null) entity.setName(obj.getName());
			if (obj.getEmail() != null) entity.setEmail(obj.getEmail());
			if (obj.getPhone() != null) entity.setPhone(obj.getPhone());
			if (obj.getPassword() != null) entity.setPassword( encoder.encode(obj.getPassword()));
			return GetUserDTO.fromUser(repository.save(entity));
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("chamou userservice");
		User u = repository.findUserByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException(String.format("user with username '%s' not found!", username)));
		
		return org.springframework.security.core.userdetails.User.builder()
				.username(u.getUsername())
				.password(u.getPassword())
				.roles("USER")
				.build();
	}
}
