package com.nataribeiro.cursospringboot2.services;

import java.util.List;
import java.util.Optional;

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
import com.nataribeiro.cursospringboot2.services.exceptions.DataBaseException;
import com.nataribeiro.cursospringboot2.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private UserRepository repository;
	
	public List<User> FindAll(){
		return repository.findAll();
	}
	
	public User findById(Long id){
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repository.save(user);
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
	
	public User update(Long id, User obj) {
		try {			
			User entity= repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
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
