package com.javaschool.eCommerce.controller;

import com.javaschool.eCommerce.model.Customer;
import com.javaschool.eCommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return ResponseEntity.ok("Customer created");
    }

    @GetMapping("/top_ten/{productId}")
    Map<String, Integer>getTopTenByProduct(@PathVariable int productId){
        return customerService.topTenCustomerByProduct(productId);
    }
}
