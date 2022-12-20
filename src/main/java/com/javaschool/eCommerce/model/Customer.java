package com.javaschool.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private List<Address> address;
    private ShoppingCart shoppingCart;

}
