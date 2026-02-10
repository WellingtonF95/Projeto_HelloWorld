package Streams;

import java.util.List;

public class StreamEncadeadoExemplo {

    public static void main(String[] args) {

        /*
         * 3 etapas do stream
         *
         * 1 - Fonte de dados - A fonte de dados que será trabalhada na pipeline = List<Produtos>;
         * 2 - Operações intermediarias - Quais as configurações necessárias para a execução da pipeline - filter()
         * 3 - Operações terminais (somente pode ser apenas uma operação) - A execução da pipeline dada as configurações realizadas
         * dentro da fonte de dados - forEach()
         *
         * */

        CadastroProduto cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

        // Chamadas encadeadas
        produtos.stream()
                .filter(produto -> produto.temEstoque() && produto.isInativo())
                .forEach(produto -> {
                    produto.ativar();
                    System.out.println(produto);
                });

    }

}
