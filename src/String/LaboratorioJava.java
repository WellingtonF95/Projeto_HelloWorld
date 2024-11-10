package String;

public class LaboratorioJava {

    public static void main(String[] args) {

        //testa metodo contentEquals

        String key = "Laboratorio/Java";
        String java = "Laboratorio/Java";

        System.out.println(key.contentEquals(java));

        //testa metodo contains

        String key2 = "Laboratorio/Java";
        String java2 = "Java";

        System.out.println(key2.contains(java2));
        System.out.println(key2.substring(12, 16));
        System.out.println(java2.length());



    }
}
