package Wrappers;


public class ClienteMain {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.idade = Integer.valueOf("10");
        cliente.nome = Character.valueOf('w');
        cliente.isPF = Boolean.valueOf("");
        cliente.aByte = Byte.valueOf("127");

        System.out.println(cliente.idade);
        System.out.println(cliente.nome);
        System.out.println("Byte: " + cliente.aByte);
        System.out.printf("%s", cliente.isPF);

    }
}