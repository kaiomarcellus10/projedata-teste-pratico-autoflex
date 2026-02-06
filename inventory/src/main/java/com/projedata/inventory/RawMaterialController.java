package com.projedata.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raw-materials")
public class RawMaterialController {

    @Autowired
    private RawMaterialService service;

    @GetMapping
    public ResponseEntity<List<RawMaterial>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RawMaterial> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RawMaterial> salvar(@RequestBody RawMaterial rawMaterial) {
        return ResponseEntity.ok(service.salvar(rawMaterial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RawMaterial> atualizar(@PathVariable Long id, @RequestBody RawMaterial rawMaterial) {
        return ResponseEntity.ok(service.atualizar(id, rawMaterial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
