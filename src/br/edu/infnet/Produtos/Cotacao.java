package br.edu.infnet.Produtos;

public class Cotacao {

    private static int id = 1;

    private final int productId;
    private final float preco;
    private final String dataCotacao;
    private final String fornecedorCotacao;
    private final int cotacaoId;

    // CONSTRUTOR
    Cotacao(int productId, float preco, String dataCotacao, String fornecedorCotacao){


        this.productId = productId;
        this.preco = preco;
        this.dataCotacao = dataCotacao;
        this.fornecedorCotacao = fornecedorCotacao;
        this.cotacaoId = Cotacao.id;

        Cotacao.id++;
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

    private boolean isDateValid(String data){

        String[] arrData = splitData(data);

        if (arrData.length == 3){
            return true;
        }
        return false;
    }

    private String[] splitData(String data){
        data = data.replace("-", "/").replace(" ", "/");
        return data.split("/");
    }

}
