package com.projedata.inventory;

public class ProductWithoutMaterialsException extends RuntimeException {
    public ProductWithoutMaterialsException(Long productId) {
        super("Product " + productId + " has no materials configured");
    }
}
