package com.javaschool.eCommerce.controller;

import com.javaschool.eCommerce.model.DTOs.ProductLikesDTO;
import com.javaschool.eCommerce.model.DTOs.ProductVisitsDTO;
import com.javaschool.eCommerce.model.Product;
import com.javaschool.eCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    ResponseEntity<String> createProduct(@RequestBody Product product ){
        productService.createProduct(product);
        return ResponseEntity.ok("Product Created");
    }
    @GetMapping("/likes/{code}")
    ResponseEntity<Integer> getLikeByProduct(@PathVariable int code) throws Exception {
        return new ResponseEntity<>(productService.getLikesByProduct(code), HttpStatus.OK);
    }
    @GetMapping("/product_likes/{category_id}")
    List<ProductLikesDTO> getProductLikesByCategory(@PathVariable("category_id") Long categoryId){
        return productService.getProductLikesByCategory(categoryId);
    }
    @GetMapping("/products")
    List<ProductVisitsDTO> getGlobalProductVisits(){
        return productService.getGlobalProductVisits();
    }
    @GetMapping("/info/{code}")
    ResponseEntity<Product> getProductInfoById(@PathVariable int code, @RequestHeader("customer-id") int customerId) throws Exception {
        Product product = productService.getProductInfoById(code, customerId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PatchMapping("/like/{code}")
    void updateLikesByProduct(@PathVariable int code) throws NoSuchElementException {
        productService.updateLikesByProduct(code);
    }

}
