package model;

public class Produto {
  private int identificador;
  private String nome;
  private double preco;
  private int quantidade;
  private int quantidadeVendida;

  // Construtor do Inventario
  public Produto(int identificador, String nome, double preco, int quantidade) {
      this.identificador = identificador;
      this.nome = nome;
      this.preco = preco;
      this.quantidade = quantidade;
  }

  // Construtor para Vendas
  public Produto(int identificador, String nome, double preco, int quantidade, int quantidadeVendida) {
      this.identificador = identificador;
      this.nome = nome;
      this.preco = preco;
      this.quantidade = quantidade;
      this.quantidadeVendida = quantidadeVendida;
  }

  public String getNome() {
      return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
      return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public int getIdentificador() {
    return identificador;
  }

  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }

  public int getQuantidadeVendida() {
    return quantidadeVendida;
  }

  public void setQuantidadeVendida(int quantidadeVendida) {
    this.quantidadeVendida = quantidadeVendida;
  }
}