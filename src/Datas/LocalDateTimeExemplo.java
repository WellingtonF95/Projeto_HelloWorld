package Datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeExemplo {

    public static void main(String[] args) {

        // LocalDateTime

        LocalDateTime localDateTime = LocalDateTime.now(); // a data e a hora atual em yyyy-MM-ddThh:mm:ss.nanoSegundos
        System.out.println(localDateTime);

        localDateTime = LocalDateTime.of(2025, 4, 21, 10, 15, 45); // formato ISO-8601
        System.out.println(localDateTime);

        // Instanciando um localDateTime a partir de um localDate e um localTime

        LocalDate data = LocalDate.of(2025,4,17);
        LocalTime hora = LocalTime.of(15, 50);

        System.out.println(LocalDateTime.of(data, hora));

        System.out.println(data.atTime(hora)); // instaciando um LocalDateTime usando atTime
        System.out.println(data.atTime(16, 15)); // adiciona o horario 16h15 para o dia 17/04
        System.out.println(hora.atDate(data)); // instaciando um LocalDateTime usando atDate

        // Extraindo um LocalDate a partir de um LocalDateTime

        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1.toLocalDate()); // toLocalDate
        System.out.println(LocalDate.from(localDateTime1)); // com LocalDate.from() passando um temporalAccessor

        // Extraindo um LocalTime a partir de um LocalDateTime
        System.out.println(localDateTime1.toLocalTime()); // toLocalTime
        System.out.println(LocalTime.from(localDateTime1)); // com LocalTime.from() passando um temporalAccessor


    }
}
