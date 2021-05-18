package com.nataribeiro.cursospringboot2.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nataribeiro.cursospringboot2.entities.Category;
import com.nataribeiro.cursospringboot2.entities.Order;
import com.nataribeiro.cursospringboot2.entities.User;
import com.nataribeiro.cursospringboot2.entities.enums.OrderStatus;
import com.nataribeiro.cursospringboot2.repositories.CategoryRepository;
import com.nataribeiro.cursospringboot2.repositories.OrderRepository;
import com.nataribeiro.cursospringboot2.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Natan Ribeiro", "natan@gmail.com", "999999999", "123456");
		User u2 = new User(null, "Renan Ribeiro", "renan@gmail.com", "999999991", "123457");
		User u3 = new User(null, "Yuri Anatalia", "yuri@gmail.com", "999999992", "123458");
		User u4 = new User(null, "Karine Marques", "karine@gmail.com", "999999993", "123459");
		
		Order o1 = new Order(null, Instant.parse("2021-05-18T15:12:54Z"), u4, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2020-06-15T08:11:44Z"), u1, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.parse("2021-01-01T11:10:34Z"), u3, OrderStatus.CANCELED);
		Order o4 = new Order(null, Instant.parse("2020-07-13T19:10:54Z"), u4, OrderStatus.SHIPPED);
		Order o5 = new Order(null, Instant.parse("1998-07-25T03:12:54Z"), u2, OrderStatus.DELIVERED);
		Order o6 = new Order(null, Instant.parse("2005-12-25T15:12:54Z"), u4, OrderStatus.DELIVERED);
		Order o7 = new Order(null, Instant.parse("2004-05-18T15:12:54Z"), u2, OrderStatus.SHIPPED);
		Order o8 = new Order(null, Instant.parse("2020-05-18T15:12:54Z"), u3, OrderStatus.CANCELED);
		
		Category cat1 = new Category(null, "Eletronicos");
		Category cat2 = new Category(null, "Comidas");
		Category cat3 = new Category(null, "Bebidas");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5,o6,o7,o8));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	}
}
