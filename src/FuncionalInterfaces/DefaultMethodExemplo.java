package FuncionalInterfaces;

import java.util.ArrayList;
import java.util.List;

import FuncionalInterfaces.classes.Animal;
import FuncionalInterfaces.classes.AnimalNadador;

public class DefaultMethodExemplo {

    public static void main(String[] args) {

        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe espada", true, false, 12));
        animais.add(new Animal("tucano", false, true, 4));
        animais.add(new Animal("camarão", true, false, 6));
        animais.add(new Animal("calopsita", false, true, 2));

        imprimeAnimais(animais, new AnimalNadador());

    }

    private static void imprimeAnimais(List<Animal> animais, AnimalNadador animalNadador) {
        for (Animal animal : animais) {
            if (animalNadador.eh_animal_nadador(animal)) {
                System.out.printf("Animal %s\n", animal.getEspecies());
            }
        }
    }

}
