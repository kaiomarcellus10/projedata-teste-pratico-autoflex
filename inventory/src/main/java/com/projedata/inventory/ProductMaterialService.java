package com.projedata.inventory;

import org.springframework.stereotype.Service;

@Service
public class ProductMaterialService {

    private final ProductMaterialRepository productMaterialRepository;
    private final ProdutoRepository produtoRepository;
    private final RawMaterialRepository rawMaterialRepository;

    public ProductMaterialService(ProductMaterialRepository productMaterialRepository,
                                  ProdutoRepository produtoRepository,
                                  RawMaterialRepository rawMaterialRepository) {
        this.productMaterialRepository = productMaterialRepository;
        this.produtoRepository = produtoRepository;
        this.rawMaterialRepository = rawMaterialRepository;
    }

    public ProductMaterial salvar(Long productId, Long rawMaterialId, Double quantityNeeded) {

        Produto produto = produtoRepository.findById(productId)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(productId));

        RawMaterial rawMaterial = rawMaterialRepository.findById(rawMaterialId)
                .orElseThrow(() -> new RuntimeException("Raw material not found"));

        // 🔒 VERIFICA DUPLICIDADE (PONTO DO BUG)
        productMaterialRepository
                .findByProduct_IdAndRawMaterial_Id(productId, rawMaterialId)
                .ifPresent(pm -> {
                    throw new RuntimeException("Material already linked to this product");
                });

        ProductMaterial productMaterial = new ProductMaterial();
        productMaterial.setProduct(produto);
        productMaterial.setRawMaterial(rawMaterial);
        productMaterial.setQuantityNeeded(quantityNeeded);

        return productMaterialRepository.save(productMaterial);
    }
}
