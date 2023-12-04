package br.edu.ifpb.gui;

import br.edu.ifpb.gui.EstoqueWindow;
import br.edu.ifpb.gui.MainWindow;
import br.edu.ifpb.gui.VendaWindow;
import br.edu.ifpb.model.Produto;

public class ScreenManager {
    private MainWindow mainWindow;
    private EstoqueWindow estoqueWindow;
    private VendaWindow vendaWindow;
    private AdicionarProdutoWindow cadastroProdutoWindow;
    private EditarProdutoWindow editarProdutoWindow;
    private ExcluirProdutoWindow excluirProdutoWindow;
    private VendaCadastroWindow cadastroVendaWindow;
    private ApagarVendaWindow apagarVendaWindow;

    public ScreenManager() {
        mainWindow = new MainWindow(this);
        estoqueWindow = new EstoqueWindow(this);
        vendaWindow = new VendaWindow(this);
        cadastroProdutoWindow = new AdicionarProdutoWindow(this);
        editarProdutoWindow = new EditarProdutoWindow(this, null);
        excluirProdutoWindow = new ExcluirProdutoWindow(this);
        cadastroVendaWindow = new VendaCadastroWindow(this);
        apagarVendaWindow = new ApagarVendaWindow(this);
    }

    public void showMainWindow() {
        mainWindow.setVisible(true);
        estoqueWindow.setVisible(false);
        vendaWindow.setVisible(false);
    }

    // Telas de Estoque

    public void showEstoqueWindow() {
        estoqueWindow.setVisible(true);
        mainWindow.setVisible(false);
        vendaWindow.setVisible(false);
        cadastroProdutoWindow.setVisible(false);
        editarProdutoWindow.setVisible(false);
        excluirProdutoWindow.setVisible(false);
    }

    public void showAdicionarProdutoWindow() {
        cadastroProdutoWindow.setVisible(true);
        mainWindow.setVisible(false);
        estoqueWindow.setVisible(false);
        editarProdutoWindow.setVisible(false);
        excluirProdutoWindow.setVisible(false);
    }

    public void showEditarProdutoWindow(Produto p) {
        editarProdutoWindow = new EditarProdutoWindow(this, p);
        editarProdutoWindow.setVisible(true);
        mainWindow.setVisible(false);
        estoqueWindow.setVisible(false);
        cadastroProdutoWindow.setVisible(false);
        excluirProdutoWindow.setVisible(false);
    }

    public void showExcluirProdutoWindow() {
        excluirProdutoWindow.setVisible(true);
        mainWindow.setVisible(false);
        estoqueWindow.setVisible(false);
        cadastroProdutoWindow.setVisible(false);
        editarProdutoWindow.setVisible(false);
    }

    // Telas de Venda

    public void showVendaWindow() {
        vendaWindow.setVisible(true);
        mainWindow.setVisible(false);
        estoqueWindow.setVisible(false);
        cadastroVendaWindow.setVisible(false);
        apagarVendaWindow.setVisible(false);
    }

    public void showCadastroVendaWindow() {
        cadastroVendaWindow.setVisible(true);
        vendaWindow.setVisible(false);
        mainWindow.setVisible(false);
        estoqueWindow.setVisible(false);
        apagarVendaWindow.setVisible(false);
    }

    public void showApagarVendaWindow() {
        apagarVendaWindow.setVisible(true);
        vendaWindow.setVisible(false);
        mainWindow.setVisible(false);
        estoqueWindow.setVisible(false);
        cadastroVendaWindow.setVisible(false);
    }
}
