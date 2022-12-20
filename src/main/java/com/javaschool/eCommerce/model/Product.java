package com.javaschool.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Product {
    private int code;
    private Category category;
    private String description;
    private double price;
    private int stock;
    private int likes;

    Double getPriceWithDiscount(double amountDiscount){
        return 1.0;
    }

    Double getPriceWithTax(double tax){
        return tax + 200;
    }
}
