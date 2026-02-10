package Streams;

import java.util.List;
import java.util.stream.Stream;

public class MetodoMapExemplo {

    public static void main(String[] args) {

        /*Metodo map - mapeamento
        *
        * Irá transformar o stream de produto para um stream de fabricante, recebendo uma function
        * */

        CadastroProduto cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        /*Stream<Fabricante> fabricanteStream = produtos.stream()
                .filter(Produto::temEstoque)
                .map(produto -> produto.getFabricante());
        fabricanteStream.forEach(System.out::println);*/

        produtos.stream()
                .filter(Produto::temEstoque)
                .map(Produto::getFabricante)
                .distinct() // Faz a distinção entre os fabricantes que estiverem repetidos - operação intermediaria que possui estado
                .forEach(System.out::println);


    }

}
