package com.javaschool.eCommerce.service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public Map<String, Integer> topTenCustomerByProduct(int productId){
    // return products.stream()
    //Todo: filtar, flatmap, sorted, etc
    //.sorted(Comparator.comparing(Visit::getamountViews)).collect(Collectors.toList());
        return null;
     }
}
