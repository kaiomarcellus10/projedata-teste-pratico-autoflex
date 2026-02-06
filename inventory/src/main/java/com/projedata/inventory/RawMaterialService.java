package com.projedata.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialService {

    @Autowired
    private RawMaterialRepository repository;

    public List<RawMaterial> listar() {
        return repository.findAll();
    }

    public RawMaterial buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Raw material not found. ID: " + id));
    }

    public RawMaterial salvar(RawMaterial rawMaterial) {
        return repository.save(rawMaterial);
    }

    public RawMaterial atualizar(Long id, RawMaterial rawMaterialAtualizado) {

        RawMaterial rawMaterial = buscarPorId(id);

        rawMaterial.setName(rawMaterialAtualizado.getName());
        rawMaterial.setStockQuantity(rawMaterialAtualizado.getStockQuantity());

        return repository.save(rawMaterial);
    }

    public void deletar(Long id) {
        RawMaterial rawMaterial = buscarPorId(id);
        repository.delete(rawMaterial);
    }
}
