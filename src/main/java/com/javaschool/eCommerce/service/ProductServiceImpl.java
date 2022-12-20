package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.ECommerceApplication;
import com.javaschool.eCommerce.model.Customer;
import com.javaschool.eCommerce.model.Product;
import com.javaschool.eCommerce.model.Visit;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public void createProduct(Product product) {
        ECommerceApplication.products.add(product);
    }

    @Override
    public int getLikesByProduct(int code) throws Exception {
        Product product = ECommerceApplication.products.stream().filter(p -> p.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new Exception("product not found"));

        return product.getLikes();
    }

    @Override
    public Product getProductInfoById(int code, int customerId) throws Exception {
        Product productFound = ECommerceApplication.products.stream().filter(product -> product.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new Exception("product not found")); //Todo: producto no encontrado

            Customer customerFound = ECommerceApplication.customerList.stream().filter(c -> c.getId().equals(customerId))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Customer not found")); //Todo: Cliente no encontrado

        increaseViews(productFound, customerFound);

        return productFound;
    }

    static void increaseViews(Product product, Customer customer) {
        ECommerceApplication.visits.stream().filter(
                        v -> v.getProduct().equals(product) && v.getCustomer().equals(customer))
                .findFirst()
                .ifPresentOrElse(
                        ProductServiceImpl::addDateToExistingVisit,
                        () -> createVisitIfNotExist(product, customer));
    }
    static void addDateToExistingVisit(Visit visit){
        List<LocalDateTime> dates = visit.getDates();
        dates.add(LocalDateTime.now());
        visit.increseVisit();
    }
    static void createVisitIfNotExist(Product product, Customer customer){
        ECommerceApplication.visits.add(
                Visit.builder()
                .amount(1)
                .product(product)
                .customer(customer)
                .dates(List.of(LocalDateTime.now()))  //Collections.singletonList(LocalDateTime.now())
                .build());
    }

    @Override
    public void updateLikesByProduct(int code) throws NoSuchElementException{
        Product product = ECommerceApplication.products.stream()
                .filter(p -> p.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        product.setLikes(product.getLikes() + 1);
    }
}
