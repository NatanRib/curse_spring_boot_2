package com.nataribeiro.cursospringboot2.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nataribeiro.cursospringboot2.entities.Category;
import com.nataribeiro.cursospringboot2.entities.Order;
import com.nataribeiro.cursospringboot2.entities.Product;
import com.nataribeiro.cursospringboot2.entities.User;
import com.nataribeiro.cursospringboot2.entities.enums.OrderStatus;
import com.nataribeiro.cursospringboot2.repositories.CategoryRepository;
import com.nataribeiro.cursospringboot2.repositories.OrderRepository;
import com.nataribeiro.cursospringboot2.repositories.ProductRepository;
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
	@Autowired
	private ProductRepository productRepository;

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
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5,o6,o7,o8));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	}
}