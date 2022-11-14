package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.model.Category;
import com.javaschool.eCommerce.model.Product;
import com.javaschool.eCommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService implements IProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(){
        Product product1 = new Product(2, Category.FRUITS_VEGETABLES, "Pears", 50, 5, 1, 1);
        productRepository.save(product1);
        Product product2 = productRepository.getReferenceById(2);
        product2.setLikes(product2.getLikes() + 2);
        System.out.println(product2.getLikes());
        return productRepository.save(product2);
    }
    @Override
    public void likesByProduct(int code) {
        Product product = productRepository.getReferenceById(2);
        System.out.println(product.getLikes());
    }

    @Override
    public Product productInfoById(int code) {
        return productRepository.getReferenceById(2);
    }
}
