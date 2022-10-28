package com.javaschool.eCommerce.entities;

public class Client {
    private String name;
    private String telephone;
    private String email;
    private Address address;

    private ShoppingCart shoppingCart;

    public Client() {
    }
    public Client(String name, String telephone, String email, Address address, ShoppingCart shoppingCart) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.shoppingCart = shoppingCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
