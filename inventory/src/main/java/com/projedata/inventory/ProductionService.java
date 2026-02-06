package com.projedata.inventory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductionService {

    private final ProductMaterialRepository productMaterialRepository;
    private final RawMaterialRepository rawMaterialRepository;

    public ProductionService(ProductMaterialRepository productMaterialRepository,
                             RawMaterialRepository rawMaterialRepository) {
        this.productMaterialRepository = productMaterialRepository;
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @Transactional
    public void produce(Long productId, Integer quantity) {

        List<ProductMaterial> materials =
                productMaterialRepository.findByProduct_Id(productId);

        if (materials.isEmpty()) {
            throw new ProductWithoutMaterialsException(productId);
        }

        for (ProductMaterial pm : materials) {
            RawMaterial rawMaterial = pm.getRawMaterial();

            double totalNeeded = pm.getQuantityNeeded() * quantity;

            if (rawMaterial.getStockQuantity() < totalNeeded) {
                throw new InsufficientStockException(rawMaterial.getName());
            }

            rawMaterial.setStockQuantity(
                    rawMaterial.getStockQuantity() - totalNeeded
            );

            rawMaterialRepository.save(rawMaterial);
        }
    }
}
