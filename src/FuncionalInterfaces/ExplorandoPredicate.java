package FuncionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import FuncionalInterfaces.classes.Animal;

public class ExplorandoPredicate {

    public static void main(String[] args) {

        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe espada", true, false, 12));
        animais.add(new Animal("tucano", false, true, 4));
        animais.add(new Animal("camarão", true, false, 6));
        animais.add(new Animal("calopsita", false, true, 2));
        animais.add(new Animal("papagaio", false, true, 5));

        animais.removeIf(animal -> animal.getAge() > 5); // usando o removeIf que recebe um predicate

        Predicate<Animal> predicateIdade = animal -> animal.getAge() > 5;
        Predicate<Animal> predicateAnimalC = animal -> animal.getEspecies().startsWith("c");

        //animais.removeIf(predicateIdade.or(predicateAnimalC)); // Remove se tiver idade maior que 5 OU se começar com a letra c - Remove 3
        //animais.removeIf(predicateIdade.and(predicateAnimalC)); // Remove se tiver idade maior que 5 E se começar com a letra c - Remove 1
        //animais.removeIf(predicateIdade.negate()); // Remove se tiver idade menor que 5
        //animais.removeIf(Predicate.not(predicateAnimalC)); // Remove se começar com outra letra diferente de c. Usando o metodo estatico not

        for (Animal animal : animais) {
            System.out.println(animal);
        }





    }
}
