package CollectionsConceitos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

import Wrappers.Exercicio_Wrappers.Televisor;

public class LinkedListExemplo {

    public static void main(String[] args) {

        /*Exemplo com LinkedList
        * O linkedList é mais performatico para a adição e remoção de elementos, mas não é performatico para a iteração de elementos,
        * por ser uma lista ligada.
        * A implementação com LinkedList possui os métodos addFist, addLast, getFirst e getLast a qual é uma implementação
        * em que o ArrayList possuí até a versão 17 LTS do Java. A partir da versão 21 LTS, esses métodos também foram
        * adicionados na implementação do ArrayList*/

        ArrayList<Televisor> tvs = new ArrayList<>(30);

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 30; i++) {
            int canal = scan.nextInt();
            int volume = scan.nextInt();

            tvs.add(new Televisor(canal, volume));

        }

        System.out.println(tvs);

        LinkedList<Televisor> televisors = new LinkedList<>();
        televisors.add(new Televisor(12,12));
        televisors.add(new Televisor(0,0));
        televisors.add(new Televisor());
        System.out.println(televisors);

        /*Exemplo com Vector
        * A implementação com Vector é muito parecida com a implementação com ArrayList. Possuí os mesmos métodos de adição, remoção de elementos
        * e dentre outros.
        * Mas o que o torna diferente é que ele é thread-safe (significa que, por exemplo, uma thread 2 que vai remover um elemento não deve remover
        * enquanto a thread 1 que adiciona um elemento não tenha sido concluída primeiro). Isso garante que não haja qualquer inconsistencia e consequentemente
        * perca de dados durante a manipulação concorrente da mesma estrutura de dado, o Vector.
        * */


        Vector<Televisor> televisores = new Vector<>();

    }


}
