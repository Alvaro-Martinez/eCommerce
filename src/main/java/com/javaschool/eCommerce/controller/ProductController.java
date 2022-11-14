package com.javaschool.eCommerce.controller;

import com.javaschool.eCommerce.model.Product;
import com.javaschool.eCommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @PostMapping()
    ResponseEntity<Product> createProduct(){
        return new ResponseEntity<>(iProductService.createProduct(), HttpStatus.OK);
    }

    @GetMapping("/likes/{code}")
    void likeByProduct(@PathVariable int code){
        iProductService.likesByProduct(code);
    }

    @GetMapping("/product_info/{code}")
    ResponseEntity<Product> productInfoById(@PathVariable int code) {
        Product product = iProductService.productInfoById(code);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    //    @GetMapping
    //    ResponseEntity<Product> viewsPerUser(){
    //        return new ResponseEntity<>(HttpStatus.OK);
    //    }

}
