package Streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamExemplo {

    public static void main(String[] args) {

        CadastroProduto cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        /* Stream - Fluxo
        * Stream é uma api que veio no java 8 para simplificar as operações com collections, fazendo o uso do paradigma funcional
        * através de interfaces funcionais e method reference
        *
        * Stream possui metodos que realizam operações intermediarias e operações terminais
        *
        * Funciona como uma pipeline: É definida (configurada) as operações intermediarias que serão executadas nas operações
        * terminais do stream
        * */

        // Operações intermediarias - São operações do tipo lazy (preguiçosa) que só serão completadas quando for chamadas
        // as operações finais
        // Metodo filter - Filtra os elementos dado uma condição - Recebe como argumento a interface funcional Predicate

        Stream<Produto> stream = produtos.stream();

        Stream<Produto> produtosComEstoque = stream.filter(produto -> produto.getQuantidade() > 0);
        Stream<Produto> produtosInativos = produtosComEstoque.filter(Produto::isInativo);

        // Operações terminais - São operações que irá finalizar o fluxo, pois irão executar todas as operações intermediarias
        // que foram definidas anteriormente

        produtosInativos.forEach(produto -> {
            produto.ativar();
            System.out.println(produto);
        });

    }
}
