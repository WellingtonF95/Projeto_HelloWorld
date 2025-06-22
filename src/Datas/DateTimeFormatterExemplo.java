package Datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormatterExemplo {

    public static void main(String[] args) {

        // Usando DateTimeFormatter para constantes pré-definidas

        LocalDate data = LocalDate.now();
        LocalDateTime dataHora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        System.out.println(formatador.format(dataHora)); // chamando o proprio format do formatador
        System.out.println(DateTimeFormatter.ISO_DATE.format(data)); // usando a propria constante
        System.out.println(dataHora.format(DateTimeFormatter.BASIC_ISO_DATE)); // chamando o format no proprio objeto de data

        // Usando DateTimeFormatter para formatos de estilo localizados

        /*
         * Usa o formatador para formatar a dataHora de acordo com a hora configurada no SO
         * */
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT).format(dataHora));

        /*
         * Formata a dataHora para o formatador que exibe a data no formato FULL e a hora no formato SHORT
         * */
        System.out.println(dataHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT)));

        /*
         * Usa o formatador para formatar a dataHora no formato FULL passando um Locale personalizado com a linguagem ingles e com a sigla do país EUA
         * */
        System.out.println(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                        .withLocale(
                                new Locale("en", "US") // Formata com um Locale personalizado
                        )
                        .format(data)
        );

        /*
         *  Formata a data para usar o formatador definido no formato FULL passando um Locale personalizado com a lingua espanhola e com a sigla do país da Espanha
         * */

        System.out.println(
                dataHora.format(
                        DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                                .withLocale(
                                        new Locale("es","es")
                                )
                )
        );

        /*
        *  Usa o formatador para formatar a dataHora para um padrão personalizado
        * */

        System.out.println(DateTimeFormatter.ofPattern("d/M/yy 'ás' HH:mm:ss 'Horário de Brasilia'").format(dataHora)); // Formata com pattern (padrão) personalizado


        /*
        *  Formata a dataHora para usar o formatador para um padrão personalizado
        * */

        System.out.println(dataHora.format(DateTimeFormatter.ofPattern("'Hoje,' dd-MM-yyyy 'ás' HH:mm:ss', estou estudando Java'")));


    }
}
