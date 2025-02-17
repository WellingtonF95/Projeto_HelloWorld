package CollectionsConceitos.Imutaveis;

import java.util.Collections;
import java.util.List;

public class EmptyList {

    public static void main(String[] args) {

        // Metodo Collections.emptyList() cria uma instancia de collection vazia e imutavel
        // Vem desde o java 1.5

        List<Integer> numeros = Collections.emptyList();
        numeros.add(1); //UnsupportedOperationException

        System.out.println(numeros);

        // O metodo List.of() sem nenhum argumento tem o mesmo efeito do Collections.emptyList(), com suas particularidades
        // de implementação

        List<Integer> numeros2 = List.of();

    }
}
