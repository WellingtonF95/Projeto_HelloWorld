package FuncionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import FuncionalInterfaces.classes.Animal;

public class ExplorandoConsumer {

    public static void main(String[] args) {

        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe espada", true, false, 10));
        animais.add(new Animal("tucano", false, true, 9));
        animais.add(new Animal("camarão", true, false, 6));
        animais.add(new Animal("calopsita", false, true, 4));
        animais.add(new Animal("papagaio", false, true, 5));

        // imprimindo os animais com o Consumer
        animais.forEach(animal -> System.out.println(animal));

        // Setando a idade dos animais em zero e imprimindo dentro do Consumer
        /*animais.forEach(animal -> {
           animal.setAge(0);
           System.out.println(animal);
        });*/

        // Criando um consumer para setar a idade do animal em zero e
        // Criando outro consumer para imprimir os animais
        // Fazendo a combinação dos consumers durante o mesmo looping usando o metodo default andThen
        //Consumer<Animal> consumerSetIdade = animal -> animal.setAge(0);
        //Consumer<Animal> consumerImprimeAnimal = animal -> System.out.println(animal);

        //animais.forEach(consumerSetIdade.andThen(consumerImprimeAnimal));

        // A diferença entre usar o enhanced for e o forEach funcional é que no forEach funcional uma variavel fora do escopo
        // não pode ser alterada, sendo ela obrigatóriamente final

        int idade = 0;
        //Consumer<Animal> consumer = animal -> animal.setAge(idade++); // Erro de compilação

        for (Animal animal: animais) {
            animal.setAge(idade++);
            System.out.println(animal);
        }
    }
}
