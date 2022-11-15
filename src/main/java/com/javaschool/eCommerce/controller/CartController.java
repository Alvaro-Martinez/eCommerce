package com.javaschool.eCommerce.controller;

import com.javaschool.eCommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/cart_total")
    ResponseEntity<Double> getCartTotal(){
        return new ResponseEntity<>(cartService.getCartTotal(), HttpStatus.OK);
    }

}
