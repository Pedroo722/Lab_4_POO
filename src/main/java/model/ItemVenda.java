package model;

import java.util.ArrayList;
import java.util.List;

public class ItemVenda {
    private List<Produto> produtos;

    public ItemVenda() {
      produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
      produtos.add(produto);
    }

    public List<Produto> getProdutos() {
      return produtos;
    }
}