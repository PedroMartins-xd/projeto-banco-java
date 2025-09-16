package exceptions;

public class SaldoNaoZeradoException extends RuntimeException {
    public SaldoNaoZeradoException(String message) {
        super(message);
    }
}
