package Datas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ConversorString {

    public static void main(String[] args) {

        // String para instant. Formata para o padrão ISO 8601
        System.out.println(Instant.parse("2025-04-17T15:50:00-00:00"));
        System.out.println(Instant.parse("2025-04-17T15:50:45Z"));

        // String para LocalDate. Formata para o padrão ISO 8601

        /*
        * O metodo parse faz a conversão da string para o LocalDate no formato ISO 8601.
        * O metodo parse possui uma sobrecarga que recebe um formatador para permitir a personalização da string recebida
        * para ser convertida em um LocalDate no padrão ISO 8601. O mesmo vale para LocalTime e LocalDateTime
        * */

        System.out.println(LocalDate.parse("2023-09-09"));
        String dataNascimentoThais = "08/06/2025";
        System.out.println(LocalDate.parse(dataNascimentoThais, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .format(DateTimeFormatter.ofPattern("dd~MM~yyyy"))
        );
        System.out.println(LocalDate.parse("03/31/25", DateTimeFormatter.ofPattern("MM/dd/yy")));

        // String para LocalTime.
        String horario = "23:09:00";
        System.out.println(LocalTime.parse(horario));
        System.out.println(LocalTime.parse("01:01:10", DateTimeFormatter.ofPattern("HH:mm:ss")));

        // String para LocalDateTime
        System.out.println(LocalDateTime.parse("2024-09-09T21:23"));
        System.out.println(LocalDateTime.parse("12/12/2024 23:59", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

    }
}
