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

    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody Product product ){
        return ResponseEntity.ok(productService.createProduct(product)); //Todo: investigar con .create()
    }
    @GetMapping("/likes/{code}")
    ResponseEntity<Integer> getLikeByProduct(@PathVariable int code){
        return new ResponseEntity<>(productService.getLikesByProduct(code), HttpStatus.OK);
    }
    @GetMapping("/info/{code}")
    ResponseEntity<Product> getProductInfoById(@PathVariable int code, @RequestHeader("customer-id") int customerId) throws Exception {
        Product product = productService.getProductInfoById(code, customerId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PatchMapping("/like/{code}")
    void updateLikesByProduct(@PathVariable int code){
        productService.updateLikesByProduct(code);
    }

}
