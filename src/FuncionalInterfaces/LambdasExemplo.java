package FuncionalInterfaces;

import java.util.ArrayList;
import java.util.List;

import FuncionalInterfaces.classes.AcaoAnimal;
import FuncionalInterfaces.classes.Animal;
import FuncionalInterfaces.classes.AnimalNadador;

public class LambdasExemplo {

    public static void main(String[] args) {

        // Express�es lambdas s�o fun��es anonimas que podem ser passadas como argumento e em retorno de metodos
        // Para uma empress�o lambda funcionar, e necessario que a interface tenha apenas um metodo, se houver mais de um
        // o compilador nao consegue distinguir qual metodo implementar, mostrando assim erro de compila��o

        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe espada", true, false, 10));
        animais.add(new Animal("tucano", false, true, 9));
        animais.add(new Animal("camar�o", true, false, 6));
        animais.add(new Animal("calopsita", false, true, 4));
        animais.add(new Animal("papagaio", false, true, 5));

        /*Sem o uso de lambdas - � preciso criar uma classe (VerificaAnimalNadador) que implementa a interface AcaoAnimal
        * para verificar a a��o do animal. O problema � que para cada a��o, ser� necess�rio criar uma nova classe concreta
        * para verificar qual animal faz qual a��o*/
        //imprimeAnimais(animais, new AnimalNadador());

        /*Com o uso de lambdas - Em apenas uma linha, � passado qual � a a��o que o animal ir� realizar sem a necessidade
        * de criar uma classe concreta para representar a a��o a ser verificada*/

        //AcaoAnimal animals = a -> a.isEh_voador();

        /*AcaoAnimal animal = (Animal a) -> {
          boolean isNadador = a.isEh_nadador();
          return isNadador;
        };*/

        /*Realizando ordena��o por idade do animal usando o Comparator com lambda*/

        //animais.sort((animal1, animal2) -> Integer.compare(animal1.getAge(), animal2.getAge()));
        animais.sort((animal1, animal2) -> animal1.getEspecies().compareTo(animal2.getEspecies()));

        imprimeAnimais(animais, animal -> animal.isEh_voador());

        //imprimeAnimais(animais, animal -> animal.isEh_nadador()); // faz a mesma a��o da instru��o seguinte
        //imprimeAnimais(animais, (Animal animal) -> { return animal.isEh_voador(); }); // faz a mesma a��o da instru��o anterior

        /*Estrutura da express�o lambda
        * animal     ->                animal.isEh_nadador()
        * parametro  operador arrow    corpo que possui apenas um metodo
        *
        * Parametros para express�o lambdas
        * () -> true - sem parametros
        * a -> a.isEh_nadador() - um parametro
        * (Animal a) -> a.isEh_nadador - um parametro
        * (a, b) -> a.isEh_nadador() - dois parametros
        * (Animal a, Animal b) -> a.isEh_nadador() - dois parametros
        *
        * */

    }

    private static void imprimeAnimais(List<Animal> animais, AcaoAnimal animalNadador) {
        for (Animal animal : animais) {
            if (animalNadador.verificaAcao(animal)) {
                System.out.printf("Animal %s, idade: %d\n", animal.getEspecies(), animal.getAge());
            }
        }
    }



}
