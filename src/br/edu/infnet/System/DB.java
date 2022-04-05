package br.edu.infnet.System;

import br.edu.infnet.CommonUse.Tools;
import br.edu.infnet.Produtos.Cotacao;
import br.edu.infnet.Produtos.Produto;

import java.util.ArrayList;
import java.util.Objects;

public class DB {

    private final ArrayList<Cotacao> cotacoes = new ArrayList<>();
    private final ArrayList<Produto> produtos = new ArrayList<>();

    private static DB db;

    private int productId = 1;
    private int cotacaoId = 1;


    // CREATE
    public void insertCotacao(Cotacao cotacao){
        this.cotacoes.add(cotacao);
        Tools.println(String.format("A cotacao foi cadastrada com o id %s. \n\n\n", cotacao.getCotacaoId()));
        this.cotacaoId++;
    }

    public void insertProduto(Produto produto){
        this.produtos.add(produto);
        Tools.println(String.format("O produto foi cadastrado com o id %s. \n\n\n", produto.getProductId()));
        this.productId++;
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

        for (Cotacao c : listCotacoesByProductId(productId)){
            this.cotacoes.remove(c);
        }


    }
    public void deleteProduto(Produto produto){
        int productId = produto.getProductId();

        this.produtos.remove(produto);

        for (Cotacao c : listCotacoesByProductId(productId)){
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
    public Cotacao findCotacaoByProductIdAndDate(int productId, String date){
        Cotacao cotacao = null;

        for (Cotacao c : this.cotacoes) {
            if (c.getCotacaoId() == productId && Objects.equals(c.getDataCotacao(), date)) {
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
    public Produto findProdutoByCodigoBarras(String cod){
        Produto produto = null;

        for (Produto p : this.produtos) {
            if (Objects.equals(p.getCodigoBarras(), cod)) {
                produto = p;
                break;
            }
        }
        return produto;
    }

    public ArrayList<Cotacao> listCotacoesByProductId(int productId){

        ArrayList<Cotacao> cotacaoList = new ArrayList<>();

        for (Cotacao c : this.cotacoes) {
            if (c.getProductId() == productId) {
                cotacaoList.add(c);
            }
        }
        return cotacaoList;
    }

    public ArrayList<Produto> listProdutosByFornecedor(String fornecedor){
        ArrayList<Produto> produtoList = new ArrayList<>();

        for (Produto p : this.produtos) {
            if (Objects.equals(p.getFornecedorProduto(), fornecedor)) {
                produtoList.add(p);
            }
        }
        return produtoList;
    }

    public ArrayList<Cotacao> getCotacoesList(){
        return this.cotacoes;
    }

    public ArrayList<Produto> getProdutosList(){
        return this.produtos;
    }


    //UPDATE
    public void updateProduto(int produtoId, boolean isPerecivel, String tipoProduto){
        Produto produto = this.findProdutoById(produtoId);

        if (produto != null){
            produto.setPerecivel(isPerecivel);
            produto.setTipoProduto(tipoProduto);
        }
    }

    public void updateCotacao(int cotacaoId, float preco){
        Cotacao cotacao = this.findCotacaoById(cotacaoId);

        if (cotacao != null){
            cotacao.setPreco(preco);
        }
    }


    //GET INFO
    public int getCotacoesListSize(){
        return this.cotacoes.size();
    }

    public int getProdutosListSize(){
        return this.produtos.size();
    }

    public int getProductId(){
        return this.productId;
    }

    public int getCotacaoId(){
        return this.cotacaoId;
    }

    // INSTANCES

    public static DB newInstance(){
        return new DB();
    }

    public static DB getInstance(){
        if (DB.db == null){
            DB.db = new DB();
            return db;
        }
        else return DB.db;
    }

}
