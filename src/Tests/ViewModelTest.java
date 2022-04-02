package Tests;

import br.edu.infnet.Produtos.Produto;
import br.edu.infnet.System.DB;
import br.edu.infnet.System.ViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewModelTest {

    DB db = DB.getInstance();

    @Test
    void insertProduto() {

        Produto produto = new Produto("arroz", "camil", true, "alimento");
        ViewModel.insertProduto(produto);

        Produto produto2 = new Produto("arrozz", "camil", true, "alimento");
        ViewModel.insertProduto(produto2);

        assertEquals(2, db.getProdutosListSize());
    }
}