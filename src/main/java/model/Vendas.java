package model;

import java.util.List;
import java.util.ArrayList;

public class Vendas {
    private List<ItemVenda> vendas;

    public Vendas() {
      vendas = new ArrayList<>();
    }

    public void novaVenda(ItemVenda itemVenda) {
      vendas.add(itemVenda);
    }

    public List<ItemVenda> listarVendas() {
      return vendas;
    }
}