package com.javaschool.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Integer id;
    private String name;
    private String telephone;
    private String email;
    private List<Address> address;
    private ShoppingCart shoppingCart;

}
