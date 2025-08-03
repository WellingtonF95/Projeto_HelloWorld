package FuncionalInterfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import FuncionalInterfaces.classes.Animal;
import FuncionalInterfaces.classes.AnimalNadador;

public class MethodReferenceExemplo {

    public static void main(String[] args) {

        // Method Reference - tipo de lambda especial que invoca a referencia do metodo e não o metodo.
        // Essa referencia é feita em tempo de compilação

        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe espada", true, false, 10));
        animais.add(new Animal("tucano", false, true, 9));
        animais.add(new Animal("papagaio", false, true, 5));
        animais.add(new Animal("calopsita", false, true, 4));
        animais.add(new Animal("camarão", true, false, 5));

        Function<Animal, String> functionLambda = animal -> animal.getEspecies(); // expressão lambda
        Function<Animal, String> functionMethodReference = Animal::getEspecies; // method reference

        // ordenando a lista usando Comparator passando uma function que invoca a referencia do metodo (method reference)
        animais.sort(Comparator.comparing(Animal::getAge).thenComparing(Animal::getEspecies));

        // Method Reference sendo usado a partir de um valor de instancia
        //AnimalNadador animalNadador = new AnimalNadador();
        //animais.forEach(animal -> animalNadador.eh_animal_nadador(animal)); // Com expressão lambda
        //animais.forEach(animalNadador::eh_animal_nadador); // Com method reference

        // Method Reference sendo usado a partir de uma referencia a um metodo estatico
        animais.forEach(AnimalNadador::imprimeEspecie);

        // Method Reference sendo usado a partir de uma referencia a um construtor
        Function<String, Animal> functionCriaAnimal = especie -> new Animal(especie); // Com expressão lambda
        Function<String, Animal> functionCriaAnimal2 = Animal::new; // Com method Reference
        Animal animal = functionCriaAnimal2.apply("Cachorro");
        System.out.println(animal);

        //animais.forEach(System.out::println);




    }
}
