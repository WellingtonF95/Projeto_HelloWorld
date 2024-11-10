package Wrappers.Exercicio_Wrappers;

public class SomaComWrappers {

    public static void main(String[] args) {
        long tempoInicio = System.currentTimeMillis();

        Long soma = 0L;

        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            soma = soma + i;
        }

        System.out.println(soma);

        double duracao = (System.currentTimeMillis() - tempoInicio) / 1000d;
        System.out.printf("Duração: %.2fs", duracao);

    }
}
