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

        Estudante estudante1 = new Estudante(123,"Wellington",new Curso(1, "Ciencia da Computação"));
        Estudante estudante2 = new Estudante(123,"Wellington",new Curso(1, "Ciencia da Computação"));
        Estudante estudante3 = new Estudante(123,"Willian",new Curso(1, "Ciencia da Computação"));
        Estudante estudante4 = new Estudante(123,"Thais",new Curso(2, "Sistema de Informação"));

        /*Retomando: o equals e hashCode tem que ter o mesmo resultado:
        para objetos iguais - o equals retorna true, o hashCode tem que retornar true
        para objetos diferentes - o equals retorna false, não necessáriamente o hashCode tem que retornar false. (Isso depende da implementação do metodo hashCode)
        O ideal seria retornar códigos hashes diferentes para objetos diferentes, para que a tabela de espelhamento tenha efetividade e "espalhe" mais os objetos nela
        O ideal para que a tabela de espalhamento tenha uma boa performance é usar algoritmos eficientes nessa geração. O recomendado é usar a implementação da própria IDE
        */

        System.out.println(estudante1.equals(estudante2));
        System.out.println(estudante1.hashCode() == estudante2.hashCode());
        System.out.println(estudante1.hashCode());
        System.out.println(estudante2.hashCode());
        System.out.println(estudante3.hashCode());
        System.out.println(estudante4.hashCode());

        /*Ao utilizar o Set, para cada elemento adicionado ao conjunto, o metodo equals é invocado. Isso se dá pelo fato do Set não aceitar duplicatas,
        * por isso sempre haverá essa verificação antes de adicionar os elementos ao conjunto Set.
        * */

        Set<Estudante> estudantes = new HashSet<>();

        System.out.println("---");
        estudantes.add(estudante1);
        estudantes.add(estudante2);
        estudantes.add(estudante3);
        estudantes.add(estudante4);
        System.out.println("---");
        estudantes.add(new Estudante(123, "Wallace", new Curso()));
        System.out.println("---");
        estudantes.add(new Estudante(123, "Tatiana", new Curso()));

        System.out.println(estudantes);

        //Ao verificar se a lista de estudante contem a estudante Tatiana, é feita a verificação na tabela de espalhamento se a Tatiana já foi
        //adicionada no conjunto (Para uma implementação do hashCode gerando o hash a partir da primeira letra do nome).
        System.out.println(estudantes.contains(new Estudante(123, "Thales", new Curso())));


    }

}
