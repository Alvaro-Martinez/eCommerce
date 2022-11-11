package com.javaschool.eCommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    private String name;
    private String telephone;
    private String email;

    @OneToMany(cascade = ALL)
    @JoinColumn(name = "address_id")
    private List<Address> address;
    @OneToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;

}
