package br.edu.infnet.Produtos;

import br.edu.infnet.CommonUse.Exceptions.DataInvalidaException;
import br.edu.infnet.CommonUse.Exceptions.PrecoInvalidoException;
import br.edu.infnet.CommonUse.Tools;

import java.util.Objects;

public class Cotacao {

    private final int productId;
    private float preco;
    private final String dataCotacao;
    private final String fornecedorCotacao;
    private final int cotacaoId;

    // CONSTRUTOR
    public Cotacao(int cotacaoId, int productId, String preco, String dataCotacao, String fornecedorCotacao) throws PrecoInvalidoException, DataInvalidaException {
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
            this.cotacaoId = cotacaoId;
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

    // SETTERS
    public void setPreco(float preco){
        if (preco > 0){
            this.preco = preco;
        }
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
        Cotacao cotacao = (Cotacao) o;
        return productId == cotacao.productId && dataCotacao.equals(cotacao.dataCotacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, preco, dataCotacao, fornecedorCotacao);
    }

    @Override
    public String toString() {
        return String.format(
                """
                        Cotacao Id: %s\s
                         Product Id: %s\s
                         Preco: R$ %.2f1\s
                         Fornecedor: %s\s
                         Data da Cotacao: %s\s

                        """,
                getCotacaoId(), getProductId(), getPreco(), getFornecedorCotacao(), getDataCotacao()
        );
    }
}
