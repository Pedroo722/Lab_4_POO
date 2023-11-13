package model;

import java.util.ArrayList;
import java.util.List;

public class ItemVenda {
  private List<Produto> produtos;

  public ItemVenda() {
    produtos = new ArrayList<>();
  }

  public void adicionarProduto(Produto produto, int quantidadeVendida) {
    produtos.add(new Produto(produto.getIdentificador(), produto.getNome(), produto.getPreco(), produto.getQuantidade(), quantidadeVendida));
  }

  public List<Produto> getProdutos() {
    return produtos;
  }
}