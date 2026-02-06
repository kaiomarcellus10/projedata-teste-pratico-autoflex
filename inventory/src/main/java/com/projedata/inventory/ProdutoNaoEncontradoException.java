package com.projedata.inventory;

public class ProdutoNaoEncontradoException extends RuntimeException {

    public ProdutoNaoEncontradoException(Long id) {
        super("Produto não encontrado. ID: " + id);
    }
}
