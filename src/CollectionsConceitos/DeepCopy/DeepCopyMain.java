package CollectionsConceitos.DeepCopy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.SerializationUtils;

public class DeepCopyMain {

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

        //Com objetos complexos - Utilizando cópia superficial

        Curso curso = new Curso();
        curso.setId(123);
        curso.setNome("Ciencia da Computação");

        Estudante estudanteCC = new Estudante();
        estudanteCC.setId(333);
        estudanteCC.setNome("Wellington");
        estudanteCC.setCurso(curso);

        Estudante estudanteSI = new Estudante();
        estudanteSI.setId(444);
        estudanteSI.setNome("Thais");
        estudanteSI.setCurso(curso);
        estudanteSI.getCurso().setNome("Sistemas da Informação");

        System.out.printf("Estudante CC -> %s\n", estudanteCC.hashCode());
        System.out.printf("Estudante SI -> %s\n", estudanteSI.hashCode());

        List<Estudante> salaCC = new ArrayList<>();
        salaCC.add(estudanteCC);
        salaCC.add(estudanteSI);

        //List<Estudante> salaSI = salaCC.stream().map(Estudante::clone).toList();

        Iterator<Estudante> salaIterator = salaCC.iterator();
        List<Estudante> salaSI = new ArrayList<>();

        while (salaIterator.hasNext()) {
            //salaSI.add(SerializationUtils.clone(salaIterator.next()));
            salaSI.add(salaIterator.next().clone());
        }

        System.out.printf("Sala CC -> %s\n", salaCC);
        System.out.printf("Sala SI -> %s\n", salaSI);
        System.out.println(salaCC.get(0).getCurso().equals(salaSI.get(0).getCurso()));


    }
}
