package CollectionsConceitos;

import java.util.*;

public class MergeVsComputeMap {

    public static void main(String[] args) {

        //TODO - Apos os estudos de functions, lambdas e streams, retornar com os estudos dos metodos merge e compute
        //Merge - Serve para atualizar valores de uma chave usando functions

        Map<String, Integer> pontos = new HashMap<>();
        pontos.put("Wellington", 10);

        pontos.merge("Thais", 15, Integer::sum);
        pontos.merge("Wellington", 10, Integer::sum);

        for (Map.Entry<String, Integer> entry : pontos.entrySet()) {
            System.out.printf("%s -> %d pontos\n", entry.getKey(), entry.getValue());
        }

        Map<String, List<String>> contatos = new HashMap<>();
        contatos.merge("Wellington", new ArrayList<>(List.of("97744-9966")), (listaAtual, listaNova) -> {
            listaAtual.addAll(listaNova);
            return listaAtual;
        });

        contatos.merge("Thais", new ArrayList<>(List.of("97744-5556")), (listaAtual, listaNova) -> {
            listaAtual.addAll(listaNova);
            return listaAtual;
        });

        //ComputeIfAbsent - Cria valores dentro do map
        contatos.computeIfAbsent("Washington", nome -> new ArrayList<>()).add("4875-0000");

        //ComputeIfPresent - Atualiza valores existentes dentro do map
        contatos.computeIfPresent("Wellington", (nome, listaNumeros) -> {
            listaNumeros.add("95214-7963");
            return listaNumeros;
        });

        for (Map.Entry<String, List<String>> entry : contatos.entrySet()) {
            System.out.printf("%s = %s\n", entry.getKey(), entry.getValue());
        }

    }

}
