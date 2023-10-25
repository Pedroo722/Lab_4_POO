package model;

public class Produto {
  private int identificador;
  private String nome;
  private double preco;
  private int quantidade;


  // Construtor para Inventario
  public Produto(String nome, double preco, int quantidade) {
      this.nome = nome;
      this.preco = preco;
      this.quantidade = quantidade;
  }

  public Produto(int identificador, String nome, double preco, int quantidade) {
      this.identificador = identificador;
      this.nome = nome;
      this.preco = preco;
      this.quantidade = quantidade;
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
  	return quantidade;
  }
  
  public void setIdentificador(int identificador) {
  	this.identificador = identificador;
  }
}