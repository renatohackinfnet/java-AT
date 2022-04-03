package br.edu.infnet.Produtos;

import br.edu.infnet.CommonUse.Tools;

import java.util.Objects;

public class Produto {

    private final String nome;
    private boolean isPerecivel;
    private final String fornecedorProduto;
    private String tipoProduto;
    private final int productId;

    // CONSTRUTOR
    public Produto(int productId, String nome, String fornecedorProduto, boolean isPerecivel, String tipoProduto) {
        this.nome = nome;
        this.fornecedorProduto = fornecedorProduto;
        this.isPerecivel = isPerecivel;
        this.tipoProduto = tipoProduto;
        this.productId = productId;
    }

    public Produto(int productId, String nome, String fornecedorProduto, boolean isPerecivel) {
        this.nome = nome;
        this.fornecedorProduto = fornecedorProduto;
        this.isPerecivel = isPerecivel;
        this.productId = productId;
    }



    // GETTERS

    public int getProductId() {
        return this.productId;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean isPerecivel() {
        return this.isPerecivel;
    }

    public String getTipoProduto() {
        return this.tipoProduto;
    }

    public String getFornecedorProduto() {
        return this.fornecedorProduto;
    }


    // SETTERS
    public void setPerecivel(boolean isPerecivel) {
        this.isPerecivel = isPerecivel;
    }

    public void setTipoProduto(String tipoProduto){
        this.tipoProduto = tipoProduto;
    }


    // OVERRIDE

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Produto produto = (Produto) o;
        return isPerecivel == produto.isPerecivel && nome.equals(produto.nome) && fornecedorProduto.equals(produto.fornecedorProduto) && tipoProduto.equals(produto.tipoProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, isPerecivel, fornecedorProduto, tipoProduto);
    }
}
