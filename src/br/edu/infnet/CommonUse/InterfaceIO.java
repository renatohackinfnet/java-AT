package br.edu.infnet.CommonUse;

import br.edu.infnet.CommonUse.Exceptions.*;
import br.edu.infnet.Produtos.*;
import br.edu.infnet.System.ViewModel;

import java.util.Locale;

import static java.lang.System.out;

public class InterfaceIO {

    public static void printInitialMessage() {
        out.println("""
                +---------------------------------------------+
                [1] Cadastrar produto.
                [2] Cadastrar cotacao.
                [3] Consultar situação de um docente/discente.
                [0] Sair.
                +---------------------------------------------+""");

        out.print("Entre com a opcao desejada: ");
    }

    public static int getOption() {

        boolean notOptionSuccess = true;
        int option = 0;

        while (notOptionSuccess) {
            try {
                option = Tools.getIntegerInput();
                if (Tools.checkIfInRange(0, 3, option)) {
                    notOptionSuccess = false;
                }
                else {
                    out.print("Voce deve inserir um numero contido nas opcoes: ");
                }
            } catch (NumberFormatException | NotInteger | EmptyStringException e) {
                out.print("Voce deve inserir um numero contido nas opcoes: ");
            }
        }
        return option;
    }

    public static void cadastrarProduto() {

        // NOME
        String nome = "";
        while (nome.equals("")) {
            try {
                Tools.print("Insira o nome do produto: ");
                nome = Tools.getStringInput();
            } catch (EmptyStringException ignored) {

            }
        }

        // FORNECEDOR

        String fornecedor = "";
        while (fornecedor.equals("")) {
            try {
                Tools.print("Insira o fornecedor do produto: ");
                fornecedor = Tools.getStringInput();
            } catch (EmptyStringException ignored) {

            }
        }

        // PERECIVEL

        String perecivel = "";
        boolean isPerecivel;
        while (!perecivel.equals("y") && !perecivel.equals("n")) {
            try {
                Tools.print("O produto eh perecivel? [y/n]: ");
                perecivel = Tools.getStringInput().toLowerCase();
            } catch (EmptyStringException ignored) {

            }
        }
        isPerecivel = perecivel.equals("y");

        // TIPO PRODUTO
        String tipoProduto = "";
        while (tipoProduto.equals("")) {
            try {
                Tools.print("Insira o tipo do produto (alimento, limpeza, etc.): ");
                tipoProduto = Tools.getStringInput();
            } catch (EmptyStringException ignored) {

            }
        }

        ViewModel.insertProduto(nome, fornecedor, isPerecivel, tipoProduto);

    }

    public static void cadastrarCotacao() {

        // PRODUCT ID
        int productId = -1;
        while (productId == -1) {
            try {
                Tools.print("Insira o id do produto que voce deseja fazer a cotacao: ");
                productId = Tools.getIntegerInput();
            } catch (NotInteger | EmptyStringException ignored) {

            }
        }

        if (!ViewModel.productExists(productId)){
            Tools.println("O id do produto nao existe. Cadastre um produto com esse id antes de tentar cadastrar uma cotacao para ele.");
            return;
        }

        // PRECO
        float precoFloat = 0f;
        while (precoFloat == 0) {
            try {
                Tools.print("Insira o preco do produto (deve ser maior que zero): ");
                String preco = Tools.getStringInput();
                if (!Tools.isPrecoValid(preco)){
                    throw new PrecoInvalidoException();
                }
                precoFloat = Math.round(Float.parseFloat(preco) * 100f) / 100f;
            } catch (EmptyStringException | PrecoInvalidoException ignored) {

            }
        }

        // FORNECEDOR
        String fornecedor = "";
        while (fornecedor.equals("")) {
            try {
                Tools.print("Insira o fornecedor da cotacao: ");
                fornecedor = Tools.getStringInput();
            } catch (EmptyStringException ignored) {

            }
        }

        // DATA COTACAO
        String dataCotacao = "";
        while (dataCotacao.equals("")) {
            try {
                Tools.print("Insira a data da cotacao (formato dd/MM/yyyy): ");
                String dataCotacaoTemp = Tools.getStringInput();
                if(!Tools.isDateValid(dataCotacaoTemp)){
                    throw new DataInvalidaException();
                }
                dataCotacao = dataCotacaoTemp;
            } catch (EmptyStringException | DataInvalidaException ignored) {

            }
        }

        ViewModel.insertCotacao(productId, String.valueOf(precoFloat), dataCotacao, fornecedor);
    }
}
