package Datas;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class InstanteExemplo {

    public static void main(String[] args) {

        Instant instante = Instant.now();

        System.out.println(instante);
        System.out.println(instante.getEpochSecond()); // numero de segundos desde 01 de janeiro de 1970
        System.out.println(System.currentTimeMillis());
        System.out.println(instante.getNano());

        // Convertendo um instant para um date legado
        Date date = Date.from(instante);
        System.out.println(date);

        // Convertendo um date legado para um instant
        Instant instant = date.toInstant();
        System.out.println(instant);

        // Convertendo um calendar legado para um instant
        Calendar calendar = Calendar.getInstance();
        instant = calendar.toInstant();
        System.out.println(instant);

    }

}
