package com.javaschool.eCommerce.repository;

import com.javaschool.eCommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
