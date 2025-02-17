package CollectionsConceitos.Imutaveis;

import java.util.ArrayList;
import java.util.List;

public class CopyOf {

    public static void main(String[] args) {

        //Metodo copyList é uma implementação que permite copiar uma collection, sem que essa collection possa ser
        //modificada
        //Novidade do java 10

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);

        List<Integer> numerosCopia = List.copyOf(numeros);

        numeros.add(3);

        System.out.println(numeros); //[1, 2, 3]
        System.out.println(numerosCopia); //[1, 2]
    }

}
