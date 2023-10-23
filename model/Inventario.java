package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventario {
    private List<Produto> estoque;

    public Inventario() {
        estoque = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        estoque.add(produto);
    }

    public List<Produto> listarProdutos() {
        return estoque;
    }

    public void removerProduto(Produto produto) {
        estoque.remove(produto);
    }
}