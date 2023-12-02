package gui;

import gui.EstoqueWindow;
import gui.MainWindow;
import gui.VendaWindow;

public class ScreenManager {
    private MainWindow mainWindow;
    private EstoqueWindow estoqueWindow;
    private VendaWindow vendaWindow;
    private AdicionarProdutoWindow cadastroProdutoWindow;
    private EditarProdutoWindow editarProdutoWindow;

    public ScreenManager() {
        mainWindow = new MainWindow(this);
        estoqueWindow = new EstoqueWindow(this);
        vendaWindow = new VendaWindow(this);
        cadastroProdutoWindow = new AdicionarProdutoWindow(this);
        editarProdutoWindow = new EditarProdutoWindow(this);
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
    }

    public void showAdicionarProdutoWindow() {
        cadastroProdutoWindow.setVisible(true);
        mainWindow.setVisible(false);
        estoqueWindow.setVisible(false);
        editarProdutoWindow.setVisible(false);
    }

    public void showEditarProdutoWindow() {
        editarProdutoWindow.setVisible(true);
        mainWindow.setVisible(false);
        estoqueWindow.setVisible(false);
        cadastroProdutoWindow.setVisible(false);
    }

    // Telas de Venda

    public void showVendaWindow() {
        vendaWindow.setVisible(true);
        mainWindow.setVisible(false);
        estoqueWindow.setVisible(false);
    }
}
