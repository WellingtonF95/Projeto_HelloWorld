package CollectionsConceitos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

import Wrappers.Exercicio_Wrappers.Televisor;

public class LinkedListExemplo {

    public static void main(String[] args) {

        /*Exemplo com LinkedList
        * O linkedList � mais performatico para a adi��o e remo��o de elementos, mas n�o � performatico para a itera��o de elementos,
        * por ser uma lista ligada.
        * A implementa��o com LinkedList possui os m�todos addFist, addLast, getFirst e getLast a qual � uma implementa��o
        * em que o ArrayList possu� at� a vers�o 17 LTS do Java. A partir da vers�o 21 LTS, esses m�todos tamb�m foram
        * adicionados na implementa��o do ArrayList*/

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
        * A implementa��o com Vector � muito parecida com a implementa��o com ArrayList. Possu� os mesmos m�todos de adi��o, remo��o de elementos
        * e dentre outros.
        * Mas o que o torna diferente � que ele � thread-safe (significa que, por exemplo, uma thread 2 que vai remover um elemento n�o deve remover
        * enquanto a thread 1 que adiciona um elemento n�o tenha sido conclu�da primeiro). Isso garante que n�o haja qualquer inconsistencia e consequentemente
        * perca de dados durante a manipula��o concorrente da mesma estrutura de dado, o Vector.
        * */


        Vector<Televisor> televisores = new Vector<>();

    }


}
