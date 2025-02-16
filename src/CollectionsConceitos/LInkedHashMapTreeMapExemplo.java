package CollectionsConceitos;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import CollectionsConceitos.Model.Curso;
import CollectionsConceitos.Model.Estudante;

public class LInkedHashMapTreeMapExemplo {

    public static void main(String[] args) {

        Curso cc = new Curso(123, "Ciencia da Computa��o");
        Curso si = new Curso(124, "Sistema da Informa��o");
        Curso ads = new Curso(125, "An�lise e Desenvolvimento de Sistemas");
        Curso ec = new Curso(126, "Engenharia da Computa��o");

        Estudante wellington = new Estudante(111, "Wellington");
        Estudante thais = new Estudante(222, "Thais");
        Estudante renato = new Estudante(333, "Renato");
        Estudante daniel = new Estudante(444, "Daniel");

        //Usando a implementa��o LinkedHashMap - Implementa a interface HashMap, mas � menos performatica
        //pois ela usa lista ligada
        //Mantem a ordem de inser��o dos elementos
        //Map<Estudante, Curso> classe = new LinkedHashMap<>();

        //Usando a implementa��o TreeMap - Implementa a interface NavigableMap, que extende a interface SortedMap e que
        //extende a interface Map
        //N�o possui tabelas de espalhamento porque ela implementa o algoritmo red-black tree ou arvore rubro negra
        //Realiza a ordena��o das chaves por ordem natural
        Map<Estudante, Curso> classe = new TreeMap<>();

        classe.put(wellington, cc);
        classe.put(renato, cc);
        classe.put(daniel, si);
        classe.put(thais, ads);

        //Atribuindo valores nulos
        //classe.put(null, ads);
        classe.put(renato, null);

        for (Map.Entry<Estudante, Curso> entry : classe.entrySet()) {
            System.out.printf("Estudante: %s -> Curso: %s\n",
                    Objects.isNull(entry.getKey()) ? "Nenhum Estudante" : entry.getKey().getNome(),
                    Objects.isNull(entry.getValue()) ? "Nenhum Curso" : entry.getValue().getNome());
        }

    }

}
