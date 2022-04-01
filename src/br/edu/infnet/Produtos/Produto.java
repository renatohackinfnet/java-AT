package br.edu.infnet.Produtos;

public class Produto {

    private static int id = 1;

    private final String nome;
    private boolean isPerecivel;
    private int durabilidadeEmDiasProdutoFechado;
    private int durabilidadeEmDiasProdutoAberto;
    private final String fornecedorProduto;
    private final int productId;

    // CONSTRUTORES
    Produto(String nome, String fornecedorProduto)
    {
        this.nome = nome;
        this.fornecedorProduto = fornecedorProduto;
        this.productId = Produto.id;

        Produto.id++;
    }

    Produto(String nome,
            String fornecedorProduto,
            boolean isPerecivel,
            int durabilidadeEmDiasProdutoFechado,
            int durabilidadeEmDiasProdutoAberto)
    {
        this.nome = nome;
        this.fornecedorProduto = fornecedorProduto;
        this.isPerecivel = isPerecivel;
        this.durabilidadeEmDiasProdutoFechado = durabilidadeEmDiasProdutoFechado;
        this.durabilidadeEmDiasProdutoAberto = durabilidadeEmDiasProdutoAberto;
        this.productId = Produto.id;

        Produto.id++;
    }


    // GETTERS

    public int getProductId(){
        return this.productId;
    }

    public String getNome(){
        return this.nome;
    }

    public boolean isPerecivel(){
        return this.isPerecivel;
    }

    public int getDurabilidadeEmDiasProdutoFechado(){
        return this.durabilidadeEmDiasProdutoFechado;
    }

    public int getDurabilidadeEmDiasProdutoAberto(){
        return this.durabilidadeEmDiasProdutoAberto;
    }

    public String getFornecedorProduto(){
        return this.fornecedorProduto;
    }


    // SETTERS
    public void durabilidadeEmDiasProdutoFechado(int validade){
        if (validade > 0){
            this.durabilidadeEmDiasProdutoFechado = validade;
        }
    }

    public void durabilidadeEmDiasProdutoAberto(int validade){
        if (validade > 0){
            this.durabilidadeEmDiasProdutoAberto = validade;
        }
    }

    public void setPerecivel(boolean isPerecivel){
        this.isPerecivel = isPerecivel;
    }
}
