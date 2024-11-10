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
        * O iterator � uma interface muito util para iterar elementos de qualquer collection.
        * O iterator olha o elemento a qual se encontra o cursor e n�o para o indice da collection, como � o caso de implementa��es que estendem a interface List
        * A interface Collections herda da interface Iterable (iteravel), que por sua vez possu� um metodo chamado iterator()
        * Para implementa��es como o ArrayList por exemplo, tem a implementa��o obrigatoria do metodo iterator() que vem da classe Collection que por sua vez
        * extende a interface Iterable. Ao chamar esse metodo de um Arraylist, ele j� retorna um objeto do tipo Iterator. Ex: televisores.iterator()
        * Dentro da classe ArrayList, existe uma inner classe chamada ListItr, que � uma implementa��o interna de ArrayList que implementa a interface ListIterator
        * onde possu� m�todos especificos de itera��o para listas e que consequentemente extende a interface Iterator
        *
        * As implementa��es como ArrayList e outras possuem um conceito chamado fail-fast. Mais explica��es est�o nessa doc: https://www.baeldung.com/java-fail-safe-vs-fail-fast-iterator
        *
        * Ao iterar elementos com iterator, se houver alguma tentativa de realizar opera��es de adi��o ou dele��o de elementos, ser� a lan�ado
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
        televisorIterator.forEachRemaining(System.out::println); // -> Percorre por elementos do ArrayList usando express�o lambda

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
