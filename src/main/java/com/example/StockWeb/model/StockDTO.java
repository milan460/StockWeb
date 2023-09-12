package com.example.StockWeb.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class StockDTO {
    @Getter
    @Setter
    private int price;

    @Getter
    @Setter
    private String name;

    public StockDTO(){}

    public StockDTO(int price, String name){
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockDTO stockDTO = (StockDTO) o;
        return price == stockDTO.price && Objects.equals(name, stockDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override
    public String toString() {
        return "StockDTO{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
