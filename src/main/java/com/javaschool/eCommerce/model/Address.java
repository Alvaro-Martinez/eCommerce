package com.javaschool.eCommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
@Data
public class Address {
    private int idCustomer;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
