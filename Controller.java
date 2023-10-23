import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Exceções


import exceptions.ProdutoNaoEncontradoException;
import exceptions.NumeroVendaInvalidoException;
import exceptions.EstoqueVazioException;
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
  public void cadastrarProduto(String nomeProduto, double precoProduto, int quantidadeProduto) {
    Produto novoProduto = new Produto(nomeProduto, precoProduto, quantidadeProduto);
    inventario.adicionarProduto(novoProduto);
  }

// Caso 2. Editar um produto no Estoque
  public void editarProduto(Scanner scanner) {
    if (inventario.listarProdutos().isEmpty()) {
      throw new EstoqueVazioException();
    }
    
    Scanner nomeScanner = new Scanner(System.in); // Scanner próprio para pegar os espaços em branco
    String produtoEditando = nomeScanner.nextLine();

    boolean produtoEncontrado = false;

    for (Produto produto : inventario.listarProdutos()) {
      if (produto.getNome().equalsIgnoreCase(produtoEditando)) {
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
        // mostrarProdutosCompradosJuntos(produtosVenda);
      }
    }
  }

    // Função para mostrar os produtos geralmente comprados juntos (TODO BUGADO)
  // private void mostrarProdutosCompradosJuntos(List<Produto> produtosVenda) {
  //   Map<String, Map<String, Integer>> produtosCompradosJuntos = new HashMap<>();

  //   for (int i = 0; i < produtosVenda.size(); i++) {
  //     Produto produtoA = produtosVenda.get(i);

  //     if (!produtosCompradosJuntos.containsKey(produtoA.getNome())) {
  //       produtosCompradosJuntos.put(produtoA.getNome(), new HashMap<>());
  //     }

  //     for (int j = 0; j < produtosVenda.size(); j++) {
  //       if (i != j) {
  //         Produto produtoB = produtosVenda.get(j);
  //         Map<String, Integer> produtosCompradosJuntosMap = produtosCompradosJuntos.get(produtoA.getNome());
  //         produtosCompradosJuntosMap.put(produtoB.getNome(),
  //           produtosCompradosJuntosMap.getOrDefault(produtoB.getNome(), 0) + 1);
  //       }
  //     }
  //   }

  //   for (String produto : produtosCompradosJuntos.keySet()) {
  //     System.out.println("Produtos geralmente comprados com " + produto + ":");
  //     Map<String, Integer> produtosCompradosJuntosMap = produtosCompradosJuntos.get(produto);

  //     // Ordene a lista de produtos comprados juntos
  //     List<Map.Entry<String, Integer>> produtosOrdenados = new ArrayList<>(produtosCompradosJuntosMap.entrySet());
  //     Collections.sort(produtosOrdenados, new Comparator<Map.Entry<String, Integer>>() {
  //       public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
  //         return entry2.getValue().compareTo(entry1.getValue());
  //       }
  //     });

  //     // Mostre os dois produtos mais vendidos juntos
  //     for (int k = 0; k < 2 && k < produtosOrdenados.size(); k++) {
  //         Map.Entry<String, Integer> entry = produtosOrdenados.get(k);
  //         String produtoCompradoJunto = entry.getKey();
  //         int quantidadeCompradaJunto = entry.getValue();
  //         System.out.println("  - Produto: " + produtoCompradoJunto + ", Quantidade: " + quantidadeCompradaJunto);
  //     }
  //     System.out.println();
  //   }
  // }

 // Caso 7. Apagar uma venda
  public void apagarVenda(int numeroVenda) {
    if (numeroVenda <= 0 || numeroVenda > vendas.listarVendas().size()) {
      throw new NumeroVendaInvalidoException();
    }

    ItemVenda vendaRemovida = vendas.listarVendas().remove(numeroVenda - 1);
    System.out.println("Venda #" + numeroVenda + " removida com sucesso.\n");
  }
}

