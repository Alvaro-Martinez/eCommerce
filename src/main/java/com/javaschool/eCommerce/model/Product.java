package com.javaschool.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Product {
    private int code;
    private Category category;
    private String description;
    private double price;
    private int amount;
    private int likes;
    private int amountViews;
}
