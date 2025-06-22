package Datas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateLegado {

    public static void main(String[] args) throws ParseException {
        // API DATE LEGADA DO JAVA
        Date data = new Date(System.currentTimeMillis()); // Instacia a data atual formatada a partir do valor em milissegundos

        System.out.println(data);
        System.out.printf("getMes = %d\n", data.getMonth()); // Retorna o mes entre 0 e 11 sendo janeiro o numero 0
        System.out.printf("getAno = %d\n", data.getYear()); // Retorna o ano representado menos 1900. Ex.: 2025 - 1900 = 125

        Date ontem = new Date(System.currentTimeMillis() - (24 * 60 * 60 * 1000)); // (24 horas * 60 minutos * 60 segundos * 1000 milissegundos)
        Date hoje = new Date();

        System.out.println(ontem.getTime()); // Retorna o número de milissegundo desde o dia 01 de janeiro de 1970 em UTC até o dia anterior
        System.out.println(hoje.getTime()); // Retorna o número de milissegundos desde o dia 01 de janeiro de 1970 em UTC até a data atual

        long diferencaMillis = hoje.getTime() - ontem.getTime(); // Diferença do dia de hoje para o dia anterior em milissegundos
        double diferencaHoras = diferencaMillis / 1000 / 60 / 60; // (1 segundo / 1 minuto / 1 hora)

        System.out.println(diferencaMillis);
        System.out.printf("Diferença em horas: %.2fh\n", diferencaHoras);

        System.out.printf("O dia de hoje é maior que ontem? %b\n", hoje.after(ontem));
        System.out.printf("O dia de hoje é menor que ontem? %b\n", hoje.before(ontem));

        System.out.printf("Comparação: %d\n", hoje.compareTo(ontem));

        // Convertendo Date em String

        Date domingo = new Date();

        // DateFormat é um formatador de data. Ele formata datas e hora para string no formato de data e hora definido pela linguagem atual do SO

//         DateFormat format = DateFormat.getInstance(); // Formata a data para o formato dd/MM/yyyy hh:mm
//        DateFormat format = DateFormat.getTimeInstance(); // Formata a hora para o formato hh:mm:ss
//         DateFormat format = DateFormat.getDateInstance(); // Formata a data para o formato dia mes abreviado e ano
//         DateFormat format = DateFormat.getDateTimeInstance(); // Formata a data para o formato dia mes abreviado ano e horas:minutos:segundos
//        DateFormat format = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, new Locale("pt", "br"));
//
         // SimpleDateFormat é um formatador que herda DateFormat e que permite customizar o formato da data e hora passando a pattern desejado
        DateFormat formatUS = new SimpleDateFormat("d/M/yy hh:mm:ss a");
        DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println(formatBR.format(domingo));

        // Convertendo String em Date

        String sunday = "30/03/2025 15:08";

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Date sundayDate = dateFormat.parse(sunday);

        System.out.println(sundayDate);

        // Calendar
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        GregorianCalendar gregorianCalendar = new GregorianCalendar(
                1995, Calendar.APRIL, 17, 15, 49); // Passando uma data personalizada usando o Calendar

        Date birthDay = gregorianCalendar.getTime();

        Calendar calendar = Calendar.getInstance();
        Date calendarDateTime = calendar.getTime();
        System.out.println(simpleDateFormat.format(birthDay));

        // Explorando o Calendar
        // Obtendo valores de um calendar
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Scanner scan = new Scanner(System.in);

//        System.out.println("Digite a data de aniversário: ");
//        String inputDataNascimento = scan.nextLine();

//        Date dateNascimento = sdf.parse(inputDataNascimento); // Converte/formata a data informada para um date

//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.setTime(dateNascimento); // Seta o date convertido para tranformar o calendar na data informada

//        if (Calendar.DECEMBER == calendar1.get(Calendar.MONTH) && calendar1.get(Calendar.DAY_OF_MONTH) == 25) {
//            System.out.println("Você nasceu no natal!");
//        }

        // Operações com Calendar

        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar1 = Calendar.getInstance();

        int ultimoDiaMes = calendar1.getActualMaximum(Calendar.DAY_OF_MONTH); // obter o ultimo dia do mes atual

        System.out.println("Ultimo dia desse mes: " + ultimoDiaMes);

        calendar1.set(Calendar.DAY_OF_MONTH, 25); // seta o dia 25 na data obtida pelo sistema
        calendar1.set(Calendar.MONTH, Calendar.DECEMBER); // seta o mes para dezembro na data obtida pelo sistema
        calendar1.add(Calendar.MONTH, 1); // muda para o mes seguinte (numero positivo) e muda para o mes anterior (numero negativo)

        System.out.println(dateFormat1.format(calendar1.getTime())); //25/01/2025
    }
}
