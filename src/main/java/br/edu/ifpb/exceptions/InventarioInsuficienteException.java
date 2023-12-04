package br.edu.ifpb.exceptions;

public class InventarioInsuficienteException extends RuntimeException {
    public InventarioInsuficienteException() {
        super("Quantidade insuficiente no estoque!");
    }
}