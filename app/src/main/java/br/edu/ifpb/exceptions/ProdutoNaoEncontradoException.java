package br.edu.ifpb.exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException() {
        super("Esse produto não está cadastrado.");
    }
}
