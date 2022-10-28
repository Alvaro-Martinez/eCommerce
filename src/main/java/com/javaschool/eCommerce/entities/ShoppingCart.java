package com.javaschool.eCommerce.entities;

import java.time.LocalDateTime;
import java.util.List;

public class ShoppingCart {
    private LocalDateTime date;
    private List<Item> itemProduct;
    private int amount;

    public ShoppingCart() {
    }

    public ShoppingCart(LocalDateTime date, List<Item> itemProduct, int amount) {
        this.date = date;
        this.itemProduct = itemProduct;
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Item> getItemProduct() {
        return itemProduct;
    }

    public void setItemProduct(List<Item> itemProduct) {
        this.itemProduct = itemProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "date=" + date +
                ", itemProduct=" + itemProduct +
                ", amount=" + amount +
                '}';
    }
}
