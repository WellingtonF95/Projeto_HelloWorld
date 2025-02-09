package CollectionsConceitos;

import CollectionsConceitos.Comparators.IdEstudanteComparator;
import CollectionsConceitos.Model.Curso;
import CollectionsConceitos.Model.Estudante;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExemplo {

    public static void main(String[] args) {

        /*TreeSet é um conjunto que implementa a interface NavigableSet, que extende a interface SortedSet e que extende a interface Set
        * TreeSet é uma estrutura de dados que realiza a ordenação dos elementos do conjunto de maneira natural.
        * Também é conhecido por implementar o algoritmo chamado de red-black tree ou arvore rubro-negra
        * Ao contrario do HashSet, ele não chama por debaixo dos panos o metodo equals*/

        //Exemplo com numeros inteiros
        Set<Integer> idades = new TreeSet<>();
        idades.add(90);
        idades.add(50);
        idades.add(65);
        idades.add(23);
        idades.add(14);

        idades.forEach(System.out::println);

        //Exemplo com numeros com ponto flutuante
        Set<Float> pesos = new TreeSet<>();
        pesos.add(100.12f);
        pesos.add(78.5f);
        pesos.add(69.9f);
        pesos.add(69.97f);

        pesos.forEach(System.out::println);

        //Exemplo com strings
        Set<String> nomes = new TreeSet<>();
        nomes.add("Wellington");
        nomes.add("Creuza");
        nomes.add("Gilmar");
        nomes.add("Thais");

        nomes.forEach(System.out::println);

        /*Para o uso do TreeSet em objetos complexos, é obrigatório a implementação da interface Comparable e a sobrescrita do metodo compareTo
        * Caso a não implementação, poderá ocorrer um ClassCastException. Esse erro ocorre porque não foi especificado qual propriedade do objeto deve-se ordenar*/

        //Exemplo com objeto que implementa a inteface Comparable e o metodo compareTo
        Set<Estudante> estudantes = new TreeSet<>();

        estudantes.add(new Estudante(123,"Wellington",new Curso(1, "Ciencia da Computação")));
        estudantes.add(new Estudante(123,"Wellington",new Curso(1, "Ciencia da Computação")));
        estudantes.add(new Estudante(123,"Willian",new Curso(1, "Ciencia da Computação")));
        estudantes.add(new Estudante(123,"Thais",new Curso(2, "Sistema de Informação")));

        System.out.println(estudantes);

        //Exemplo com objeto que não implementa a interface Comparable, resultando na exception do tipo ClassCastException
        /*Set<Curso> cursos = new TreeSet<>();

        cursos.add(new Curso(12, "Ciencia da Computação"));
        cursos.add(new Curso(23, "Análise e Desenvolvimento de Sistemas"));

        System.out.println(cursos);*/

        /*É possível implementar a interface Comparator para utilizar uma ordenação especifica de uma propriedade.
        Para isso, deve-se inicializar o TreeSet com a classe que implementa a interface Comparator
        *! Mas não é recomendada pois pode ocorrer inconsistencias nos valores dos objetos !
        Por isso que a boa prática é sempre usar a(s) mesma(s) propriedade(s) ao sobreescrever os métodos equals, hashCode e o compareTo*/

        Set<Estudante> estudantesIds = new TreeSet<>(new IdEstudanteComparator());

        System.out.println("---");
        /*Nesse exemplo, os estudantes com o mesmo nome serão adicionados no TreeSet, uma vez que agora a comparação está sendo realizada pelo id
        * E não será adicionada uma nova estudante ao TreeSet se ela possuir o mesmo id (Levando a consideração o comparator que foi adicionado no construtor do TreeSet)*/
        estudantesIds.add(new Estudante(10, "Wellington", new Curso(1, "Ciencia da Computação")));
        estudantesIds.add(new Estudante(45,"Mateus",new Curso(1, "Ciencia da Computação")));
        estudantesIds.add(new Estudante(1, "Wellington", new Curso(1, "Ciencia da Computação"))); //Entra -> inconsistente
        estudantesIds.add(new Estudante(100,"Thais",new Curso(2, "Sistema de Informação")));
        estudantesIds.add(new Estudante(100,"Thaina",new Curso(2, "Sistema de Informação"))); //Não entra -> inconsistente

        estudantesIds.forEach(System.out::println);

    }

}
