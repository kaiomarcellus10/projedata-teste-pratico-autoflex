package com.projedata.inventory;

import jakarta.persistence.*;

@Entity
public class RawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double stockQuantity;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getStockQuantity() {
        return stockQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStockQuantity(Double stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
