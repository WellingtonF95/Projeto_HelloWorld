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
            throw new IllegalArgumentException("Quantidade de bagagens inv�lida");
        }

//        Optional<Reserva> reservaOpcional = servicoDeReserva.buscar(codigoReserva);

        // Lan�ando na mesma chamada a excess�o caso n�o encontre nenhuma reserva
        servicoDeReserva.buscar(codigoReserva)
                .orElseThrow(() -> new ReservaNaoEncontradaException("Reserva inexistente")) // lambda - Para retornar com uma mensagem
                //.orElseThrow(ReservaNaoEncontradaException::new) // method reference - Para retornar apenas a excess�o
                .adicionarBagagens(quantidadeBagagens);

        // Forma de tratamento de NPE caso nenhuma reservaOpcional for encontrada
//        if (reservaOpcional == null) {
//            throw new ReservaNaoEncontradaException("Reserva inexistente");
//        }

        // Tratamento com optional - Melhora a legibilidade, informando de que o metodo chamado pode retornar algo ou n�o
        // D� a possibilidade de realizar outras formas de tratamento, deixando o c�digo mais limpo

//        if (reservaOpcional.isPresent()) {
//            reservaOpcional.get().adicionarBagagens(quantidadeBagagens);
//        } else {
//            throw new ReservaNaoEncontradaException("Reserva inexistente");
//        }

    }

}
