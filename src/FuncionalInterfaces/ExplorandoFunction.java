package FuncionalInterfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

import FuncionalInterfaces.classes.Animal;

public class ExplorandoFunction {

    public static void main(String[] args) {

        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe espada", true, false, 10));
        animais.add(new Animal("tucano", false, true, 9));
        animais.add(new Animal("papagaio", false, true, 5));
        animais.add(new Animal("calopsita", false, true, 4));
        animais.add(new Animal("camarão", true, false, 5));

        /* Ordenando a lista usando o metodo compare da interface Comparator passando como expressão a lógica da comparação.
          Nesse exemplo se houvesse a necessidade de realizar uma segunda comparação, não seria possível */
        //animais.sort((animal1, animal2) -> Integer.compare(animal1.getAge(), animal2.getAge()));

        /* Usando Function para realizar a ordenação da lista com o metodo comparing da interface Comparator.
        * A function passada serve como uma chave de identificação para qual critério em que o metodo comparing deve ordenar, ou seja,
        * quem irá no final fazer a ordenação será a interface, a function é usada nesse caso para especificar o valor (campo) que sera ordenado
        *
        * Nessa abordagem é possível realizar combinações de ordenações (mas somente se for com method Reference).
        * O exemplo está ordenando por idade e por ordem alfabetica a lista de animais
        *  */
        //Function<Animal, Integer> functionOrdenaAnimalIdade = animal -> animal.getAge();
        //Function<Animal, String> functionOrdenaPorNome = animal -> animal.getEspecies();
        //animais.sort(Comparator.comparing(functionOrdenaAnimalIdade).thenComparing(functionOrdenaPorNome));

        // Forma clean
        //animais.sort(Comparator.comparing(Animal::getAge));

        // Com method reference
        //animais.sort(Comparator.comparing(Animal::getAge).thenComparing(Animal::getEspecies));

        // Usando outras variações de Function
        animais.sort(Comparator.comparingInt(animal -> animal.getAge()));

        animais.forEach(animal -> System.out.println(animal));

        // UnaryOperator<Integer> é o mesmo que usar Function<Integer, Integer>
        UnaryOperator<Integer> unaryOperator = (num1) -> num1 * 2;
        Integer result = unaryOperator.apply(2);
        System.out.println(result);

        // BinaryOperator<Integer> é o mesmo que usar Function<Integer, Integer, Integer>
        BinaryOperator<Integer> binaryOperator = (num1, num2) -> num1 + num2;
        Integer resulSoma = binaryOperator.apply(2, 3);
        System.out.println(resulSoma);
    }

}
