package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.model.Customer;
import com.javaschool.eCommerce.model.Ranking;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CustomerService {

    void createCustomer(Customer customer);
   List<Ranking> topTenCustomerByProduct(int productId);
}
