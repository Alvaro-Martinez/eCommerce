package com.javaschool.eCommerce;

import com.github.javafaker.Faker;
import com.javaschool.eCommerce.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.*;

@SpringBootApplication
public class ECommerceApplication {
	public static List<Customer> customerList = new ArrayList<>();
	public static List<Product> products = new ArrayList<>();
	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("en-US"));

		for (int i = 0; i < 12; i++) {
			Customer customer = new Customer(i + 1, faker.name().fullName(), faker.phoneNumber().phoneNumber(), faker.internet().emailAddress(),
					Collections.singletonList(new Address()), new ShoppingCart());

			customerList.add(customer);
		}
		Random rand = new Random();

		for (int i = 0; i < 10; i++) {
			Product product = new Product(i + 1, new Category(faker.commerce().department()), faker.commerce().productName(),
					rand.nextDouble(), rand.nextInt(), rand.nextInt(),
					Collections.singletonList(new Visit(1, rand.nextInt(), Date.from(Instant.now()))));
			products.add(product);
		}



		SpringApplication.run(ECommerceApplication.class, args);
	}

}
