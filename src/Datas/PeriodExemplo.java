package Datas;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class PeriodExemplo {

    public static void main(String[] args) {

        // Usando o Periodo que é uma implementação da interface TemporalAmount para obter um intervalo de tempo
        // Obtem um período de 7 dias - P7D
        Period ofDays = Period.ofDays(7);
        System.out.printf("Periodo de 7 dias: %s\n", ofDays);

        // Obtem um periodo de 3 meses - P3M
        Period ofMonths = Period.ofMonths(3);
        System.out.printf("Periodo de 3 meses: %s\n", ofMonths);

        // Obtem um período de 2 anos - P2Y
        Period ofYears = Period.ofYears(2);
        System.out.printf("Periodo de 2 anos: %s\n", ofYears);

        // Obtem um periodo de 5 anos, 10 meses e 4 dias
        Period ofPeriodo = Period.of(5, 10, 4);
        System.out.printf("Período de 5 anos, 10 meses e 4 dias: %s\n", ofPeriodo);

        // Convertendo uma string em um Period
        Period periodoCalculado = Period.parse("P3Y4M6D");
        System.out.printf("String convertida em periodo: %s\n", periodoCalculado);

        System.out.printf("%s ano(s), %s mes(es), %s dia(s)\n", periodoCalculado.getYears(), periodoCalculado.getMonths(), periodoCalculado.getDays());

        // O exemplo abaixo ele aplica apenas o periodo de 5 meses. O compilador adverte que tem algo de errado

        Period period = Period.ofYears(1).ofMonths(5);
        System.out.println(period); // 5 meses

        // E o mesmo que escrever isso:

        Period period2 = Period.ofYears(1);
        period2 = Period.ofDays(23);

        System.out.println(period2);


        LocalDate inicio = LocalDate.of(2025, Month.JANUARY, 1);
        LocalDate fim = LocalDate.of(2025, Month.MARCH, 30);

        semPeriodo(inicio, fim);
        comPeriodo(inicio, fim, Period.ofMonths(2));


    }

    private static void semPeriodo(LocalDate inicio, LocalDate fim) {
        LocalDate start = inicio;
        while (start.isBefore(fim)) {
            System.out.printf("Sem periodo = Adiciona um novo mês: %s\n", start);
            start = start.plusMonths(1);
        }
    }

    private static void comPeriodo(LocalDate inicio, LocalDate fim, Period periodo) {
        LocalDate start = inicio;
        while (start.isBefore(fim)) {
            System.out.printf("Com periodo = Adiciona um novo mês: %s\n", start);
            start = start.plus(periodo);
        }
    }
}
