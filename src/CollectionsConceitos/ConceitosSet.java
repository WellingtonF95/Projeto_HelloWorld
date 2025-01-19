package CollectionsConceitos;

import CollectionsConceitos.DeepCopy.Curso;
import CollectionsConceitos.DeepCopy.Estudante;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConceitosSet {

    public static void main(String[] args) {

        //A principal caracteristica dos Conjuntos (Set) é que ele não permite duplicatas. Ele não possuí
        //indices como as listas possui. Mas ele se torna mais performatico pois ele utiliza a tabela de espelhamento
        //(Hash Tables)

        Set<String> nomes = new HashSet<>();
        System.out.println(nomes.add("Wellington"));
        nomes.add("Thais");
        System.out.println(nomes.add("Wellington"));
        nomes.add(null);

        Iterator<String> nomesIterator = nomes.iterator();

        while (nomesIterator.hasNext()) {
            System.out.println(nomesIterator.next());
        }

        for (String nome : nomes) {
            System.out.println(nome);
        }

        Estudante estudante1 = new Estudante(123,"Wellinton",new Curso(1, "Ciencia da Computação"));
        Estudante estudante11 = new Estudante(123,"Wellington",new Curso(1, "Ciencia da Computação"));
        Estudante estudante2 = new Estudante(123,"Willian",new Curso(1, "Ciencia da Computação"));
        Estudante estudante3 = new Estudante(123,"Thais",new Curso(2, "Sistema de Informação"));

        System.out.println(estudante1.equals(estudante11));
        System.out.println(estudante1.hashCode() == estudante11.hashCode());
        System.out.println(estudante2.hashCode());
        System.out.println(estudante3.hashCode());



    }

}
