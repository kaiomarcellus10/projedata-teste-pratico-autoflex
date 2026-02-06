package com.projedata.inventory;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // CRIAR
    @PostMapping
    public ResponseEntity<Produto> salvar(@Valid @RequestBody ProdutoRequestDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
