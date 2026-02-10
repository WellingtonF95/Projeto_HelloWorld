package Streams;

import java.util.List;

public class MetodoAnyAllNoneMatchExemplo {

    public static void main(String[] args) {

        /*Operações terminais de curto circuito - anyMatch, allMatch e noneMatch
        *
        * anyMatch - Verifica se existe algum produto sem estoque - Retorna um booleano
        * allMatch - Verifica se todos os produtos não tem estoque - Retorna um booleano
        * noneMatch - Verifica se nenhum produto não tem estoque - Retorna um booleano
        *
        * */

        CadastroProduto cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        boolean produtoComEstoque = produtos.stream()
                .peek(System.out::println)
                .anyMatch(Produto::temEstoque);
        System.out.println("Tem produtos no estoque? " + produtoComEstoque);

        boolean todosProdutosTemEstoque = produtos.stream()
                .peek(System.out::println)
                .allMatch(Produto::temEstoque);
        System.out.println("Todos os produtos tem estoque? " + todosProdutosTemEstoque);

        boolean nenhumProdutoTemEstoque = produtos.stream()
                .peek(System.out::println)
                .noneMatch(Produto::temEstoque);
        System.out.println("Nenhum produto tem estoque disponível? " + nenhumProdutoTemEstoque);




    }

}
