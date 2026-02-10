package Streams;

import java.util.List;
import java.util.Optional;

public class MetodosFindFirstAnyExemplo {

    public static void main(String[] args) {


        /*Operações terminais de curto circuito - findFirst e findAny
         *
         * São operações que otimizam a execução da pipeline caso a condição for satisfeita
         * findFirst - Encontra o PRIMEIRO produto dado as condições declaradas, podendo ter um produto ou não. Retorna um Optional
         * findAny - Encontra QUALQUER produto dado as condições declaradas, não garantindo em que ordem o produto esteja e pode
         * conter um produto ou não. Retorna um Optional
         * */

        CadastroProduto cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        Optional<Produto> temProduto = produtos.stream()
                .peek(System.out::println)
                .filter(produto -> !produto.temEstoque())
                .filter(Produto::isInativo)
                //.findAny();
                .findFirst();

        System.out.println("Fim execução");

        Produto produto = temProduto.orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        System.out.println(produto);

    }

}
