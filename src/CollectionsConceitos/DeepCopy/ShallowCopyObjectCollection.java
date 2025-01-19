package CollectionsConceitos.DeepCopy;

import java.util.ArrayList;
import java.util.List;

public class ShallowCopyObjectCollection {

    public static void main(String[] args) {

        //Com objetos complexos - Utilizando c�pia superficial

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

        //C�pia Superficial - Collection
        //Para esse cen�rio, a referencia das listas e todas as referencias dos objetos tem o mesmo endere�o de mem�ria
        //Ao excluir um elemento de uma lista, todos os outros elementos da outra lista s�o excluidos tambem
        List<Estudante> salaSI = salaCC;

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
