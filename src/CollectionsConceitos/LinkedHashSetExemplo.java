package CollectionsConceitos;

import CollectionsConceitos.Model.Curso;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExemplo {

    public static void main(String[] args) {

        /*O linkedHashSet ele tamb�m � um conjunto (Set) que extende a classe HashSet e implementa a interface Set
        * Possui as mesmas caracteristicas que o HashSet, mas a sua diferen�a � que ele � uma lista ligada. Tambem � menos perform�tico que o HashSet e mais perform�tico que o TreeSet
        * O que significa que os elementos v�o estar ordenados por ordem de inser��o */

        //Exemplo com numeros inteiros
        Set<Integer> idades = new LinkedHashSet<>();
        idades.add(90);
        idades.add(50);
        idades.add(65);
        idades.add(23);
        idades.add(14);

        idades.forEach(System.out::println);

        //Exemplo com numeros com ponto flutuante
        Set<Float> pesos = new LinkedHashSet<>();
        pesos.add(100.12f);
        pesos.add(78.5f);
        pesos.add(69.9f);
        pesos.add(69.97f);

        pesos.forEach(System.out::println);

        //Exemplo com strings
        Set<String> nomes = new LinkedHashSet<>();
        nomes.add("Wellington");
        nomes.add("Creuza");
        nomes.add("Gilmar");
        nomes.add("Thais");

        nomes.forEach(System.out::println);

        Set<Curso> cursos = new LinkedHashSet<>();

        cursos.add(new Curso(12, "Ciencia da Computa��o"));
        cursos.add(new Curso(23, "An�lise e Desenvolvimento de Sistemas"));
        cursos.add(new Curso(333, "Gest�o em TI"));

        System.out.println(cursos);

    }

}
