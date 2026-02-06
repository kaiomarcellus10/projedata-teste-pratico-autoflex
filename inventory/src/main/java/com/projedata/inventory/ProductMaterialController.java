package com.projedata.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-materials")
public class ProductMaterialController {

    @Autowired
    private ProductMaterialService service;

    @GetMapping
    public ResponseEntity<List<ProductMaterial>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<ProductMaterial> salvar(
            @RequestParam Long productId,
            @RequestParam Long rawMaterialId,
            @RequestParam Double quantityNeeded
    ) {
        return ResponseEntity.ok(
                service.salvar(productId, rawMaterialId, quantityNeeded)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
