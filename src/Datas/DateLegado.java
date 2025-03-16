package Datas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateLegado {

    public static void main(String[] args) {
        // API DATE LEGADA DO JAVA
        Date data = new Date(System.currentTimeMillis());

        System.out.println(data);
        System.out.println(data.getMonth());
        System.out.println(data.getYear());

        Date ontem = new Date(System.currentTimeMillis() - (24 * 60 * 60 * 60 * 1000));
        Date hoje = new Date();

        System.out.println(ontem.getTime());
        System.out.println(hoje.getTime());

        long diferencaMillis = hoje.getTime() - ontem.getTime();
        double diferencaHoras = diferencaMillis / 1000 / 60 / 60 / 60;

        System.out.println(diferencaMillis);
        System.out.printf("Diferença em horas: %.2f\n", diferencaHoras);

        System.out.printf("Depois: %b\n", hoje.after(ontem));
        System.out.printf("Antes: %b\n", hoje.before(ontem));

        System.out.printf("Comparação: %d\n", hoje.compareTo(ontem));

        // Convertendo String em Data

        Date domingo = new Date();

        // DateFormat format = DateFormat.getInstance();
        // DateFormat format = DateFormat.getDateInstance();
        // DateFormat format = DateFormat.getDateTimeInstance();
        //DateFormat format = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, new Locale("pt", "br"));

        DateFormat format = new SimpleDateFormat("d/MM/yyyy HH:mm:ss");

        System.out.println(format.format(domingo));


    }
}
