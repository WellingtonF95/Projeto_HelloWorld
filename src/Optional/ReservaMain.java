package Optional;

import java.util.Optional;
import java.util.OptionalInt;

public class ReservaMain {

    public static void main(String[] args) {

        ServicoDeReserva servicoDeReserva = new ServicoDeReserva();
        ServicoDeBagagem servicoDeBagagem = new ServicoDeBagagem(servicoDeReserva);
        Voo voo = new Voo("1234","GRU","UDI");

        servicoDeReserva.adicionar(new Reserva("1111", voo, "Wellington"));
        servicoDeReserva.adicionar(new Reserva("2222", voo, "Thais"));
        servicoDeReserva.adicionar(new Reserva("3333", voo, "Creuza"));

        servicoDeBagagem.contratar("1111", 3);

        // Metodo orElse - Se n�o houver uma reserva, retorna uma nova instacia de reserva
        //Reserva reserva = servicoDeReserva.buscar("222d").orElse(new Reserva("0000", null, "N�o informado"));

        // Metodo orElseGet - Se n�o houver uma reserva, retorna uma nova instancia de reserva usando a interface funcional Supplier
        // D� a possibilidade de abrir um bloco de codigo adicional
        /*Reserva reserva = servicoDeReserva.buscar("222j").orElseGet(() -> {
            Voo nenhumVoo = new Voo("0000", "N/I", "N/I");
            return new Reserva("0000", nenhumVoo, "N�o informado");
        });*/


        // Metodo ifPresent - Permite adicionar a quantidade de bagagens usando uma express�o lambda caso houver alguma reserva
        //servicoDeReserva.buscar("3333").ifPresent(reserva -> reserva.adicionarBagagens(10));

        // Metodo ifPresentOrElse - Permite adicionar a quantidade de bagagens usando uma express�o lambda caso houver alguma reserva
        // se n�o houver, executa uma outra instru��o do tipo Runnable (n�o � poss�vel lan�ar excess�o)
        /*servicoDeReserva.buscar("222f")
                .ifPresentOrElse(reserva -> reserva.adicionarBagagens(5),
                        () -> System.out.println("Reserva n�o encontrada"));*/

        // Metodo filter - Permite fazer uma verifica��o (um filtro) se a bagagem for maior que zero, passando um Predicate
        Reserva reserva = servicoDeReserva.buscar("1111")
                .filter(r -> r.getQuantidadeBagagens() > 0) // se true, retorna a reserva
                .orElseThrow(() -> new RuntimeException("Bagagem n�o encontrada"));// se false, lan�a uma excess�o

        // Metodo map - Permite fazer um mapeamento para retornar o passageiro da reserva pesquisada
        Passageiro passageiro = servicoDeReserva.buscar("1111")
                .filter(r -> r.getQuantidadeBagagens() > 0)
                .map(r -> r.getPassageiro())
                //.map(Reserva::getPassageiro) // Com method reference
                .orElseThrow(() -> new RuntimeException("Passageiro n�o encontrado"));

        Optional<Optional<Passageiro>> passageiro2 = servicoDeReserva.buscar("2222")
                .map(Reserva::getPassageiro2);

        // Metodo flatMap - Diante de varios opcionais, o flatMap busca o valor diretamente
        Passageiro passageiro1 = servicoDeReserva.buscar("1111")
                .filter(r -> r.getQuantidadeBagagens() > 0)
                .flatMap(r -> r.getPassageiro2())
                .orElseThrow(RuntimeException::new);

        System.out.println(reserva);
        System.out.println(passageiro1);

        //servicoDeReserva.listarReservas().forEach(System.out::println);

        // Optional com tipos primitivos
        OptionalInt optResultado = dividir(10, 0);

        optResultado.ifPresentOrElse(
                resultado -> System.out.println("Resultado: " + resultado),
                () -> System.out.println("Sem Resultado")
        );

    }

    private static OptionalInt dividir(int x, int y) {
        return y == 0 ? OptionalInt.empty() : OptionalInt.of(x / y);
    }

}
