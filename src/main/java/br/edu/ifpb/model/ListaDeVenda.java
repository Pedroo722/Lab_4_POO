package br.edu.ifpb.model;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class ListaDeVenda implements Serializable {
  private List<Venda> vendas;

  public ListaDeVenda() {
    vendas = new ArrayList<>();
  }

  public void novaVenda(Venda itemVenda) {
    vendas.add(itemVenda);
  }

  public List<Venda> listarVendas() {
    return vendas;
  }

  public void setVendas(List<Venda> vendas) {
    this.vendas = vendas;
  }
}