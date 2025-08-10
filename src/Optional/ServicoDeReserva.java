package Optional;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ServicoDeReserva {

    private final Set<Reserva> reservas = new HashSet<>();

    public Collection<Reserva> listarReservas() {
        return Collections.unmodifiableSet(reservas);
    }

    public void adicionar(Reserva reserva) {
        boolean foiAdicionada = reservas.add(reserva);

        if (!foiAdicionada) {
            throw new RuntimeException(String.format("Reserva %s j� existe", reserva.getCodigo()));
        }
    }

    // O optional (opcional) � um container (caixa) onde pode ou n�o ter uma instancia de uma reserva
    // Assim, ao inv�s de retornar um valor nulo, retorna um opcional onde d� a possibilidade de quem chamou o metodo
    // realizar o tratamento de forma legivel
    // Optional.ofNullable - Retorna um container de reserva. Caso n�o encontrado, retorna um container vazio
    // Optional.of - Retorna um container de reserva. Retorna NoSuchElementException se n�o tiver nada no container
    // Optional.empty - Retorna um container vazio
    public Optional<Reserva> buscar(String codigo) {

        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigo)) {
                return Optional.of(reserva); // Retorna um container contendo uma reserva ap�s a verifica��o
            }
        }
        return Optional.empty(); // retorna vazio se n�o tiver
        //return Optional.ofNullable(reservaEncontrada); // pode ter ou n�o ter
    }


}
