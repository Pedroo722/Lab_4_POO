package model;

import java.util.ArrayList;
import java.util.List;

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