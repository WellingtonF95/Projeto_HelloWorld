package CollectionsConceitos.Imutaveis;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SingletonList {

    public static void main(String[] args) {

        // Metodo Collections.singletonList() permite criar uma lista com apenas 1 elemento e ela é imutavel
        // Desde o java 1.3
        // assim existe outras implementações como o map (singletonMap) e o set (singleton)

        List<Integer> numeros = Collections.singletonList(1);
        Set<Integer> set = Collections.singleton(1);
        numeros.add(2); //UnsupportedOperationException

        System.out.println(numeros);

    }
}