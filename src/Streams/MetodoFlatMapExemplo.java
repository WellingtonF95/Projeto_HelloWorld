package Streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class MetodoFlatMapExemplo {

    public static void main(String[] args) {

        /*Metodo flatMap - Realiza um achatamento para obter um stream do objeto*/

        CadastroProduto cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        // Sem o uso do flatMap
        /*Stream<Set<Categoria>> setStream = produtos.stream()
                .filter(Produto::temEstoque)
                .map(Produto::getCategorias);

        setStream.forEach(set -> {
            set.forEach(System.out::println);
        });*/

        // Com o uso do flatMap
        produtos.stream()
                .filter(Produto::temEstoque)
                .flatMap(produto -> produto.getCategorias().stream()) // Recebe um stream de categorias
                .distinct()
                .forEach(System.out::println);


    }

}
