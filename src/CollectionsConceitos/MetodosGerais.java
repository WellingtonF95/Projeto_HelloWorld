package CollectionsConceitos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Wrappers.Exercicio_Wrappers.Televisor;

public class MetodosGerais {

    public static void main(String[] args) {

        Collection<Televisor> tvs = new ArrayList<>();
        Televisor televisor = new Televisor(0,0);
        Televisor tvLCD = new Televisor(100,100);

        //Metodo add - Adiciona elementos a lista
        tvs.add(new Televisor());
        tvs.add(new Televisor(12,12));
        tvs.add(televisor);
        tvs.add(tvLCD);
        System.out.printf("Lista Carregada com o método add() -> %s\n", tvs);

        //Metodo addAll - Adiciona todos os elementos de uma outra lista: othersTvs para a lista tvs
        Collection<Televisor> othersTvs = new ArrayList<>(
                List.of(new Televisor(999,999), new Televisor(99,99), new Televisor(9,9)));
        tvs.addAll(othersTvs);
        System.out.printf("Lista tvs carregada com o método addAll() -> %s\n", tvs);
        System.out.printf("OthersTvs -> %s\n", othersTvs);

        //Metodo size - Retorna a quantidade de elementos da lista tvs
        System.out.printf("Quantidade de elementos que possui a lista tvs: %d\n", tvs.size());
        System.out.printf("Quantidade de elementos que possui a lista othersTvs: %d\n", othersTvs.size());

        //Metodo contains - Verifica se a lista contem o elemento especificado no parametro
        System.out.printf("Contem o objeto tvLCD? %s\n", tvs.contains(tvLCD));

        //Metodo containsAll - Verifica se a lista tvs contem todos os elementos da lista othersTvs
        System.out.printf("Contem elementos da lista othersTvs? %s\n", tvs.containsAll(othersTvs));

        //Metodo remove - Remove elementos da lista
        tvs.remove(televisor);
        System.out.printf("Elemento removido da lista tvs, Tvs -> %s\n", tvs);

        //Metodo retainAll - Mantem os elementos da lista othersTvs que está na lista tvs e remove os demais elementos
        tvs.retainAll(othersTvs);
        System.out.printf("Elementos da lista othersTvs mantidos na lista tvs -> %s\n", tvs);

        //Metodo removeAll - Remove todos os elementos da lista othersTv que esta na lista tvs
        tvs.removeAll(othersTvs);
        System.out.printf("Lista othersTvs removida da lista tvs. Tvs -> %s\n", tvs);

        //Metodo isEmpty - Verifica se a lista esta vazia. Retorna um booleano
        System.out.printf("Lista tvs esta vazia? %s\n", tvs.isEmpty());
        System.out.printf("Lista othersTvs esta vazia? %s\n", othersTvs.isEmpty());

        //Metodo removeIf - Remove elementos da lista dada uma condicao especifica
        othersTvs.removeIf(otherTv -> otherTv.getCanal() < 100);
        System.out.printf("Lista otherTvs após a remoção de elementos se o canal for menor que 100, othersTvs -> %s\n", othersTvs);

        //Metodo clear - Remove TODOS os elementos de uma colecao
        tvs.clear();
        othersTvs.clear();
        System.out.printf("Lista tvs vazia utilizando o clear -> %s\n", tvs);
        System.out.printf("Lista othersTvs vazia utilizando o clear -> %s\n", othersTvs);




    }

}
