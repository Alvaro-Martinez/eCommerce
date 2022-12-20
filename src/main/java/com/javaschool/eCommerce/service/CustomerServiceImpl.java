package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.ECommerceApplication;
import com.javaschool.eCommerce.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public void createCustomer(Customer customer) {
        ECommerceApplication.customerList.add(customer);
    }

    @Override
    public Map<String, Integer> topTenCustomerByProduct(int productId){
    // return products.stream()
    //Todo: filtar, flatmap, sorted, etc , crear un void createCustomer(Customer customer) (lo agrega a la lista)
    //.sorted(Comparator.comparing(Visit::getamountViews)).collect(Collectors.toList());
        return null;
     }
}
