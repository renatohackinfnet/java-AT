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

        ViewModel.insertProduto("arroz", "camil", true, "alimento");

        ViewModel.insertProduto("arrozz", "camil", true, "alimento");

        assertEquals(2, db.getProdutosListSize());
    }
}