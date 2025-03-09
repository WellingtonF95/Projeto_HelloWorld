package Excessoes.exceptions;

/*Unchecked exception: classes de excessões que extendem de RunTimeException
e que não necessáriamente precisam ser tratadas em um bloco try/catch
* Checked exception: classes de excessões que extendem de qualquer outra classe que não seja RuntimeException
e que precisam ser tratadas em um bloco try/catch. Ex.: IOException, Exception etc
* Tambem é possivel realizar upcasting de excessões (Uma excessão especifica extender uma excessão mais generica)
*/
public class ProdutoException extends Exception {

    public ProdutoException(String message) {
        super(message);
    }
}
