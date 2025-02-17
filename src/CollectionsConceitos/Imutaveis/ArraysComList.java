package CollectionsConceitos.Imutaveis;

import java.util.Arrays;
import java.util.List;

public class ArraysComList {

    public static void main(String[] args) {

        // Para arrays, � poss�vel usar a interface List como abstra��o
        // Para adicionar elementos, s� � possivel usando o set(indice, elemento). As duas instancias sofrem altera��es de valores
        // � poss�vel iterar arrays a partir da implementa��o com List usando for, iterator e encanceded for e o uso de express�es lambdas

        Integer[] arrayNumeros = {1 , 2};

        List<Integer> numeros = Arrays.asList(arrayNumeros);

        numeros.set(0, 2);
        //numeros.add(3); // UnsupportedOperationException

        System.out.println(Arrays.toString(arrayNumeros)); // [2, 2]
        System.out.println(numeros); // [2, 2]

        for (int i = 0; i < arrayNumeros.length; i++) {
            System.out.println(arrayNumeros[i]);
        }

        for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.get(i));
        }
    }
}
