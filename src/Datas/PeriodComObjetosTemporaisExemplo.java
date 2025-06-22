package Datas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodComObjetosTemporaisExemplo {

    public static void main(String[] args) {

        // Descobrir quanto tempo passou (qual é o periodo) entre o primeiro dia do ano até a data atual

        LocalDate inicio = LocalDate.parse("2025-01-01");
        LocalDate fim = LocalDate.now();

        Period period = Period.between(inicio, fim);
        System.out.println("Usando o Period.between(): " + period);

        // Usando o metodo until na propria referencia do objeto inicio
        Period until = inicio.until(fim);
        System.out.println("Usando o metodo until(): " + until);

        // Usando a sobrecarga passando o dia atual e qual unidade de tempo desejada
        long numeroDeDiasPassados = inicio.until(fim, ChronoUnit.DAYS);
        System.out.printf("%d dias\n", numeroDeDiasPassados);

        long numeroDeSemanasPassadas = inicio.until(fim, ChronoUnit.WEEKS);
        System.out.printf("%d semanas\n", numeroDeSemanasPassadas);

        // Usando o between do enum ChronoUnit
        long between = ChronoUnit.DAYS.between(inicio, fim);
        System.out.println(between);

        LocalDate dataNascimento = LocalDate.parse("1995-04-17");
        System.out.printf("Concepção aproximada: %s\n", dataNascimento.minus(Period.ofMonths(9)));

        // Para LocalTime não é possível usar o Period
        LocalTime agora = LocalTime.now();
        Period ofDays = Period.ofDays(2);
        System.out.println(agora.plus(ofDays)); // UnsupportedTemporalTypeException

    }

}
