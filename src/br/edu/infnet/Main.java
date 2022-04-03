package br.edu.infnet;

import br.edu.infnet.CommonUse.Exceptions.EmptyStringException;
import br.edu.infnet.CommonUse.Exceptions.NotInteger;
import br.edu.infnet.CommonUse.InterfaceIO;
import br.edu.infnet.CommonUse.Tools;
import br.edu.infnet.System.DB;
import br.edu.infnet.System.ViewModel;

public class Main {

    public static void main(String[] args) {

        int opcao = -1;

        while (opcao != 0){
            InterfaceIO.printInitialMessage();
            opcao = InterfaceIO.getOption();
            switch (opcao) {
                case 1 -> InterfaceIO.cadastrarProduto();
                case 2 -> InterfaceIO.cadastrarCotacao();
                case 3 -> InterfaceIO.listarCotacoesPorProduto();
            }
        }




    }
}
//