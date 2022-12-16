package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.model.Product;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public interface ProductService {

    Product createProduct(Product product);
    int getLikesByProduct(int code) throws Exception;

    void updateLikesByProduct(int code) throws NoSuchElementException;
    Product getProductInfoById(int code, int customerId) throws Exception;
    //Product viewsPerUser();

}
