package FuncionalInterfaces.classes;

@FunctionalInterface
public interface AcaoAnimal {

    /*Para ser uma interface funcional, deve ter apenas um metodo abstrato. Mais do que um metodo, o compilador não entende
    * qual metodo invocar ao usar expressão lambda.
    *
    * Pode haver métodos default e métodos estáticos, não compromentendo o uso da interface com expressão lambda
    *
    * Para garantir a integridade dessa interface, a boa prática é usar a anotação @FunctionalInterface para informar
    * que se trata de uma interface funcional e que não é possível adicionar outros métodos abstratos. O compilador já
    * aponta erro ao identificar outro metodo abstrato*/

    boolean verificaAcao(Animal animal);
    //boolean teste(Animal animal); Com a anotação, o compilador aponta erro

    /* Default Method
    *
    * São metodos que possuem corpo conforme exemplo abaixo. Introduzido no Java 8, os default methods servem para criar
    * um unico comportamento que serviriam para todas as classes que implementam essa interface. Mas não impede de uma outra
    * classe implementar o seu comportamento especifico.
    *
    * Eles surgem com o intuito de manter compatibilidade da interface com as classes que a implementam, sendo como um recurso
    * para ser usado como excessão para casos onde a interface é utilizada em muitas classes que ja fazem a implementação dos métodos
    *
    * */

    default boolean eh_animal_nadador(Animal animal) {
        return true;
    }

    static boolean eh_animal_voador(Animal animal) {
        return false;
    }

}
