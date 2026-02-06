package com.projedata.inventory;

import jakarta.persistence.*;

@Entity
public class ProductMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Produto product;

    @ManyToOne
    @JoinColumn(name = "raw_material_id")
    private RawMaterial rawMaterial;

    private Double quantityNeeded;

    public Long getId() {
        return id;
    }

    public Produto getProduct() {
        return product;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public Double getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setProduct(Produto product) {
        this.product = product;
    }

    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public void setQuantityNeeded(Double quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }
}
