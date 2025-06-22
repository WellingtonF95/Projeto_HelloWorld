package Datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class ChronoFieldExemplo {


    public static void main(String[] args) {

        /*Usando o metodo getFrom do enum ChronoField para obter um valor (long) de um objeto temporal (LocalDate)
        * */

        LocalDate dia = LocalDate.parse("2025-05-25");
        System.out.printf("Dia do mês: %d\n", ChronoField.DAY_OF_MONTH.getFrom(dia));
        System.out.printf("Número do mês: %d\n", ChronoField.MONTH_OF_YEAR.getFrom(dia));
        System.out.printf("Ano: %d\n", ChronoField.YEAR.getFrom(dia));

        /*Usando o metodo get do LocalDate passando o enum ChronoField para obter um valor (int) de um objeto temporal*/

        LocalDate ontem = LocalDate.parse("2025-05-24");
        System.out.printf("Dia do mês: %d\n", ontem.get(ChronoField.DAY_OF_MONTH));
        System.out.printf("Número do mês: %d\n", ontem.get(ChronoField.MONTH_OF_YEAR));
        System.out.printf("Ano: %d\n", ontem.get(ChronoField.YEAR));

        // Usando metodos que já obtem o valor do objeto temporal (LocalDate) - mais simples

        System.out.printf("Obtendo o dia do mês: %d\n", LocalDate.now().getDayOfMonth());
        System.out.printf("Obtendo o mês do ano: %d\n", LocalDate.now().getMonthValue());
        System.out.printf("Obtendo o ano: %d\n", LocalDate.now().getYear());

        // LocalDateTime

        System.out.printf("Obtendo a hora: %d\n", LocalDateTime.now().getHour());
        System.out.printf("Obtendo o minuto: %d\n", LocalDateTime.now().getMinute());
        System.out.printf("Obtendo o segundo: %d\n", LocalDateTime.now().getSecond());

        // Alterando elementos de um objeto temporal (localDateTime) com o metodo with. A alteração só funciona se houver
        // a atribuição a uma nova variavel, porque instancias de LocalDate por exemplo são imutáveis e o metodo with
        // faz a cópia do objeto temporal original e devolve um novo objeto temporal.

        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime dataAlterada = agora.with(ChronoField.DAY_OF_MONTH, 1);
        System.out.printf("Data alterada: %s\n", dataAlterada);

        // Alterando com metodos de conveniencia

        LocalDateTime horaAlterada = agora.withHour(2)
                .withMinute(30)
                .withSecond(1)
                .withNano(1);

        System.out.printf("Hora alterada: %s\n", horaAlterada);


    }

}
