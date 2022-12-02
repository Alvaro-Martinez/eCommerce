package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Product createProduct();
    int getLikesByProduct(int code);
    Product getProductInfoById(int code);
    //Product viewsPerUser();

}
