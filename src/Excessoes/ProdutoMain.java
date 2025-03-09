package Excessoes;

import java.util.Scanner;

import Excessoes.exceptions.BaixaEstoqueException;
import Excessoes.exceptions.ProdutoException;
import Excessoes.exceptions.ProdutoInativoException;
import Excessoes.exceptions.ProdutoSemEstoqueException;

public class ProdutoMain {

    public static void main(String[] args) {
        Produto processador = new Produto();
        processador.setNome("Intel I9");
        processador.ativar();

        processador.adicionarEstoque(10);

        //comprar(processador);
        efetuarCompra(processador);
    }

    /*Ordem de precedencia de excess�es: Sempre da mais especifica para a menos especifica*/
    private static void comprar(Produto produto) {
        Scanner scan = new Scanner(System.in);
        do {
            try {
                System.out.println("Informe a quantidade do produto: ");
                int quantidade = scan.nextInt();

                efetuarBaixaEstoque(produto, quantidade);
                System.out.println("Compra realizada");
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.printf("N�o foi possivel concluir a compra: %s\n", e.getMessage());
            } catch (ProdutoInativoException e) {
                System.out.printf("N�o foi possivel concluir a compra: %s\n", e.getMessage());
                System.out.println("Deseja ativar o produto?");

                if (scan.nextBoolean()) {
                    produto.ativar();
                    System.out.println("Produto ativado");
                } else {
                    System.out.println("OK, programa ser� finalizado");
                    break;
                }
            } catch (ProdutoException e) {
                System.out.printf("N�o foi possivel concluir a compra: %s\n", e.getMessage());
                System.out.println(e.getClass().getName());
                break;
            }
        } while (true);
    }

    private static void efetuarBaixaEstoque(Produto produto, int quantidade) throws ProdutoSemEstoqueException, ProdutoInativoException {
        produto.removerEstoque(quantidade);
        System.out.printf("%d unidades retiradas do estoque. Estoque atual: %d\n", quantidade, produto.getQuantidadeEstoque());
    }

    private static void efetuarCompra(Produto produto) {
        Scanner scan = new Scanner(System.in);
        do {
            try {
                System.out.println("Informe a quantidade do produto: ");
                int quantidade = scan.nextInt();

                efetuarBaixaNoEstoque(produto, quantidade);
                System.out.println("Compra realizada");
                break;
            } catch (BaixaEstoqueException e) {
                e.printStackTrace();
                System.out.printf("N�o foi possivel efetuar a compra: %s\n", e.getCause().getMessage());
                break;
            }
        } while (true);
    }

    /* Boa pr�tica ao lan�ar e propagar uma nova excess�o:
    * - Sempre embrulhar a causa raiz da excess�o original que ocorreu
    * */
    private static void efetuarBaixaNoEstoque(Produto produto, int quantidade) throws BaixaEstoqueException {
        try {
            produto.removerEstoque(quantidade);
            System.out.printf("%d unidades retiradas do estoque. Estoque atual: %d\n", quantidade, produto.getQuantidadeEstoque());
        } catch (IllegalArgumentException | ProdutoException e) {
            throw new BaixaEstoqueException("Erro ao realizar baixa no estoque", e);
        }
    }
}
