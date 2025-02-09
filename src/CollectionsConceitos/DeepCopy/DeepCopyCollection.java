package CollectionsConceitos.DeepCopy;

import CollectionsConceitos.Model.Curso;
import CollectionsConceitos.Model.Estudante;

import java.util.ArrayList;
import java.util.List;

public class DeepCopyCollection {

    public static void main(String[] args) {

        Curso curso = new Curso();
        curso.setId(123);
        curso.setNome("Ciencia da Computa��o");

        Estudante estudanteCC = new Estudante(333,"Wellington", curso);

        Estudante estudanteSI = new Estudante(444, "Thais", curso);

        System.out.println("--Antes da c�pia--");
        System.out.printf("Estudante CC - getCurso() -> %s\n", estudanteCC.getCurso().hashCode());
        System.out.printf("Estudante SI - getCurso() -> %s\n", estudanteSI.getCurso().hashCode());

        List<Estudante> salaCC = new ArrayList<>();
        salaCC.add(estudanteCC);
        salaCC.add(estudanteSI);

        //Copia Profunda - Collection
        //Para esse cen�rio, as referencia das listas tem endere�os de memoria diferentes, mas a referencias dos objetos tem o mesmo endere�o de mem�ria
        //Ao excluir um elemento de uma lista, s� � excluido o elemento dessa lista e a outra permanece intacta
        //Mas, ao excluir objetos aninhados, pode ocorrer efeitos colaterais, uma vez que se o objeto aninhado possuir o mesmo endere�o de mem�ria de ambas as listas
        List<Estudante> salaSI = new ArrayList<>(salaCC);

        System.out.println("--Depois da c�pia--");
        System.out.printf("Sala CC - getCurso() -> %s\n", salaCC.get(0).getCurso().hashCode());
        System.out.printf("Sala SI - getCurso() -> %s\n", salaSI.get(0).getCurso().hashCode());

        salaSI.removeIf(estudante -> estudante.getCurso().equals(curso));

        System.out.printf("Sala CC -> %s\n", salaCC);
        System.out.printf("Sala SI -> %s\n", salaSI);
        System.out.println(salaCC.equals(salaSI));
        //Exception
        System.out.println(salaCC.get(0).getCurso().equals(salaSI.get(0).getCurso()));
    }

}
