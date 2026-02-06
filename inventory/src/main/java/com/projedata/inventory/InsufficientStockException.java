package com.projedata.inventory;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String materialName) {
        super("Insufficient stock for material: " + materialName);
    }
}
