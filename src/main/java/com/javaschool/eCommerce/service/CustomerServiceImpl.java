package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.ECommerceApplication;
import com.javaschool.eCommerce.model.Customer;
import com.javaschool.eCommerce.model.Ranking;
import com.javaschool.eCommerce.model.Visit;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public void createCustomer(Customer customer) {
        ECommerceApplication.customerList.add(customer);
    }

    @Override
    public List<Ranking> topTenCustomerByProduct(int productId){
        /*
          Comparator<Visit> multipleComparator = Comparator.comparing(Visit::getAmount).thenComparing(Comparator.comparing(Visit::getCustomer)));
            list.stream().sorted(multipleComparator).forEach(System.out::println);
            .collect(Collectors.toMap(visit -> visit.getCustomer().getName(), Visit::getAmount, (v1, v2) -> v1, LinkedHashMap::new)); //Todo: investigar implementación del lambda
        */
        return ECommerceApplication.visits.stream()
                .filter(v -> v.getProduct().getCode() == productId)
                .sorted(Comparator.comparingInt(Visit::getAmount).reversed())
                .map(visit -> Ranking.builder()
                        .clientName(visit.getCustomer().getName())
                        .visits(visit.getAmount())
                        .build())
                .limit(10)
                .toList();


     }
}
