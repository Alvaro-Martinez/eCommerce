package com.javaschool.eCommerce;

import com.github.javafaker.Faker;
import com.javaschool.eCommerce.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ECommerceApplication {
	public static List<Product> products = new ArrayList<>();
	public static List<Customer> customerList = new ArrayList<>();
	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("en-US"));

		for (int i = 0; i < 10; i++) {
			Product product = new Product(i + 1, Category.FRUITS_VEGETABLES, faker.commerce().productName(), 10, 3, 0, Collections.singletonList(new Visit()));
			products.add(product);
		}

		for (int i = 0; i < 12; i++) {
			Customer customer = new Customer(i + 1, faker.name().fullName(), faker.phoneNumber().phoneNumber(), faker.internet().emailAddress(),
					Collections.singletonList(new Address()), new ShoppingCart());

			customerList.add(customer);
		}

		SpringApplication.run(ECommerceApplication.class, args);
	}

}
