package model;

public class ProdutoVenda extends Produto {
  private int quantidadeVendida;

  public ProdutoVenda(Produto produto, int quantidadeVendida) {
    super(produto.getIdentificador(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
    this.quantidadeVendida = quantidadeVendida;
  }

  public int getQuantidadeVendida() {
    return quantidadeVendida;
  }

  public Produto getProduto() {
    return this;
  }
}
