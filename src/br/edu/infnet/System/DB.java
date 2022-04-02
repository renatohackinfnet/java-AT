package br.edu.infnet.System;

import br.edu.infnet.Produtos.Cotacao;
import br.edu.infnet.Produtos.Produto;

import java.util.ArrayList;

public class DB {

    private final ArrayList<Cotacao> cotacoes = new ArrayList<>();
    private final ArrayList<Produto> produtos = new ArrayList<>();

    private static DB db;


    // CREATE
    public void insertCotacao(Cotacao cotacao){
        this.cotacoes.add(cotacao);
    }

    public void insertProduto(Produto produto){
        this.produtos.add(produto);
    }


    // DELETE
    public void deleteCotacao(int cotacaoId){
        Cotacao cotacao = findCotacaoById(cotacaoId);

        if (cotacao != null){
            this.cotacoes.remove(cotacao);
        }

    }
    public void deleteCotacao(Cotacao cotacao){
        this.cotacoes.remove(cotacao);
    }

    public void deleteProduto(int productId){
        Produto produto = findProdutoById(productId);

        if (produto != null){
            this.produtos.remove(produto);
        }

        for (Cotacao c : findCotacoesByProductId(productId)){
            this.cotacoes.remove(c);
        }


    }
    public void deleteProduto(Produto produto){
        int productId = produto.getProductId();

        this.produtos.remove(produto);

        for (Cotacao c : findCotacoesByProductId(productId)){
            this.cotacoes.remove(c);
        }


    }


    // READ
    public Cotacao findCotacaoById(int id){
        Cotacao cotacao = null;

        for (Cotacao c : this.cotacoes) {
            if (c.getCotacaoId() == id) {
                cotacao = c;
                break;
            }
        }
        return cotacao;
    }

    public Produto findProdutoById(int id){
        Produto produto = null;

        for (Produto p : this.produtos) {
            if (p.getProductId() == id) {
                produto = p;
                break;
            }
        }
        return produto;
    }

    public ArrayList<Cotacao> findCotacoesByProductId(int productId){

        ArrayList<Cotacao> cotacaoList = new ArrayList<>();

        for (Cotacao c : this.cotacoes) {
            if (c.getProductId() == productId) {
                cotacaoList.add(c);
            }
        }
        return cotacaoList;
    }


    //UPDATE
    public void updateProduto(int produtoId, boolean isPerecivel, String tipoProduto){
        Produto produto = this.findProdutoById(produtoId);

        if (produto != null){
            produto.setPerecivel(isPerecivel);
            produto.setTipoProduto(tipoProduto);
        }
    }


    //GET INFO
    public int getCotacoesListSize(){
        return this.cotacoes.size();
    }

    public int getProdutosListSize(){
        return this.produtos.size();
    }


    // INSTANCES

    public static DB newInstance(){
        return new DB();
    }

    public static DB getInstance(){
        if (DB.db == null){
            DB.db = new DB();
            return new DB();
        }
        else return DB.db;
    }

}
