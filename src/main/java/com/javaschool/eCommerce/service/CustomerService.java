package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface CustomerService {

    void createCustomer(Customer customer);
    Map<String, Integer> topTenCustomerByProduct(int productId);
}
