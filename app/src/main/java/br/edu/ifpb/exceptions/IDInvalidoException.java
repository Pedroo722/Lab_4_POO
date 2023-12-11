package br.edu.ifpb.exceptions;

public class IDInvalidoException extends RuntimeException {
    public IDInvalidoException() {
        super("Esse ID já está cadastrado!");
    }
}