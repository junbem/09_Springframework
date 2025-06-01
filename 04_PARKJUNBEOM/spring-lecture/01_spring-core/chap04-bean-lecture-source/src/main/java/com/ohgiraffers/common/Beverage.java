package com.ohgiraffers.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Beverage extends Product {

    private int capacity;

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    public Beverage() {
    }

    @Override
    public String toString() {
        return super.toString() + " " + capacity;

    }
}
