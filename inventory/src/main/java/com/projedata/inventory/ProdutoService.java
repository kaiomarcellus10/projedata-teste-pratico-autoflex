package com.projedata.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

    public Produto salvar(ProdutoRequestDTO dto) {

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        return repository.save(produto);
    }

    public Produto atualizar(Long id, ProdutoRequestDTO dto) {

        Produto produto = buscarPorId(id);

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        return repository.save(produto);
    }

    public void deletar(Long id) {
        Produto produto = buscarPorId(id);
        repository.delete(produto);
    }
}
