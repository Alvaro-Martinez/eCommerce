package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.model.DTOs.ProductLikesDTO;
import com.javaschool.eCommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface ProductService {

    void createProduct(Product product);
    int getLikesByProduct(int code) throws Exception;

    List<ProductLikesDTO> getProductLikesByCategory(Long categoryId);

    void updateLikesByProduct(int code) throws NoSuchElementException;
    Product getProductInfoById(int code, int customerId) throws Exception;
    //Product viewsPerUser();

}
