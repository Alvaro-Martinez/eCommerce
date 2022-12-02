package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.model.Category;
import com.javaschool.eCommerce.model.Customer;
import com.javaschool.eCommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Override
    public double getCartTotal() {
        Product product = new Product(4, Category.LIQUEURS, "beer", 300, 3, 20, 10);
        List<Product> productList = Collections.singletonList(product);

        return productList.stream().filter(p -> p.getPrice() > 0).mapToDouble(Product::getPrice).sum();
    }

//    public List<Customer> getTopTenCustomersByProduct(){
//
//    }
}
