package CollectionsConceitos;

import java.util.ArrayList;
import java.util.List;

import Wrappers.Exercicio_Wrappers.Televisor;

public class ConceitosListas {

    public static void main(String[] args) {
        //Criando uma lista
        List<Televisor> televisores = new ArrayList<>(); // Abstraindo da interface List
        ArrayList<Televisor> televisoresArrayList = new ArrayList<>();
        televisoresArrayList.add(new Televisor());
        televisoresArrayList.add(new Televisor(50,90));
        televisoresArrayList.add(new Televisor());

        Televisor televisor = new Televisor();

        System.out.println("...Adicionando elementos na lista...");

        televisores.add(televisor); // Adiciona o objeto ao final da lista
        System.out.printf("Lista de televisores: %s\n", televisores);

        Televisor televisorLCD = new Televisor(2, 20);

        televisores.add(0, televisorLCD); // Adiciona o objeto a posição 0 da lista
        System.out.printf("Novo televisor adicionado: %s\n", televisores);

        //Obtem o tamanho da lista - quantos elementos a lista possuí
        System.out.printf("Tamanho da lista de televisores: %d\n", televisores.size());

        for (int i = 0; i < televisores.size(); i++) {
            System.out.printf("Televisor %d: %s\n", i, televisores.get(i));
            System.out.printf("Canal do televisor %d: %s\n", i, televisores.get(i).getCanal());
        }

        System.out.println("--FIM--");

        System.out.println("...Removendo elementos na lista...");

        System.out.printf("Removendo o televisor que possui o canal %d\n", televisor.getCanal());
        televisores.remove(televisor); // Remove o objeto da lista
        System.out.printf("Televisor removido. Status atual da lista: %s\n", televisores);

        System.out.printf("Removendo o televisor que possui o canal %d\n", televisorLCD.getCanal());
        televisores.remove(0); //Remove o objeto da posição 0
        System.out.printf("Lista de televisores vazia: %s\n", televisores);

        televisores.add(new Televisor());
        televisores.add(new Televisor(50,90));
        televisores.add(new Televisor());
        System.out.printf("Lista novamente carregada: %s\n", televisores);

        televisores.removeAll(televisores); // Remove todos os elementos da lista
        System.out.printf("Lista de televiores novamente vazia usando o removeAll: %s\n", televisores);

        televisores.add(new Televisor());
        televisores.add(new Televisor(50,90));
        televisores.add(new Televisor());
        System.out.printf("Lista novamente carregada: %s\n", televisores);
        televisores.removeIf(tv -> tv.getCanal() < 100); //Remove elementos que atendem uma condição especifica
        System.out.printf("Status atual da lista de televisores apos o uso do removeIf: %s\n", televisores);

        List<Televisor> outraListadeTelevisores = new ArrayList<>();
        outraListadeTelevisores.add(new Televisor());
        outraListadeTelevisores.add(new Televisor());

        outraListadeTelevisores.get(1);




    }

}
