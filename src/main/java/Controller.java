import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// Exceções

import exceptions.ProdutoNaoEncontradoException;
import exceptions.NumeroVendaInvalidoException;
import exceptions.EstoqueVazioException;
import exceptions.IDInvalidoException;
import exceptions.VendasVazioException;

// Classes

import model.Vendas;
import model.Produto;
import model.ItemVenda;
import model.Inventario;

// Classe Principal

public class Controller {
  private Inventario inventario;
  private ItemVenda itemVenda;
  private Vendas vendas;

  public Controller() {
    inventario = new Inventario();
    itemVenda = new ItemVenda();
    vendas = new Vendas();
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
  public void editarProduto(Scanner scanner) {
    if (inventario.listarProdutos().isEmpty()) {
      throw new EstoqueVazioException();
    }
    
    Scanner nomeScanner = new Scanner(System.in); // Scanner próprio para pegar os espaços em branco
    Integer produtoEditando = scanner.nextInt();

    boolean produtoEncontrado = false;

    for (Produto produto : inventario.listarProdutos()) {
      if (produtoEditando.equals(produto.getIdentificador())) {
        System.out.println("\nInforme o novo nome do produto:");
        String novoNomeProduto = nomeScanner.nextLine();
        System.out.println("Informe o novo preço do produto:");
        double novoPrecoProduto = scanner.nextDouble();
        System.out.println("Informe a nova quantidade do produto:");
        int novaQuantidadeProduto = scanner.nextInt();

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
  public void removerProduto(String nomeProdutoRemover) {
      List<Produto> produtos = inventario.listarProdutos();
      boolean produtoEncontrado = false;

      for (Produto produto : produtos) {
          if (produto.getNome().equalsIgnoreCase(nomeProdutoRemover)) {
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
  public void adicionarItemVenda(int quantidadeDaVenda, Scanner scanner, Scanner nomeScanner) {
    ItemVenda novaVenda = new ItemVenda(); // Cria uma nova instância de ItemVenda, para cada venda cadastrada

    for (int i = 0; i < quantidadeDaVenda; i++) {
      System.out.println("\nInforme o nome do produto:");
      String nomeItem = nomeScanner.nextLine();
      System.out.println("Informe o preço do produto:");
      double precoItem = scanner.nextDouble();
      System.out.println("Informe a quantidade do produto a ser vendido:");
      int quantidadeItem = scanner.nextInt();

      Produto itemDaVenda = new Produto(nomeItem, precoItem, quantidadeItem);
      novaVenda.adicionarProduto(itemDaVenda);
    }

    vendas.novaVenda(novaVenda);
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
          System.out.println("* Quantidade Vendida: " + produto.getQuantidade());
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

