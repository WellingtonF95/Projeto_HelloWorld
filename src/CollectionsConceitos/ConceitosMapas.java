package CollectionsConceitos;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import CollectionsConceitos.Model.Curso;
import CollectionsConceitos.Model.Estudante;

public class ConceitosMapas {

    public static void main(String[] args) {

        Curso cc = new Curso(123, "Ciencia da Computa��o");
        Curso si = new Curso(124, "Sistema da Informa��o");
        Curso ads = new Curso(125, "An�lise e Desenvolvimento de Sistemas");
        Curso ec = new Curso(126, "Engenharia da Computa��o");

        Estudante wellington = new Estudante(111, "Wellington");
        Estudante thais = new Estudante(222, "Thais");
        Estudante renato = new Estudante(333, "Renato");
        Estudante daniel = new Estudante(444, "Daniel");

        //Declarando e adicionando elementos ao hashMap. Pode ser de qualquer tipo: desde Wrappers at� objetos.
        //Pelo menos ainda n�o � poss�vel usar tipos primitivos como chave e valor
        //� possivel ter valores duplicados para chaves diferentes
        //Mas nao � possivel ter chaves duplicadas

        Map<Estudante, Curso> classe = new HashMap<>();
        //Map<Estudante, Curso> classe = new Hashtable<>();
        classe.put(wellington, cc);
        classe.put(renato, cc);
        classe.put(daniel, si);
        classe.put(thais, ads);

        //Obtendo o valor a partir da chave
        System.out.println(classe.get(wellington));

        //Obtendo o valor a partir de uma nova instancia, mas com o nome do estudante. Por baixo dos panos, o equals e invocado
        System.out.println(classe.get(new Estudante(222, "Thais")));

        //imprimindo o hashMap. Usando a implementa�ao do toString()
        System.out.printf("Com toString() -> %s\n", classe);

        //imprimindo somente as chaves do hashMap, maneira tradicional. As chaves est�o em um conjunto (Set)
        Set<Estudante> estudantes = classe.keySet();
        estudantes.forEach(System.out::println);

        //imprimindo as chaves direto com o hashMap
        System.out.println("For direto ao keySet");
        for (Estudante estudante : classe.keySet()) {
            System.out.println(estudante);
        }

        //imprimindo somente os valores do hashMap. maneira tradicional. Retorna uma Collection pura
        Collection<Curso> cursos = classe.values();
        cursos.forEach(System.out::println);

        //Resumindo: Map<Set, Collection>

        //imprimindo os valores direto com o hashMap
        System.out.println("For direto ao values");
        for (Curso curso : classe.values()) {
            System.out.println(curso);
        }

        //imprimindo com chave e valor, usando a innerClass Entry
        System.out.println("Impress�o com {chave}={valor}");
        for(Map.Entry<Estudante, Curso> entry : classe.entrySet()) {
            System.out.printf("Estudante: %s -> %s\n", entry.getKey().getNome(), entry.getValue().getNome());
        }

        //Substituindo um valor de uma mesma chave
        classe.put(wellington, ec);

        //Removendo um valor do mapa
        classe.remove(thais);

        //Atribuindo valores nulos
        //Para a implementa��o com hashTable, n�o � permitido nem chaves e nem valores nulos
        classe.put(null, ads);
        classe.put(renato, null);

        System.out.println("Com lambda");
        Set<Map.Entry<Estudante, Curso>> entries = classe.entrySet();
        entries.forEach(
                entry -> System.out.printf("Estudante: %s -> %s\n",
                Objects.nonNull(entry.getKey()) ? entry.getKey().getNome() : "Nenhum Estudante",
                Objects.nonNull(entry.getValue()) ? entry.getValue().getNome() : "Nenhum Curso"
                )
        );

        //Metodo size: verifica a quantidade de items do mapa
        System.out.printf("Quantidade de alunos na classe: %s alunos\n", classe.size());

        //Metodo isEmpty: verifica se o mapa est� vazio
        System.out.printf("A classe est� vazia? %s\n", classe.isEmpty());

        //Metodo containsKey: verifica se a chave existe dentro do mapa
        System.out.printf("Aluno Wellington est� na classe? %s\n", classe.containsKey(new Estudante(111, "Wellington")));

        //Metodo containsValue: verifica se o valor existe dentro do mapa
        System.out.printf("Existe o curso de Engenharia da Computa��o? %s\n", classe.containsValue(ec));

        //Metodo replace: substitui valor de uma chave para outro valor
        //classe.replace(wellington, ads);

        //Substitui um valor antigo para um valor novo
        //classe.replace(wellington, ec, null);
    }

}
