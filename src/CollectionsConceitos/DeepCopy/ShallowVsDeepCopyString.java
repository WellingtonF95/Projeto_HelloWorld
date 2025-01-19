package CollectionsConceitos.DeepCopy;

import java.util.ArrayList;
import java.util.List;

public class ShallowVsDeepCopyString {

    public static void main(String[] args) {

        //Copia superficial
        List<String> nomes = new ArrayList<>();
        nomes.add("Wellington");
        nomes.add("Thais");

        List<String> sobrenomes = nomes;
        sobrenomes.add("Francelino");

        System.out.printf("%s\n", nomes);
        System.out.printf("%s\n", sobrenomes);

        //copia profunda
        List<String> perifericosEntrada = new ArrayList<>();
        perifericosEntrada.add("Mouse");
        perifericosEntrada.add("Teclado");

        List<String> perifericos = new ArrayList<>(perifericosEntrada);
        perifericos.add("Monitor");

        System.out.printf("%s\n", perifericosEntrada);
        System.out.printf("%s\n", perifericos);
    }

}
