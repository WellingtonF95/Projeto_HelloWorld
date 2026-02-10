package Streams;

import java.util.Comparator;
import java.util.List;

public class SortedExemplo {

    public static void main(String[] args) {

        /*Ordenação com sorted
        *
        * sorted sem argumento - Ordena pela ordem natural. Necessário implementar a interface Comparable
        * sorted recebendo um comparator - Ordena por um criterio especifico. Alternativas:
        * - Criar uma classe que implementa a interface Comparator e implementar a logica de comparação
        * - Usar a interface Comparator de forma estática e usando os default methods com lambdas e method reference
        *
        * O sorted é um metodo que tem estado e combinando com metodos de curto circuito, a ordenação é realizada normalmente
        * mas a IDE entende que é desnecessária
        *
        * */


        CadastroProduto cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        produtos.stream()
                .filter(Produto::temEstoque)
                .sorted(Comparator.comparingInt(Produto::getQuantidade))
                .forEach(produto -> System.out.printf("%s = %d unidades\n", produto.getNome(), produto.getQuantidade()));

        /*boolean temEstoque = produtos.stream()
                .peek(System.out::println)
                .filter(Produto::temEstoque)
                .sorted(Comparator.comparingInt(Produto::getQuantidade))
                .anyMatch(Produto::temEstoque);
        System.out.println(temEstoque);*/


    }

}
