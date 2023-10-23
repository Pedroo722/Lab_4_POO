package exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException() {
        super("O produto a ser editado não está cadastrado.");
    }
}