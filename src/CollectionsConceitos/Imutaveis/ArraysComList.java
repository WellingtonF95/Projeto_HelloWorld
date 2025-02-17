package CollectionsConceitos.Imutaveis;

import java.util.Arrays;
import java.util.List;

public class ArraysComList {

    public static void main(String[] args) {

        // Para arrays, é possível usar a interface List como abstração
        // Para adicionar elementos, só é possivel usando o set(indice, elemento). As duas instancias sofrem alterações de valores
        // É possível iterar arrays a partir da implementação com List usando for, iterator e encanceded for e o uso de expressões lambdas

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
