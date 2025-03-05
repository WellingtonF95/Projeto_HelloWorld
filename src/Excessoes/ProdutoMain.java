package Excessoes;

import java.util.Scanner;

public class ProdutoMain {

    public static void main(String[] args) {
        Produto processador = new Produto();
        processador.setNome("Intel I9");
        processador.setAtivo(true);

        processador.adicionarEstoque(10);

        comprar(processador);
    }

    private static void comprar(Produto produto) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Informe a quantidade do produto: ");
            int quantidade = scan.nextInt();

            efetuarBaixaEstoque(produto, quantidade);
            System.out.println("Compra realizada");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.printf("Não foi possivel concluir a compra: %s\n", e.getMessage());
        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.out.printf("Erro ao efetuar a compra: %s", e.getMessage());
        }
    }

    private static void efetuarBaixaEstoque(Produto produto, int quantidade) {
        produto.removerEstoque(quantidade);
        System.out.printf("%d unidades retiradas do estoque. Estoque atual: %d\n", quantidade, produto.getQuantidadeEstoque());
    }
}
