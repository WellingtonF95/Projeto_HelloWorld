package Excessoes.exceptions;

/*Unchecked exception: classes de excess�es que extendem de RunTimeException
e que n�o necess�riamente precisam ser tratadas em um bloco try/catch
* Checked exception: classes de excess�es que extendem de qualquer outra classe que n�o seja RuntimeException
e que precisam ser tratadas em um bloco try/catch. Ex.: IOException, Exception etc
* Tambem � possivel realizar upcasting de excess�es (Uma excess�o especifica extender uma excess�o mais generica)
*/
public class ProdutoSemEstoqueException extends ProdutoException {

    private final int estoqueDisponivel;
    private final int quantidadeSolicitada;

    public ProdutoSemEstoqueException(String mensagem, int estoqueDisponivel, int quantidadeSolicitada) {
        super(mensagem);
        this.estoqueDisponivel = estoqueDisponivel;
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public int getEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    public int getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }
}
