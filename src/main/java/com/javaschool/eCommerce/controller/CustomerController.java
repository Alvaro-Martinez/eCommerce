package com.javaschool.eCommerce.controller;

import com.javaschool.eCommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/top_ten_by_product/{productId}")
    ResponseEntity<Map<String, Integer>>getTopTenByProduct(@PathVariable int productId){
        return new ResponseEntity<>(customerService.topTenCustomerByProduct(productId), HttpStatus.OK);
    }
}
