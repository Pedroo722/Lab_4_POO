package exceptions;

public class NumeroVendaInvalidoException extends RuntimeException {
    public NumeroVendaInvalidoException() {
        super("Nenhuma venda registrada.");
    }
}