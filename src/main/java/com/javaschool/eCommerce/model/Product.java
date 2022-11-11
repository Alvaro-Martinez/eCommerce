package com.javaschool.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private int code;
    private Category category;
    private String description;
    private double price;
    private int likes;
    @OneToMany
    @JoinColumn(name = "code")
    private List<Item> items; //Todo: entendería que va la referencia al id del item y no el objeto en sí.
    //private int amountViews;
}
