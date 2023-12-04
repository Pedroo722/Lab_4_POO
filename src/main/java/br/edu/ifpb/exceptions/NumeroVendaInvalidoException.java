package br.edu.ifpb.exceptions;

public class NumeroVendaInvalidoException extends RuntimeException {
    public NumeroVendaInvalidoException() {
        super("Número da venda invalido.");
    }
}