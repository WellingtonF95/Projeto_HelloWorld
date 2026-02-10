package Streams;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StremPrimitivoExemplo {

    public static void main(String[] args) {

        /*Para trabalhar com streams usando tipos primitivos e evitar o boxing e o unboxing, existe a interface de stream
        * para tipos primitivos - Exemplo: IntStream. Elas trabalham com interfaces funcionais de tipos primitivos nas
        * configurações da pipeline
        * */

        CadastroProduto cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        // Stream de Integer
        Stream<Integer> integerStream = produtos.stream()
                .filter(Produto::temEstoque)
                .map(Produto::getQuantidade);

        integerStream.forEach((Integer qtd) -> System.out.println(qtd));

        IntStream intStream = produtos.stream()
                .filter(Produto::temEstoque)
                .mapToInt(Produto::getQuantidade);

        intStream.forEach((int qtd) -> System.out.println(qtd));
    }

}
