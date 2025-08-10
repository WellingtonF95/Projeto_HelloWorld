package Optional;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import Optional.exception.ReservaNaoEncontradaException;

public class ServicoDeBagagem {

    private ServicoDeReserva servicoDeReserva;

    public ServicoDeBagagem(ServicoDeReserva servicoDeReserva) {
        Objects.requireNonNull(servicoDeReserva);
        this.servicoDeReserva = servicoDeReserva;
    }

    public void contratar(String codigoReserva, int quantidadeBagagens) {
        if (quantidadeBagagens <= 0) {
            throw new IllegalArgumentException("Quantidade de bagagens inválida");
        }

//        Optional<Reserva> reservaOpcional = servicoDeReserva.buscar(codigoReserva);

        // Lançando na mesma chamada a excessão caso não encontre nenhuma reserva
        servicoDeReserva.buscar(codigoReserva)
                .orElseThrow(() -> new ReservaNaoEncontradaException("Reserva inexistente")) // lambda - Para retornar com uma mensagem
                //.orElseThrow(ReservaNaoEncontradaException::new) // method reference - Para retornar apenas a excessão
                .adicionarBagagens(quantidadeBagagens);

        // Forma de tratamento de NPE caso nenhuma reservaOpcional for encontrada
//        if (reservaOpcional == null) {
//            throw new ReservaNaoEncontradaException("Reserva inexistente");
//        }

        // Tratamento com optional - Melhora a legibilidade, informando de que o metodo chamado pode retornar algo ou não
        // Dá a possibilidade de realizar outras formas de tratamento, deixando o código mais limpo

//        if (reservaOpcional.isPresent()) {
//            reservaOpcional.get().adicionarBagagens(quantidadeBagagens);
//        } else {
//            throw new ReservaNaoEncontradaException("Reserva inexistente");
//        }

    }

}
