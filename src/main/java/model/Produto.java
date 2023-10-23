package model;

public class Produto {
  private String nome;
  private double preco;
  private int quantidade;


  // Construtor para Inventario
  public Produto(String nome, double preco, int quantidade) {
      this.nome = nome;
      this.preco = preco;
      this.quantidade = quantidade;
  }

  // Construtor para Vendas
  public Produto(String nome, double preco) {
      this.nome = nome;
      this.preco = preco;
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
}