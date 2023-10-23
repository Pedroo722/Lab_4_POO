package exceptions;

public class VendasVazioException extends RuntimeException {
    public VendasVazioException() {
        super("Nenhuma venda registrada.");
    }
}