package com.javaschool.eCommerce.service;

import com.javaschool.eCommerce.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
//métodos: obtener likes por productos, registrar visitas de un usuario a un producto, Obtener datos de un producto,
    // Dar el precio final de un producto, totalizar el carrito de compras .reduce(0, Integer::sum);

    Product createProduct();
    int likesByProduct(int code);
    Product productInfoById(int code);
    //Product viewsPerUser();

}
