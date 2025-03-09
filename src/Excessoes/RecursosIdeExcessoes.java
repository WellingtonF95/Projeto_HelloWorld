package Excessoes;

public class RecursosIdeExcessoes {

    public static void main(String[] args) {

        int idade = 17;

        try {
            if (idade < 18) {
                throw new IllegalArgumentException("Idade não pode ser menor que 18");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
