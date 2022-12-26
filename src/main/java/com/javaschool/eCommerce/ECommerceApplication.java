package com.javaschool.eCommerce;

import com.github.javafaker.Faker;
import com.javaschool.eCommerce.model.*;
import com.javaschool.eCommerce.service.CustomerService;
import com.javaschool.eCommerce.service.CustomerServiceImpl;
import com.javaschool.eCommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@AllArgsConstructor
@SpringBootApplication
public class ECommerceApplication {
	public static List<Customer> customers = new ArrayList<>();
	public static List<Product> products = new ArrayList<>();
	public static List<Visit> visits = new ArrayList<>();

	public static List<Category> categories = Arrays.asList(new Category(1L, "vegetable"), new Category(2L, "meat"),
			new Category(3L, "dairy"), new Category(4L, "beverage"), new Category(5L, "frozen"));

	public static Random rand = new Random();
	public static Category getRndCategory(){
		return categories.get(rand.nextInt(categories.size()));
	}
	public static Customer getRndCustomer(){
		return customers.get(rand.nextInt(customers.size()));
	}
	public static Product getRndProduct(){
		return products.get(rand.nextInt(products.size()));
	}

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductService productService) {
		return args ->{
			Faker faker = new Faker(new Locale("en-US"));
			CustomerService customerService = new CustomerServiceImpl();

			for (int i = 0; i < 15; i++) {

				customerService.createCustomer(
						Customer.builder()
								.id(i + 1)
								.name(faker.name().fullName())
								.phoneNumber(faker.phoneNumber().phoneNumber())
								.email(faker.internet().emailAddress())
								.address(List.of(new Address()))
								.shoppingCart(new ShoppingCart())
								.build());
			}

			//ProductService productService = new ProductServiceImpl();

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

			for (int i = 0; i < 500; i++) {
				productService.getProductInfoById(getRndProduct().getCode(), getRndCustomer().getId());
			}

		};
	}

}
