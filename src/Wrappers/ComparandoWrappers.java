package Wrappers;

public class ComparandoWrappers {

    public static void main(String[] args) {

        Integer v1 = 128;
        Integer v2 = 127;

        System.out.println(v1 == v2);

        System.out.println(v1.equals(v2));

        System.out.println(v1.compareTo(v2) == 1);
        //se retornar 0, os numeros são iguais
        //se retornar positivo, o primeiro numero é maior
        //se retornar negativo, o segundo numero é maior



    }
}
