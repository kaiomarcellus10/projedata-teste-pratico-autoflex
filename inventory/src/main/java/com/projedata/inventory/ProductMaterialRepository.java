package com.projedata.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ProductMaterialRepository
        extends JpaRepository<ProductMaterial, Long> {

    List<ProductMaterial> findByProduct_Id(Long productId);

    List<ProductMaterial> findByRawMaterial_Id(Long rawMaterialId);

    Optional<ProductMaterial> findByProduct_IdAndRawMaterial_Id(
            Long productId,
            Long rawMaterialId
    );
}
