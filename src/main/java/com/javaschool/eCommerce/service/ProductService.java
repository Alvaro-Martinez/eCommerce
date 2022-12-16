package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Product createProduct(Product product);
    int getLikesByProduct(int code);

    void updateLikesByProduct(int code);
    Product getProductInfoById(int code, int customerId) throws Exception;
    //Product viewsPerUser();

}
