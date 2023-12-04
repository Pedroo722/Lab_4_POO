package br.edu.ifpb.gerenciador;

import java.util.List;

import br.edu.ifpb.exceptions.EstoqueVazioException;
import br.edu.ifpb.exceptions.IDInvalidoException;
import br.edu.ifpb.exceptions.InventarioInsuficienteException;
import br.edu.ifpb.exceptions.NumeroVendaInvalidoException;
import br.edu.ifpb.exceptions.ProdutoNaoEncontradoException;
import br.edu.ifpb.exceptions.VendasVazioException;

import java.util.ArrayList;

// Classes

import br.edu.ifpb.model.ListaDeVenda;
import br.edu.ifpb.model.Produto;
import br.edu.ifpb.model.Venda;
import br.edu.ifpb.model.Inventario;

// Classe Principalf

public class Controller {
  private static Controller instance;
  private Inventario inventario;
  private Venda itemVenda;
  private ListaDeVenda vendas;

  public Controller() {
    inventario = new Inventario();
    itemVenda = new Venda();
    vendas = new ListaDeVenda();
  }

  public static Controller getInstance() {
    if (instance == null) {
      instance = new Controller();
    }
    return instance;
  }

  // Caso 1. Cadastrar produto no Estoque
  public void cadastrarProduto(Integer identificadorProduto, String nomeProduto, double precoProduto, int quantidadeProduto) {
    for (Produto produto : inventario.listarProdutos()) {
      if (identificadorProduto.equals(produto.getIdentificador())) {
        throw new IDInvalidoException();
      }
    }

    Produto novoProduto = new Produto(identificadorProduto, nomeProduto, precoProduto, quantidadeProduto);
    inventario.adicionarProduto(novoProduto);
  }

  // Caso 2. Editar um produto no Estoque
  public void editarProduto(Integer produtoEditando, String novoNomeProduto, Double novoPrecoProduto, int novaQuantidadeProduto) {
    if (inventario.listarProdutos().isEmpty()) {
      throw new EstoqueVazioException();
    }

    boolean produtoEncontrado = false;

    for (Produto produto : inventario.listarProdutos()) {
      if (produtoEditando.equals(produto.getIdentificador())) {

        produto.setNome(novoNomeProduto);
        produto.setPreco(novoPrecoProduto);
        produto.setQuantidade(novaQuantidadeProduto);

        produtoEncontrado = true;
        break;
      }
    }

    if (!produtoEncontrado) {
      throw new ProdutoNaoEncontradoException();
    }
  }

  // Caso 3. Listar os produtos do Estoque
  public List<Produto> listarProdutos() {
    List<Produto> produtosNoEstoque = inventario.listarProdutos();

    if (produtosNoEstoque.isEmpty()) {
      throw new EstoqueVazioException();
    }

    return produtosNoEstoque;
  }

  // Caso 4. Remover um produto especifico do Estoque
  public void removerProduto(Integer idProdutoRemover) {
    List<Produto> produtos = inventario.listarProdutos();
    boolean produtoEncontrado = false;

    for (Produto produto : produtos) {
      if (idProdutoRemover.equals(produto.getIdentificador())) {
        inventario.removerProduto(produto);
        produtoEncontrado = true;
        break;
      }
    }

    if (!produtoEncontrado) {
      throw new ProdutoNaoEncontradoException();
    }
  }

  // Caso 5. Cadastrar uma venda
  public void adicionarItemVenda(List<Integer> identificadoresProdutos, List<Integer> quantidadesVendidas) {
    Venda novaVenda = new Venda();

    for (int i = 0; i < identificadoresProdutos.size(); i++) {
        int identificadorProduto = identificadoresProdutos.get(i);
        int quantidadeVendida = quantidadesVendidas.get(i);

        Produto produto = buscarProdutoPorIdentificador(identificadorProduto);

        if (produto != null) {
            if (quantidadeVendida <= produto.getQuantidade()) {
                novaVenda.adicionarProduto(produto, quantidadeVendida);
                produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
            } else {
                throw new InventarioInsuficienteException();
            }
        } else {
            throw new ProdutoNaoEncontradoException();
        }
    }

    vendas.novaVenda(novaVenda);
  }

  public Produto buscarProdutoPorIdentificador(int identificadorProduto) {
    for (Produto produto : inventario.listarProdutos()) {
      if (identificadorProduto == produto.getIdentificador()) {
        return produto;
      }
    }
    return null;
  }

  // Caso 6. Listar as vendas atuais
  public List<Venda> relatorioVendas() {
    List<Venda> vendas = this.vendas.listarVendas();

    if (vendas.isEmpty()) {
      throw new VendasVazioException();
    } else {
      return vendas;
    }
  }

  // Caso 7. Apagar uma venda
  public void apagarVenda(int numeroVenda) {
    if (numeroVenda <= 0 || numeroVenda > vendas.listarVendas().size()) {
      throw new NumeroVendaInvalidoException();
    }

    Venda vendaRemovida = vendas.listarVendas().remove(numeroVenda - 1);
  }

  // Função para retornar nome do produto
  public String obterNome(int idProduto) {
    for (Produto produto : inventario.listarProdutos()) {
        if (idProduto == produto.getIdentificador()) {
            return produto.getNome();
        }
    }
    return "Não encontrado";
  }


  public void inicializarProdutos() {
    cadastrarProduto(122, "Bola", 10.0, 50);
    cadastrarProduto(279, "Carregador", 15.0, 30);
    cadastrarProduto(497, "Alicate", 20.0, 40);

  }
}