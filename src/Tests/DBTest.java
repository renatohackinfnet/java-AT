package Tests;

import br.edu.infnet.CommonUse.Exceptions.DataInvalidaException;
import br.edu.infnet.CommonUse.Exceptions.PrecoInvalidoException;
import br.edu.infnet.Produtos.Cotacao;
import br.edu.infnet.Produtos.Produto;
import br.edu.infnet.System.DB;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class DBTest {

    @org.junit.jupiter.api.Test
    void insertCotacao() throws PrecoInvalidoException, DataInvalidaException, ParseException {
        DB db = DB.newInstance();
        Cotacao cotacao = new Cotacao(1,1, "22.22", "23/12/2023", "Parmalat");
        db.insertCotacao(cotacao);
        assertEquals(1, db.getCotacoesListSize());
    }

    @org.junit.jupiter.api.Test
    void insertProduto() {
        DB db = DB.newInstance();
        Produto produto = new Produto(1, "arroz", "camil", true, "alimento");
        db.insertProduto(produto);
        assertEquals(1, db.getProdutosListSize());
    }

    @org.junit.jupiter.api.Test
    void deleteCotacao() throws PrecoInvalidoException, DataInvalidaException, ParseException {
        DB db = DB.newInstance();
        Cotacao cotacao = new Cotacao(1, 1, "22.22", "23/12/2023", "Parmalat");
        db.insertCotacao(cotacao);

        Cotacao cotacao2 = new Cotacao(2,1, "23.22", "23/12/2023", "Parmalat");
        db.insertCotacao(cotacao);
        db.deleteCotacao(cotacao.getCotacaoId());
        assertEquals(1, db.getCotacoesListSize());
    }

    @org.junit.jupiter.api.Test
    void deleteProduto() throws PrecoInvalidoException, DataInvalidaException, ParseException {
        DB db = DB.newInstance();

        //INSERT PRODUTO
        Produto produto = new Produto(1, "arroz", "camil", true, "alimento");
        db.insertProduto(produto);

        //INSERT COTACOES
        Cotacao cotacao1 = new Cotacao(1, 1, "22.22", "23/12/2023", "Parmalat");
        db.insertCotacao(cotacao1);

        Cotacao cotacao2 = new Cotacao(2, 2, "22.22", "23/12/2023", "Parmalat");
        db.insertCotacao(cotacao2);

        db.deleteProduto(produto);
        assertEquals(1, db.getCotacoesListSize());

    }

    @org.junit.jupiter.api.Test
    void findCotacaoById() throws PrecoInvalidoException, DataInvalidaException, ParseException {
        DB db = DB.newInstance();

        Cotacao cotacao = new Cotacao(1, 1, "22.22", "23/12/2023", "Parmalat");
        db.insertCotacao(cotacao);

        Cotacao cotacao2 = new Cotacao(2, 1, "22.22", "23/12/2023", "Parmalat");
        assertEquals(cotacao, db.findCotacaoById(cotacao.getCotacaoId()));
    }

    @org.junit.jupiter.api.Test
    void findProdutoById() {
        DB db = DB.newInstance();
        //PRODUTO 1
        Produto produto1 = new Produto(1, "arroz", "camil", true, "alimento");
        db.insertProduto(produto1);

        //PRODUTO 2
        Produto produto2 = new Produto(2, "arroz", "camil", true, "alimento");
        db.insertProduto(produto2);

        assertEquals(produto1, db.findProdutoById(produto1.getProductId()));
    }

    @org.junit.jupiter.api.Test
    void findCotacoesByProductId() {

    }
}