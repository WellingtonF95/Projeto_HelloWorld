package Datas;

import java.time.LocalDate;

public class LocalDateExemplo {

    public static void main(String[] args) {

        // LocalDate

        LocalDate localDate = LocalDate.now(); // data de hoje no formato ISO-8601: 2025-04-20
        System.out.println(localDate);

        localDate = LocalDate.of(2025, 4, 17); // data do dia 2025-04-17
        System.out.println(localDate);

        System.out.println(LocalDate.ofYearDay(2025, 256)); // dia 256 do ano de 2025



    }
}
