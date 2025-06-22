package Datas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChronoUnitExemplo {

    public static void main(String[] args) {

        // Usando o enum ChronoUnit como parametro do metodo plus

        LocalDate agora = LocalDate.now();
        LocalDate dataVencimento = agora.plus(30, ChronoUnit.DAYS); // acresenta 30 dias a data atual

        System.out.printf("Data atual: %s\n", agora);
        System.out.printf("Data vencimento: %s\n", dataVencimento);

        // Usando o metodo addTo para adicionar 60 dias a data atual

        LocalDate proximaParcela = ChronoUnit.DAYS.addTo(agora, 60);
        System.out.printf("Próxima parcela: %s\n", proximaParcela);

        // Obtendo a data de uma década anterior
        LocalDate decadaAnterior = agora.minus(1, ChronoUnit.DECADES);
        System.out.printf("Decada Anterior :%s\n", decadaAnterior);

        // Obtendo a data de um século anterior
        LocalDate seculoAnterior = agora.minus(1, ChronoUnit.CENTURIES);
        System.out.printf("Século anterior: %s\n", seculoAnterior);


    }

}
