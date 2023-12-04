package br.edu.ifpb.exceptions;

public class EstoqueVazioException extends RuntimeException {
    public EstoqueVazioException() {
        super("O estoque está vazio!");
    }
}