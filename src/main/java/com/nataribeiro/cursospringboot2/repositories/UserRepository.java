package com.nataribeiro.cursospringboot2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nataribeiro.cursospringboot2.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findUserByUsername(String username);

}
