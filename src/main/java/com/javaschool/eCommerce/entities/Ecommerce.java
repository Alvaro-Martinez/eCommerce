package com.javaschool.eCommerce.entities;

public class Ecommerce {
    private Product product;
    private Client client;
    private String description;

    public Ecommerce(Product product, Client client, String description) {
        this.product = product;
        this.client = client;
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ecommerce{" +
                "product=" + product +
                ", client=" + client +
                ", description='" + description + '\'' +
                '}';
    }
}
