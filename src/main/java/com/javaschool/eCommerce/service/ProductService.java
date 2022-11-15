package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Product createProduct();
    int likesByProduct(int code);
    Product productInfoById(int code);
    //Product viewsPerUser();

}
