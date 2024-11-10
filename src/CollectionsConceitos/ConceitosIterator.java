package CollectionsConceitos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import Wrappers.Exercicio_Wrappers.Televisor;

public class ConceitosIterator {

    public static void main(String[] args) {

        /*
        * Sobre o iterator
        *
        * O iterator é uma interface muito util para iterar elementos de qualquer collection.
        * O iterator olha o elemento a qual se encontra o cursor e não para o indice da collection, como é o caso de implementações que estendem a interface List
        * A interface Collections herda da interface Iterable (iteravel), que por sua vez possuí um metodo chamado iterator()
        * Para implementações como o ArrayList por exemplo, tem a implementação obrigatoria do metodo iterator() que vem da classe Collection que por sua vez
        * extende a interface Iterable. Ao chamar esse metodo de um Arraylist, ele já retorna um objeto do tipo Iterator. Ex: televisores.iterator()
        * Dentro da classe ArrayList, existe uma inner classe chamada ListItr, que é uma implementação interna de ArrayList que implementa a interface ListIterator
        * onde possuí métodos especificos de iteração para listas e que consequentemente extende a interface Iterator
        *
        * As implementações como ArrayList e outras possuem um conceito chamado fail-fast. Mais explicações estão nessa doc: https://www.baeldung.com/java-fail-safe-vs-fail-fast-iterator
        *
        * Ao iterar elementos com iterator, se houver alguma tentativa de realizar operações de adição ou deleção de elementos, será a lançado
        * a exception ConcurrentModificationException
        * */

        Televisor tv1 = new Televisor();
        Televisor tv2 = new Televisor(55,55);
        Televisor tv3 = new Televisor();

        ArrayList<Televisor> televisores = new ArrayList<>(List.of(tv1, tv2, tv3));

        Iterator<Televisor> televisorIterator = televisores.iterator();

        System.out.println("While");
        while (televisorIterator.hasNext()) {
            System.out.println(televisorIterator.next());
        }

        System.out.println("Lambda");
        televisorIterator.forEachRemaining(System.out::println); // -> Percorre por elementos do ArrayList usando expressão lambda

        /*Usando o listIterator*/

        ArrayList<Televisor> televisors = new ArrayList<>(
                List.of(new Televisor(), new Televisor(100, 100), new Televisor(0,0)));

        ListIterator<Televisor> televisorListIterator = televisors.listIterator();

        System.out.println("List Iterator");
        while (televisorListIterator.hasNext()) {
            System.out.println(televisorListIterator.next());
        }

        /*Usando o hasPreviuos para percorrer a lista do fim para o inicio*/

        televisorListIterator = televisors.listIterator(televisors.size());

        System.out.println("List Iterator with previous");
        while (televisorListIterator.hasPrevious()) {
            System.out.println(televisorListIterator.previous());
        }


    }

}
