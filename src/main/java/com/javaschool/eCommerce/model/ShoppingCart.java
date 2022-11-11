package com.javaschool.eCommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "shopping_cart")
@Data
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    private LocalDateTime date;
    @OneToMany
    @JoinColumn(name = "code")
    private List<Item> itemsProduct;
    private int amount;
}
