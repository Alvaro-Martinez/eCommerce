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
    ResponseEntity<Integer> getLikeByProduct(@PathVariable int code){
        return new ResponseEntity<>(productService.getLikesByProduct(code), HttpStatus.OK);
    }
    @GetMapping("/info/{code}")
    ResponseEntity<Product> getProductInfoById(@PathVariable int code) {
        Product product = productService.getProductInfoById(code);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    //    @GetMapping
    //    ResponseEntity<Product> getViewsPerUser(){
    //        return new ResponseEntity<>(views, HttpStatus.OK);
    //    }

}
