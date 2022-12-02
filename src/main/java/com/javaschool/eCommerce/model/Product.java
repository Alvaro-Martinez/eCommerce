package com.javaschool.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Product {
    private int code;
    private Category category;  //Todo: a nivel de DB como modelo
    private String description;
    private double price;
    private int stock;
    private int likes;
    private List<Visit> amountViews;

    Double getPriceWithDiscount(double amountDiscount){
        return 1.0;
    }

    Double getPriceWithTax(double tax){
        return tax + 200;
    }
}
