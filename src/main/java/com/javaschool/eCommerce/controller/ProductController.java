package com.javaschool.eCommerce.controller;

import com.javaschool.eCommerce.model.Product;
import com.javaschool.eCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    ResponseEntity<Product> createProduct(){
        return new ResponseEntity<>(productService.createProduct(), HttpStatus.OK);
    }
    @GetMapping("/likes/{code}")
    ResponseEntity<Integer> likeByProduct(@PathVariable int code){
        return new ResponseEntity<>(productService.likesByProduct(code), HttpStatus.OK);
    }
    @GetMapping("/product_info/{code}")
    ResponseEntity<Product> productInfoById(@PathVariable int code) {
        Product product = productService.productInfoById(code);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    //    @GetMapping
    //    ResponseEntity<Product> viewsPerUser(){
    //        return new ResponseEntity<>(views, HttpStatus.OK);
    //    }

}
