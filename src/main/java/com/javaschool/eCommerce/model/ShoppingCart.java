package com.javaschool.eCommerce.model;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShoppingCart {
    private int id;
    private int customerId;
    private LocalDateTime date;
    private List<Product> products;
}