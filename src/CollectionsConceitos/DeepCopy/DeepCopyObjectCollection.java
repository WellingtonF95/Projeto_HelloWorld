package CollectionsConceitos.DeepCopy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import CollectionsConceitos.Model.Curso;
import CollectionsConceitos.Model.Estudante;
import org.apache.commons.lang3.SerializationUtils;

public class DeepCopyObjectCollection {

    public static void main(String[] args) {

        Curso curso = new Curso();
        curso.setId(123);
        curso.setNome("Ciencia da Computação");

        Estudante estudanteCC = new Estudante(333,"Wellington", curso);

        Estudante estudanteSI = new Estudante(444, "Thais", curso);

        System.out.println("--Antes da cópia--");
        System.out.printf("Estudante CC - getCurso() -> %s\n", estudanteCC.getCurso().hashCode());
        System.out.printf("Estudante SI - getCurso() -> %s\n", estudanteSI.getCurso().hashCode());

        List<Estudante> salaCC = new ArrayList<>();
        salaCC.add(estudanteCC);
        salaCC.add(estudanteSI);

        //Copia Profunda - Objetos da collection
        //Para esse cenário, as referencia das listas e dos objetos delas tem endereços de memoria diferentes
        //Ao excluir um elemento de uma lista, só é excluido o elemento dessa lista e a outra permanece intacta. Mesmo se for de objetos aninhados

        //Usando interface Cloneable
        //List<Estudante> salaSI =deepCopyUsingCloneableInterface(salaCC);

        //Utilizando uma nova instancia de curso ao invocar o construtor de Estudante
        //List<Estudante> salaSI = deepCopyUsingCopyConstructor(salaCC);

        //Utilizando bibliotecas externas - Apache SerializationUtils Obs.: As classes devem ter a interface Serializable implementada
        List<Estudante> salaSI = deepCopyUsingSerializationUtils(salaCC);

        System.out.println("--Depois da cópia--");
        System.out.printf("Sala CC - getCurso() -> %s\n", salaCC.get(0).getCurso().hashCode());
        System.out.printf("Sala SI - getCurso() -> %s\n", salaSI.get(0).getCurso().hashCode());

        salaSI.removeIf(estudante -> estudante.getCurso().equals(curso));

        System.out.printf("Sala CC -> %s\n", salaCC);
        System.out.printf("Sala SI -> %s\n", salaSI);
        System.out.println(salaCC.equals(salaSI));
        System.out.println(salaCC.get(0).getCurso().equals(salaSI.get(0).getCurso()));
    }

    public static List<Estudante> deepCopyUsingCloneableInterface(List<Estudante> salaCC) {
        Iterator<Estudante> salaIterator = salaCC.iterator();
        List<Estudante> salaSI = new ArrayList<>();

        while (salaIterator.hasNext()) {
            salaSI.add(salaIterator.next().clone());
        }
        return salaSI;
    }

    public static List<Estudante> deepCopyUsingCopyConstructor(List<Estudante> salaCC) {
        return salaCC.stream().map(Estudante::new).collect(Collectors.toList());
    }

    public static List<Estudante> deepCopyUsingSerializationUtils(List<Estudante> salaCC) {
        List<Estudante> salaSI = new ArrayList<>();
        salaCC.forEach(estudante -> salaSI.add(SerializationUtils.clone(estudante)));
        return salaSI;
    }

}
