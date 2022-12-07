package com.javaschool.eCommerce.service;

import com.github.javafaker.Faker;
import com.javaschool.eCommerce.model.Category;
import com.javaschool.eCommerce.model.Customer;
import com.javaschool.eCommerce.model.Product;
import com.javaschool.eCommerce.model.Visit;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Service
public class CartServiceImpl implements CartService {

    @Override
    public double getCartTotal() {
        Faker faker = new Faker(new Locale("en-US"));
        Random rand = new Random();
        Product product = new Product(4, new Category(faker.commerce().department()), faker.commerce().productName(),
                Double.parseDouble(faker.commerce().price()), rand.nextInt(), rand.nextInt(), Collections.singletonList(new Visit()));
        List<Product> productList = Collections.singletonList(product);

        return productList.stream().filter(p -> p.getPrice() > 0).mapToDouble(Product::getPrice).sum();
    }

//    public List<Customer> getTopTenCustomersByProduct(){
//
//    }
}
