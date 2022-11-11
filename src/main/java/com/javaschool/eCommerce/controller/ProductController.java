package com.javaschool.eCommerce.controller;

import com.javaschool.eCommerce.model.Category;
import com.javaschool.eCommerce.model.Item;
import com.javaschool.eCommerce.model.Product;
import com.javaschool.eCommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Collections;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/likes/{code}")
    void likeByProduct(@PathVariable int code){
        System.out.println(code);
    }

    @GetMapping
    ResponseEntity<Product> createProduct(){
        Product product1 = new Product(2, Category.FRUITS_VEGETABLES, "Pears", 20.0, 50, Collections.singletonList( new Item()));
        productRepository.save(product1);
        Product product2 = productRepository.getReferenceById(2);
        product2.setLikes(product2.getLikes() + 2);
        productRepository.save(product2);
        System.out.println(product2.getLikes());
        return new ResponseEntity<>(product2, HttpStatus.OK);
    }
    @GetMapping
    ResponseEntity<Product> viewsPerUser(){
        return null;
    }

}
