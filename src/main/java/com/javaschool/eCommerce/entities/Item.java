package com.javaschool.eCommerce.entities;

public class Item {
    private String code;
    private String itemName;
    private Category category;
    private int amount;

    public Item(String code, String itemName, Category category, int amount) {
        this.code = code;
        this.itemName = itemName;
        this.category = category;
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", itemName='" + itemName + '\'' +
                ", category=" + category +
                ", amount=" + amount +
                '}';
    }
}
