package com.projedata.inventory;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/production")
public class ProductionController {

    private final ProductionService productionService;

    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @PostMapping
    public String produce(@RequestBody ProductionRequest request) {
        productionService.produce(request.getProductId(), request.getQuantity());
        return "Production completed successfully";
    }
}
