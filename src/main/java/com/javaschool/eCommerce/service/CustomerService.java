package com.javaschool.eCommerce.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface CustomerService {
    Map<String, Integer> topTenCustomerByProduct(int productId);
}
