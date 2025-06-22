package Datas;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MetodosConvenienciaExemplo {

    public static void main(String[] args) {
        // Alterando com metodos de conveniencia

        LocalDateTime agora = LocalDateTime.now();

        LocalDateTime horaAlterada = agora.withHour(2)
                .withMinute(30)
                .withSecond(1)
                .withNano(1);

        System.out.printf("Hora alterada: %s\n", horaAlterada);

        // Subtraindo a data original usando métodos de conveniencia

        LocalDate hoje = LocalDate.now();
        LocalDate semanaPassada = hoje.minusWeeks(1);
        System.out.printf("Hoje: %s\n", hoje);
        System.out.printf("Semana passada: %s\n", semanaPassada);

        // Adicionando a data original usando métodos de conveniencia
        LocalDate dataVencimento = hoje.plusDays(30);
        System.out.printf("Data compra: %s\n", hoje);
        System.out.printf("Data vencimento: %s\n", dataVencimento);



    }

}
