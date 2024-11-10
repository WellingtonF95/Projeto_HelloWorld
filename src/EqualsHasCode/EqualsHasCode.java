package EqualsHasCode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Wrappers.Exercicio_Wrappers.Televisor;

public class EqualsHasCode {

    public static void main(String[] args) {
        String opcao;
        Set<Televisor> televisores = new HashSet<>();

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Deseja adicionar algum canal e volume de um televisor? (s/n): ");

            opcao = scan.next();

            while (opcao.equalsIgnoreCase("s")) {
                System.out.println("Informe o canal: ");
                int canal = scan.nextInt();
                System.out.println("Informe o volume:");
                int volume = scan.nextInt();

                Televisor tv = new Televisor(canal, volume);

                if (televisores.contains(tv)) {
                    System.out.println("O televisor já está na lista");
                } else {
                    televisores.add(tv);
                }

                System.out.println("Deseja adicionar mais algum canal e volume de um televisor? (s/n)");
                opcao = scan.next();
            }

            televisores.forEach(System.out::println);
        }
    }
}
