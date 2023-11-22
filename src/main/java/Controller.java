import java.util.List;
import java.util.ArrayList;

// Exceções

import exceptions.ProdutoNaoEncontradoException;
import exceptions.NumeroVendaInvalidoException;
import exceptions.InventarioInsuficienteException;
import exceptions.EstoqueVazioException;
import exceptions.IDInvalidoException;
import exceptions.VendasVazioException;

// Classes

import model.Venda;
import model.Produto;
import model.ItemVenda;
import model.Inventario;

// Classe Principalf

public class Controller {
  private Inventario inventario;
  private ItemVenda itemVenda;
  private Venda vendas;

  public Controller() {
    inventario = new Inventario();
    itemVenda = new ItemVenda();
    vendas = new Venda();
  }


// Serialização

  

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
  public void listarProdutos() {
    List<Produto> produtosNoEstoque = inventario.listarProdutos();

    if (produtosNoEstoque.isEmpty()) {
      throw new EstoqueVazioException();
    }

    List<Produto> produtosBaixaQuantidade = new ArrayList<>();

    for (int i = 0; i < produtosNoEstoque.size(); i++) {
      Produto produto = produtosNoEstoque.get(i);
      System.out.println("Produto #" + (i + 1));
      System.out.println("ID: " + produto.getIdentificador());
      System.out.println("Nome: " + produto.getNome());
      System.out.println("Preço: " + produto.getPreco());
      System.out.println("Quantidade Atual: " + produto.getQuantidade());
      System.out.println();

      if (produto.getQuantidade() < 5) {
        produtosBaixaQuantidade.add(produto);
      }
    }

    if (!produtosBaixaQuantidade.isEmpty()) {
      System.out.println("[ALERTA] Produtos em baixa quantidade:");
      for (Produto produto : produtosBaixaQuantidade) {
        System.out.print("* ");
        System.out.println(produto.getNome());
      }
    }
    System.out.println();

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
    ItemVenda novaVenda = new ItemVenda();

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
  public void relatorioVendas() {
    List<ItemVenda> vendas = this.vendas.listarVendas();

    if (vendas.isEmpty()) {
      throw new VendasVazioException();
    } else {
      for (int i = 0; i < vendas.size(); i++) {
        ItemVenda venda = vendas.get(i);
        System.out.println("Venda #" + (i + 1));

        List<Produto> produtosVenda = venda.getProdutos();
        for (Produto produto : produtosVenda) {
          System.out.println("* Nome do Produto: " + produto.getNome());
          System.out.println("* Preço: " + produto.getPreco());
          System.out.println("* Quantidade Vendida: " + produto.getQuantidadeVendida());
          System.out.println();
        }
      }
    }
  }

 // Caso 7. Apagar uma venda
  public void apagarVenda(int numeroVenda) {
    if (numeroVenda <= 0 || numeroVenda > vendas.listarVendas().size()) {
      throw new NumeroVendaInvalidoException();
    }

    ItemVenda vendaRemovida = vendas.listarVendas().remove(numeroVenda - 1);
    System.out.println("Venda #" + numeroVenda + " removida com sucesso.\n");
  }
}