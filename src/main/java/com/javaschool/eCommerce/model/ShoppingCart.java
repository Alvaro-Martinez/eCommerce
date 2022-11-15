package com.javaschool.eCommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShoppingCart {
    private int id;
    private int customerId;
    private LocalDateTime date;
    private List<Product> products;
    private int amount;
}