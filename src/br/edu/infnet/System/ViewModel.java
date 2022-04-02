package br.edu.infnet.System;

import br.edu.infnet.CommonUse.Tools;
import br.edu.infnet.Produtos.Cotacao;
import br.edu.infnet.Produtos.Produto;

import java.util.ArrayList;

public class ViewModel {

    private static final DB db = DB.getInstance();

    public static void insertProduto(Produto produto) {
        ArrayList<Produto> produtosList = db.getProdutosList();

        if (produtosList.contains(produto)){
            for (Produto p : produtosList) {
                if (p.equals(produto)) {
                    int productId = p.getProductId();
                    Tools.print(String.format("O produto ja esta cadastrado com o id %s.\n\n", productId));
                }
            }
        }
        else{
            db.insertProduto(produto);
        }

    }

    public static void insertCotacao(Cotacao cotacao) {
        ArrayList<Cotacao> cotacoesList = db.getCotacoesList();

        if (cotacoesList.contains(cotacao)){
            for (Cotacao c : cotacoesList) {
                if (c.equals(cotacao)) {
                    int cotacaoId = c.getProductId();
                    Tools.print(String.format("A cotacao ja esta cadastrada com o id %s", cotacaoId));
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
