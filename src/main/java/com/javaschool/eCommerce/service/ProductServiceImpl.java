package com.javaschool.eCommerce.service;

import com.github.javafaker.Faker;
import com.javaschool.eCommerce.ECommerceApplication;
import com.javaschool.eCommerce.model.Category;
import com.javaschool.eCommerce.model.Customer;
import com.javaschool.eCommerce.model.Product;
import com.javaschool.eCommerce.model.Visit;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    Faker faker = new Faker(new Locale("en-US"));
    @Override
    public Product createProduct(Product product) { //Todo: convertirlo a Void
        ECommerceApplication.products.add(product);
        return product;
    }

    @Override
    public int getLikesByProduct(int code) {
        Product product = new Product(1, new Category(faker.commerce().department()), "apple", 10, 3, 5);
        return product.getLikes();
    }

    @Override
    public Product getProductInfoById(int code, int customerId) throws Exception {
        Product productFound = ECommerceApplication.products.stream().filter(product -> product.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new Exception("Producto no encontrado")); //Todo: producto no encontrado

            Customer customer = ECommerceApplication.customerList.stream().filter(c -> c.getId().equals(customerId))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Cliente no encontrado")); //Todo: Cliente no encontrado

        increaseViews(productFound, customer);

//        productList.removeIf(p -> p.getCode() == code);
//        productList.add(product);
//        ECommerceApplication.products = productList;

        return productFound;
    }

    static void increaseViews(Product product, Customer customer) {
        Visit visit = ECommerceApplication.visits.stream().filter(
                        v -> v.getProduct().equals(product) && v.getCustomer().equals(customer))
                .findFirst()
//                .ifPresentOrElse(
//                    (value) -> {updateViewsIfExist(value)}, //Todo: agregar si No existe la vista.
//                    ()      -> {method()});

                .orElse(Visit.builder()
                        .customer(customer)
                        .product(product)
                        .amount(0) //Todo: inverstigar forma de iniciar un valor numérico en cero por defecto
                        .dates(new ArrayList<>())
                        .build());

        visit.setAmount(visit.getAmount() + 1); //Todo: agregar un método dentro de la clase Visit que incremente el amount

        List<LocalDateTime> dates = visit.getDates();
        dates.add(LocalDateTime.now());
        visit.setDates(dates);

    }

    static void updateViewsIfNotExist(Visit visit){
        ECommerceApplication.visits.add(visit);
    }

    @Override
    public void updateLikesByProduct(int code) {
        Product product = ECommerceApplication.products.stream()
                .filter(p -> p.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        product.setLikes(product.getLikes() + 1);
    }
}
