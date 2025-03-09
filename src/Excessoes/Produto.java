package Excessoes;

import java.util.Objects;

import Excessoes.exceptions.ProdutoInativoException;
import Excessoes.exceptions.ProdutoSemEstoqueException;

public class Produto {

    private String nome;
    private int quantidadeEstoque;
    private boolean ativo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Objects.requireNonNull(nome, "O nome deve ser informado");
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public boolean isInativo() {
        return !isAtivo();
    }

    public void ativar() {
        this.ativo = true;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }

        this.quantidadeEstoque += quantidade;
    }

    /* Para checked exceptions, há duas possíbilidades de lidar com essas excessões:
    * - Tratar em um bloco try/catch;
    * - Propagar a excessão para o metodo anterior da pilha de chamadas (stackTrace)
    *
    * Boas praticas:
    * - Sempre lançar excessões o mais cedo possível;
    * - Sempre tratar excessões o mais tarde possível;
    * - Usar excessões especificas para tratar casos especificos e facilitar o troubleshooting
    *
    * */

    public void removerEstoque(int quantidade) throws ProdutoSemEstoqueException, ProdutoInativoException {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }

        if (this.quantidadeEstoque - quantidade < 0) {
            throw new ProdutoSemEstoqueException("Estoque insuficiente", getQuantidadeEstoque(), quantidade);
        }

        if (isInativo()) {
            throw new ProdutoInativoException("O produto está inativo");
        }

        this.quantidadeEstoque -= quantidade;
    }


}
