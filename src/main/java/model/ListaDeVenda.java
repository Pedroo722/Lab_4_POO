package model;

import java.util.List;
import java.util.ArrayList;

public class ListaDeVenda {
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
}