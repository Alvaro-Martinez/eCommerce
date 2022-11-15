package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.model.Category;
import com.javaschool.eCommerce.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product createProduct() {
        Product product = new Product(1, Category.FRUITS_VEGETABLES, "Pear", 10, 3, 5, 2);
        product.setLikes(product.getLikes() + 2);
        System.out.println(product.getLikes());
        return product;
    }

    @Override
    public int likesByProduct(int code) {
        Product product = new Product(1, Category.FRUITS_VEGETABLES, "apple", 10, 3, 5, 10);
        return product.getLikes();
    }

    @Override
    public Product productInfoById(int code) {
        return new Product(2, Category.FRUITS_VEGETABLES, "banana", 10, 3, 5, 10);
    }
}
