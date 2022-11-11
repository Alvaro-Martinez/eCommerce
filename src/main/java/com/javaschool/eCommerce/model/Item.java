package com.javaschool.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    private String code;
    private int amount;
    @ManyToOne
    @JoinColumn(name = "code")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "itemsProduct")
    private ShoppingCart shoppingCart;
}
