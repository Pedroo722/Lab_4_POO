package model;

public class ProdutoVenda {
  private Produto produto;
  private int quantidadeVendida;

  public ProdutoVenda(Produto produto, int quantidadeVendida) {
    this.produto = produto;
    this.quantidadeVendida = quantidadeVendida;
  }

  public Produto getProduto() {
    return produto;
  }

  public int getQuantidadeVendida() {
    return quantidadeVendida;
  }
}