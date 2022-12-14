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

	static Category vegetable = new Category("vegetable");
	static Category meat = new Category("meat");
	static Category dairy = new Category("dairy");
	static Category beverage = new Category("beverage");
	static Category frozen = new Category("frozen");

	public static Category[] categories = {vegetable, meat, dairy, beverage, frozen};

	public static Random rand = new Random();
	public static Category getRndCategory(){
		return categories[rand.nextInt(categories.length)];
	}
	public static int getRndCustomer(){
		return customerList.get(rand.nextInt(customerList.size())).getId();
	}

	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("en-US"));

		for (int i = 0; i < 15; i++) {
			Customer customer = new Customer(i + 1, faker.name().fullName(), faker.phoneNumber().phoneNumber(), faker.internet().emailAddress(),
					Collections.singletonList(new Address()), new ShoppingCart());

			customerList.add(customer);
		}

		for (int i = 0; i < 10; i++) {
			Product product = new Product(i + 1, getRndCategory(), faker.commerce().productName(),
					rand.nextDouble(), rand.nextInt(), rand.nextInt(),
					Collections.singletonList(new Visit(getRndCustomer(), rand.nextInt(), Date.from(Instant.now()))));

			products.add(product);
		}

		SpringApplication.run(ECommerceApplication.class, args);
	}

}
