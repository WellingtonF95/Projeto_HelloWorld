package FuncionalInterfaces.classes;

@FunctionalInterface
public interface AcaoAnimal {

    /*Para ser uma interface funcional, deve ter apenas um metodo abstrato. Mais do que um metodo, o compilador n�o entende
    * qual metodo invocar ao usar express�o lambda.
    *
    * Pode haver m�todos default e m�todos est�ticos, n�o compromentendo o uso da interface com express�o lambda
    *
    * Para garantir a integridade dessa interface, a boa pr�tica � usar a anota��o @FunctionalInterface para informar
    * que se trata de uma interface funcional e que n�o � poss�vel adicionar outros m�todos abstratos. O compilador j�
    * aponta erro ao identificar outro metodo abstrato*/

    boolean verificaAcao(Animal animal);
    //boolean teste(Animal animal); Com a anota��o, o compilador aponta erro

    /* Default Method
    *
    * S�o metodos que possuem corpo conforme exemplo abaixo. Introduzido no Java 8, os default methods servem para criar
    * um unico comportamento que serviriam para todas as classes que implementam essa interface. Mas n�o impede de uma outra
    * classe implementar o seu comportamento especifico.
    *
    * Eles surgem com o intuito de manter compatibilidade da interface com as classes que a implementam, sendo como um recurso
    * para ser usado como excess�o para casos onde a interface � utilizada em muitas classes que ja fazem a implementa��o dos m�todos
    *
    * */

    default boolean eh_animal_nadador(Animal animal) {
        return true;
    }

    static boolean eh_animal_voador(Animal animal) {
        return false;
    }

}
