package com.javaschool.eCommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Visit {
    Customer customer;
    Product product;
    int amount;
    List<LocalDateTime> dates;

    public void addDate(LocalDateTime date) {
        this.dates.add(date);
    }
    public void increaseVisit(){
        this.amount ++;
    }
}

