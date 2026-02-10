package Streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class StreamReduceExemplo {

    public static void main(String[] args) {

        /*Stream reduce - Reduz os items de um stream para um unico resultado final a partir de um stream
         * Dica para lembrar: está associado a operação mateméticas. Exemplo: somar a quantidade total de estoque
         *
         * Reduce é uma operação terminal
         * */

        CadastroProduto cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        /*
         * Obtendo a quantidade total de produtos no estoque - passo a passo
         * Parametros:
         * identity - valor inicial que iniciará a operação
         * op (acumulador) - operação associativa que irá somar o valor inicial com o valor do stream e com o resultado somando com os outros
         * numeros do stream
         * */

        IntBinaryOperator soma = (int subtotal, int valorDoProximoElemento) -> {
            System.out.printf("%d + %d\n", subtotal, valorDoProximoElemento);
            return subtotal + valorDoProximoElemento;
        };

        int quantidadeTotal = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .reduce(0, soma);// passo a passo
        //.reduce(0, (int first, int second) -> first + second); // com expressão lambda
        //.reduce(0, Integer::sum); // com method reference

        System.out.println("Quantidade Total: " + quantidadeTotal);

        // Reduce com BigDecimal
        // Forma manual

        BinaryOperator<BigDecimal> somar = (BigDecimal subTotal, BigDecimal valorDoProximoElemento) -> subTotal.add(valorDoProximoElemento);

        BigDecimal reduce = produtos.stream()
                .map(produto -> produto.getPreco().multiply(new BigDecimal(produto.getQuantidade()))
                )
                .reduce(BigDecimal.ZERO, somar);

        // Com method reference

        BigDecimal precoTotalEstoque = produtos.stream()
                .map(produto -> produto.getPreco().multiply(
                        new BigDecimal(produto.getQuantidade()))
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Usando o reduce com uma função de combinação para combinar resultados parciais de uma redução [sem usar o map]
        // args: (valor inicial, função acumuladora, função de combinação)
        BigDecimal totalPrecoEstoque = produtos.stream()
                .reduce(
                        BigDecimal.ZERO,
                        (subTotalDoEstoque, proximoProduto) -> {
                            BigDecimal precoTotalDoEstoque = proximoProduto.getPreco().multiply(new BigDecimal(proximoProduto.getQuantidade()));
                            return subTotalDoEstoque.add(precoTotalDoEstoque);
                        },
                        BigDecimal::add
                );

        System.out.println(precoTotalEstoque);
        System.out.println(totalPrecoEstoque);

        IntBinaryOperator valorMaximoEstoque = (valorAgregado, proximoProdutoComQuantidade) -> Integer.max(valorAgregado, proximoProdutoComQuantidade);

        int produtoComQuantidadeMaiorNoEstoque = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .reduce(0, valorMaximoEstoque);

        System.out.println(produtoComQuantidadeMaiorNoEstoque);

        // Em cenários onde não existe produtos com quantidade no estoque mas ao invés de retornar o valor 0, existe uma
        // sobrecarga do metodo reduce que recebe só a função agregadora, retornando um optional. Pode ter algum produto ou não

        List<Produto> semProdutos = new ArrayList<>();

        OptionalInt produtoComQuantidadeMaiorNoEstoqueOptional = semProdutos.stream()
                .mapToInt(Produto::getQuantidade)
                .reduce(valorMaximoEstoque);

        System.out.println(produtoComQuantidadeMaiorNoEstoqueOptional.orElseThrow(() -> new RuntimeException("Produto não encontrado")));

    }

}
