package com.javaschool.eCommerce.service;

import com.github.javafaker.Faker;
import com.javaschool.eCommerce.ECommerceApplication;
import com.javaschool.eCommerce.model.Category;
import com.javaschool.eCommerce.model.Product;
import com.javaschool.eCommerce.model.Visit;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product createProduct() {
        Faker faker = new Faker(new Locale("en-US"));

        Product product = new Product(1, Category.FRUITS_VEGETABLES, faker.food().fruit(), 10, 3, 5, Collections.singletonList(new Visit()));
        product.setLikes(product.getLikes() + 2);
        System.out.println(product.getLikes());
        return product;
    }

    @Override
    public int getLikesByProduct(int code) {
        Product product = new Product(1, Category.FRUITS_VEGETABLES, "apple", 10, 3, 5, Collections.singletonList(new Visit()));
        return product.getLikes();
    }

    @Override
    public Product getProductInfoById(int code) {
        Optional<Product> productFound = ECommerceApplication.products.stream().filter(product -> product.getCode() == code).findFirst();
        productFound.ifPresent(p -> p.setAmountViews(p.getAmountViews())); //Todo: resting increment the amount of view

//        productList.removeIf(p -> p.getCode() == code);
//        productList.add(product);
//        ECommerceApplication.products = productList;

        return productFound.orElseThrow();

    }
}
