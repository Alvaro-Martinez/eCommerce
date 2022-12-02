package com.javaschool.eCommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Customer {

    private int id;
    private String name;
    private String telephone;
    private String email;
    private List<Address> address;
    private ShoppingCart shoppingCart;

}
