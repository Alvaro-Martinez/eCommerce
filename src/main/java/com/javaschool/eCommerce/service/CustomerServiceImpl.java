package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.ECommerceApplication;
import com.javaschool.eCommerce.model.Customer;
import com.javaschool.eCommerce.model.Visit;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public void createCustomer(Customer customer) {
        ECommerceApplication.customerList.add(customer);
    }

    @Override
    public Map<String, Integer> topTenCustomerByProduct(int productId){
        /*
          Comparator<Visit> multipleComparator = Comparator.comparing(Visit::getAmount).thenComparing(Comparator.comparing(Visit::getCustomer)));
            list.stream().sorted(multipleComparator).forEach(System.out::println);
        */
        return ECommerceApplication.visits.stream()
                .filter(v -> v.getProduct().getCode() == productId)
                .sorted(Comparator.comparingInt(Visit::getAmount).reversed())
                .limit(10)
                .collect(Collectors.toMap(visit -> visit.getCustomer().getName(), Visit::getAmount, (v1, v2) -> v1, LinkedHashMap::new)); //Todo: investigar implementación del lambda
     }
}
