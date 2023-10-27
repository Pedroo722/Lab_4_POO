package model;

import java.util.ArrayList;
import java.util.List;

public class ItemVenda {
  private List<ProdutoVenda> produtos;

  public ItemVenda() {
    produtos = new ArrayList<>();
  }

  public void adicionarProduto(Produto produto, int quantidadeVendida) {
    produtos.add(new ProdutoVenda(produto, quantidadeVendida));
  }

  public List<ProdutoVenda> getProdutos() {
    return produtos;
  }
}