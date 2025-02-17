package CollectionsConceitos.Imutaveis;

import java.util.List;

public class Of {

    public static void main(String[] args) {

        // Metodo of permite criar collections com ou sem valores pre determinados e que são imutaveis
        // apos a sua instanciação
        // Novidade do java 9

        List<Integer> numeros = List.of(1, 2);
        numeros.add(3); //UnsupportedOperationException

        System.out.println(numeros);

    }

}
