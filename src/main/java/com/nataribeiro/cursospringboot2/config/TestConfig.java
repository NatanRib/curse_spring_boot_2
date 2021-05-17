package com.nataribeiro.cursospringboot2.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nataribeiro.cursospringboot2.entities.User;
import com.nataribeiro.cursospringboot2.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Natan Ribeiro", "natan@gmail.com", "999999999", "123456");
		User u2 = new User(null, "Renan Ribeiro", "renan@gmail.com", "999999991", "123457");
		User u3 = new User(null, "Yuri Anatalia", "yuri@gmail.com", "999999992", "123458");
		User u4 = new User(null, "Karine Marques", "karine@gmail.com", "999999993", "123459");
		
		repository.saveAll(Arrays.asList(u1,u2,u3,u4));
	}
}
