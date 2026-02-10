package Streams;

import java.util.List;

public class MetodoPeekExemplo {

    public static void main(String[] args) {

        /*
         *  Metodo peek - Operação intermediaria. Serve para mudar o estado do objeto durante a execução da pipeline e
         *  util para debbugar as operações intermediarias durante a execução do stream
         * */

        CadastroProduto cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        produtos.stream()
                .peek(produto -> produto.setNome(produto.getNome().toUpperCase())) // altera o nome do produto para maiusculo
                .peek(produto -> System.out.println("Antes do filtro: " + produto.getNome()))
                .filter(produto -> produto.temEstoque() && produto.isInativo())
                .peek(produto -> System.out.println("Depois do filtro: " + produto.getNome()))
                .forEach(produto -> {
                    produto.ativar();
                    System.out.println(produto);
                });

    }

}
