import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.EstoqueVazioException;
import exceptions.IDInvalidoException;
import exceptions.InventarioInsuficienteException;
import exceptions.NumeroVendaInvalidoException;
import exceptions.ProdutoNaoEncontradoException;
import exceptions.VendasVazioException;

import validators.DoubleValidator;
import validators.IntValidator;
import validators.StringValidator;

public class Main {
  public static void main(String[] args) {
    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);
    Scanner nomeScanner = new Scanner(System.in); // scanner para pegar a linha inteira
    boolean processamento = true; // flag para o loop

    System.out.println("Bem-vindo ao Ponto de Venda do Jeremias!");
    System.out.println("O que deseja fazer?\n");

    while (processamento) {
      System.out.println("== Menu ==");
      System.out.println("Selecione uma opção: ");
      System.out.println("1 - Operações no inventário");
      System.out.println("2 - Operações de Vendas");
      System.out.println("3 - Sair\n");
      System.out.print("Opção: ");
      int opcao = scanner.nextInt();
      System.out.println();

      switch (opcao) {
       // Operações no Inventario    
        case 1:
          System.out.println("Operações no Inventario");
          System.out.println("1 - Cadastrar um produto no estoque");
          System.out.println("2 - Editar um produto no estoque");
          System.out.println("3 - Listar os produtos no estoque");
          System.out.println("4 - Remover um produto do estoque");
          System.out.println("5 - Voltar ao Menu");

          System.out.print("\nOpção: ");
          int opcaoInventario = scanner.nextInt();

          // Switch de Inventario
          switch (opcaoInventario) {
           // Adicionar ao Estoque 
            case 1:
              System.out.println();
              System.out.println("Informe o ID do produto:");
              int identificadorProduto = scanner.nextInt();
              System.out.println("Informe o nome do produto:");
              String nomeProduto = nomeScanner.nextLine();
              System.out.println("Informe o preço do produto:");
              double precoProduto = scanner.nextDouble();
              System.out.println("Informe a quantidade do produto a ser adicionada no estoque:");
              Integer quantidadeProduto = scanner.nextInt();

              // Validar os dados usando os Validators
              boolean isIdValid = new IntValidator().validate(identificadorProduto);
              boolean isNomeValid = new StringValidator().validate(nomeProduto);
              boolean isPrecoValid = new DoubleValidator().validate(precoProduto);
              boolean isQuantidadeValid = new IntValidator().validate(quantidadeProduto);

              if (isIdValid && isNomeValid && isPrecoValid && isQuantidadeValid) {
                  try {
                      controller.cadastrarProduto(identificadorProduto, nomeProduto, precoProduto, quantidadeProduto);
                      System.out.println("\nProduto adicionado ao estoque.\n");
                  } catch (IDInvalidoException ex) {
                      System.out.println("\n[ALERTA] Operação Falha. Esse ID já está cadastrado!\n");
                  }
              } else {
                  System.out.println("\n[ALERTA] Dados do produto inválidos. Por favor, verifique as informações e tente novamente.\n");
              }
              break;

           // Editar no Estoque
            case 2:
              System.out.println("\nInforme o ID do produto a ser editado:");
              Integer produtoEditando = scanner.nextInt();
              scanner.nextLine();

              System.out.println("\nInforme o novo nome do produto:");
              String novoNomeProduto = scanner.nextLine();
              System.out.println("Informe o novo preço do produto:");
              double novoPrecoProduto = scanner.nextDouble();
              System.out.println("Informe a nova quantidade do produto:");
              int novaQuantidadeProduto = scanner.nextInt();

              try {
                controller.editarProduto(produtoEditando, novoNomeProduto, novoPrecoProduto, novaQuantidadeProduto);
              } catch (ProdutoNaoEncontradoException ex) {
                System.out.println("\n[ALERTA] Operação Falha. Produto não encontrado!\n");
                break;
              } catch (EstoqueVazioException ex) {
                System.out.println("\n[ALERTA] Operação Falha. O estoque está vazio!\n");
                break;
              }

              System.out.println("\nProduto editado com sucesso\n");
              break;

           // Listar os produtos no estoque
            case 3:
              System.out.println();

              try {
                controller.listarProdutos();
              } catch (EstoqueVazioException ex) {
                System.out.println("\n[ALERTA] Operação Falha. O estoque está vazio!\n");
                break;
              }

              break;

           // Remover do Estoque
            case 4:
              System.out.println("\nInforme o ID do produto a ser removido:");
              Integer idProdutoRemover = scanner.nextInt();
              try {
                controller.removerProduto(idProdutoRemover);
              } catch (ProdutoNaoEncontradoException ex) {
                System.out.println("\n[ALERTA] Produto não encontrado.\n");
                break;
              }
              System.out.println("Produto removido com sucesso.\n");
              break;

           // Voltar ao menu principal
            case 5:
              break;

            default:
              System.out.println("Opção inválida. Tente novamente.");
          }
          break;

       // Operações de Vendas
        case 2:
          System.out.println("Operações de Vendas");
          System.out.println("1 - Cadastrar uma venda");
          System.out.println("2 - Listar as vendas atuais");
          System.out.println("3 - Apagar uma venda");
          System.out.println("4 - Voltar ao Menu");

          System.out.print("\nOpção: ");
          int opcaoVendas = scanner.nextInt();

          // Switch de Vendas
          switch (opcaoVendas) {
           // Cadastrar uma venda
            case 1:
              System.out.println("\nQuantos produtos diferentes a venda terá?");
              int quantidadeDaVenda = scanner.nextInt();

              List<Integer> identificadoresProdutos = new ArrayList<>();
              List<Integer> quantidadesVendidas = new ArrayList();

              for (int i = 0; i < quantidadeDaVenda; i++) {
                  System.out.println("\nInforme o identificador do produto #" + (i + 1) + ":");
                  int identificadorProduto = scanner.nextInt();
                  identificadoresProdutos.add(identificadorProduto);
                  System.out.println("Informe a quantidade a ser vendida do produto #" + (i + 1) + ":");
                  int quantidadeVendida = scanner.nextInt();
                  quantidadesVendidas.add(quantidadeVendida);
              }
              try {
                controller.adicionarItemVenda(identificadoresProdutos, quantidadesVendidas);
              } catch (InventarioInsuficienteException ex) {
                System.out.println("\n[ALERTA] Quantidade insuficiente no estoque!");
                break;
              } catch (ProdutoNaoEncontradoException ex) {
                System.out.println("\n[ALERTA] Produto não encontrado no estoque!");
                break;
              }

              System.out.println("\nVenda cadastrada!\n");
              break;

           // Listar as vendas cadastradas
            case 2:
              System.out.println();
              try {
                controller.relatorioVendas();
              } catch (VendasVazioException ex) {
                System.out.println("\n[ALERTA] Nenhuma venda cadastrada!\n");
                break;
              }
              break;

           // Apagar uma venda
            case 3:
              System.out.print("\nInforme o número da venda a ser apagada: ");
              int numeroVendaApagar = scanner.nextInt();
              try {
                controller.apagarVenda(numeroVendaApagar);
              } catch (NumeroVendaInvalidoException ex) {
                System.out.println("\n[ALERTA] Operação Falha. Número da venda não encontrado\n");
              }
              break;

           // Voltar ao menu principal
            case 4:
              break;

            default:
              System.out.println("Opção inválida. Tente novamente.");
          }
          break;

       // Encerrar o Processamento
        case 3:
          System.out.println("Sistema encerrado.");
          processamento = false;
          break;

        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    }
  }
}