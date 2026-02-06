package com.projedata.inventory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdutoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser maior que zero")
    private Double preco;

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
