package Optional.exception;

public class ReservaNaoEncontradaException extends RuntimeException {

    public ReservaNaoEncontradaException() {};

    public ReservaNaoEncontradaException(String message) {
        super(message);
    }
}
