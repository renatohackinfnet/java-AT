package br.edu.infnet.Produtos;

import br.edu.infnet.CommonUse.Tools;

public class Produto {

    private static int id = 1;

    private final String nome;
    private boolean isPerecivel;
    private final String fornecedorProduto;
    private String tipoProduto;
    private final int productId;

    // CONSTRUTOR
    public Produto(String nome, String fornecedorProduto, boolean isPerecivel, String tipoProduto) {
        this.nome = nome;
        this.fornecedorProduto = fornecedorProduto;
        this.isPerecivel = isPerecivel;
        this.tipoProduto = tipoProduto;
        this.productId = Produto.id;

        Produto.id++;
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
}
