package br.edu.infnet.System;

import br.edu.infnet.CommonUse.Exceptions.DataInvalidaException;
import br.edu.infnet.CommonUse.Exceptions.PrecoInvalidoException;
import br.edu.infnet.CommonUse.Tools;
import br.edu.infnet.Produtos.Cotacao;
import br.edu.infnet.Produtos.Produto;

import java.util.ArrayList;

public class ViewModel {

    private static final DB db = DB.getInstance();

    public static void insertProduto(String nome, String fornecedor, boolean isPerecivel, String tipoProduto) {

        int productId = db.getProductId();
        Produto produto = new Produto(productId, nome, fornecedor, isPerecivel, tipoProduto);

        ArrayList<Produto> produtosList = db.getProdutosList();

        if (produtosList.contains(produto)){
            for (Produto p : produtosList) {
                if (p.equals(produto)) {
                    int productIdTemp = p.getProductId();
                    Tools.print(String.format("O produto ja esta cadastrado com o id %s.\n\n\n", productIdTemp));
                }
            }
        }
        else{
            db.insertProduto(produto);
        }

    }

    public static void insertCotacao(int productId, String preco, String dataCotacao, String fornecedorCotacao) {

        Cotacao cotacao;
        try {
            int cotacaoId = db.getCotacaoId();
            cotacao = new Cotacao(cotacaoId, productId, preco, dataCotacao, fornecedorCotacao);
        } catch (PrecoInvalidoException e) {
            Tools.println("O preco eh invalido. Operacao abortada.");
            return;
        } catch (DataInvalidaException e) {
            Tools.println("A data eh invalida. Operacao abortada.");
            return;
        }

        ArrayList<Cotacao> cotacoesList = db.getCotacoesList();

        if (cotacoesList.contains(cotacao)){
            for (Cotacao c : cotacoesList) {
                if (c.equals(cotacao)) {
                    int cotacaoIdTemp = c.getCotacaoId();
                    Tools.print(String.format("A cotacao ja esta cadastrada com o id %s. \n\n\n", cotacaoIdTemp));
                }
            }
        }
        else{
            db.insertCotacao(cotacao);
        }

    }

    public static boolean productExists(int id){
        Produto produto = db.findProdutoById(id);

        return (produto != null);
    }

}
