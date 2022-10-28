package com.javaschool.eCommerce.entities;

public class Product {
    private Category category;
    private String description;
    private double price;
    private int code;

    public Product(Category category, String description, double price, int code) {
        this.category = category;
        this.description = description;
        this.price = price;
        this.code = code;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", descirpcion='" + description + '\'' +
                ", price=" + price +
                ", code=" + code +
                '}';
    }
}
