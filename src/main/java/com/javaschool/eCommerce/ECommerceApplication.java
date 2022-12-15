package com.javaschool.eCommerce;

import com.github.javafaker.Faker;
import com.javaschool.eCommerce.model.*;
import com.javaschool.eCommerce.service.ProductService;
import com.javaschool.eCommerce.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@AllArgsConstructor
@SpringBootApplication
public class ECommerceApplication {
	public static List<Customer> customerList = new ArrayList<>(); //Collections.emptyList();
	public static List<Product> products = new ArrayList<>();
	public static List<Visit> visits = new ArrayList<>(); //Todo: new ArrayList<>() vs Collections.emptyList()

	public static List<Category> categories = List.of(new Category("vegetable"), new Category("meat"), new Category("dairy"),
			new Category("beverage"), new Category("frozen"));

	public static Random rand = new Random();
	public static Category getRndCategory(){
		return categories.get(rand.nextInt(categories.size()));
	}
	public static Customer getRndCustomer(){
		return customerList.get(rand.nextInt(customerList.size()));
	}

	public static void main(String[] args) {
		inicializeData();

		SpringApplication.run(ECommerceApplication.class, args);
	}

	private static void inicializeData() {
		Faker faker = new Faker(new Locale("en-US"));

		for (int i = 0; i < 15; i++) {
			Customer customer = new Customer(i + 1, faker.name().fullName(), faker.phoneNumber().phoneNumber(), faker.internet().emailAddress(),
					Collections.singletonList(new Address()), new ShoppingCart());

			customerList.add(customer); //Todo: llamar al método createCustomer e implementar Builder()
		}

		ProductService productService = new ProductServiceImpl();
		for (int i = 0; i < 10; i++) {

			productService.createProduct(
					Product.builder()
							.code(i + 1)
							.category(getRndCategory())
							.description(faker.commerce().productName())
							.price(rand.nextDouble())
							.stock(rand.nextInt())
							.likes(0)
							.build()
			);
		}
	}

}
