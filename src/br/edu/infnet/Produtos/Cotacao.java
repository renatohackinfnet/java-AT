package br.edu.infnet.Produtos;

import br.edu.infnet.CommonUse.Exceptions.DataInvalidaException;
import br.edu.infnet.CommonUse.Exceptions.PrecoInvalidoException;
import br.edu.infnet.CommonUse.Tools;

public class Cotacao {

    private static int id = 1;

    private final int productId;
    private final float preco;
    private final String dataCotacao;
    private final String fornecedorCotacao;
    private final int cotacaoId;

    // CONSTRUTOR
    public Cotacao(int productId, String preco, String dataCotacao, String fornecedorCotacao) throws PrecoInvalidoException, DataInvalidaException {
        if (!Tools.isPrecoValid(preco)){
            throw new PrecoInvalidoException("O preco inserido eh invalido.");
        }
        else if(!Tools.isDateValid(dataCotacao)){
            throw new DataInvalidaException("A data inserida eh invalida.");
        }
        else {
            this.productId = productId;
            this.preco = Math.round(Float.parseFloat(preco) * 100f) / 100f;
            this.dataCotacao = dataCotacao;
            this.fornecedorCotacao = fornecedorCotacao;
            this.cotacaoId = Cotacao.id;

            Cotacao.id++;
        }
    }

    // GETTERS
    public int getProductId(){
        return this.productId;
    }

    public float getPreco(){
        return this.preco;
    }

    public String getDataCotacao(){
        return this.dataCotacao;
    }

    public String getFornecedorCotacao(){
        return this.fornecedorCotacao;
    }

    public int getCotacaoId() {
        return this.cotacaoId;
    }
}
