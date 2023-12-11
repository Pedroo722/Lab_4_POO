package br.edu.ifpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Inventario implements Serializable {
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

  public void setProdutos(List<Produto> produtos) {
    this.estoque = produtos;
  }

  public void removerProduto(Produto produto) {
    estoque.remove(produto);
  }
}