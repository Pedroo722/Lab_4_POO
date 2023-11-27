package gui;

import gerenciador.Controller;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstoqueWindow {
    private JFrame frame;
    private JTextArea textArea;
    private JFrame MainWindow; 

    public EstoqueWindow() {
        InitComponents();
    }

    public EstoqueWindow(JFrame MainWindow) {
        this.MainWindow = MainWindow;
        InitComponents();
    }

    private void InitComponents() {
        frame = new JFrame("Estoque");
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton adicionarButton = new JButton("Adicionar Produto");
        adicionarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openEstoqueScreen();
            }
        });

        JButton editarButton = new JButton("Editar Produto");
        editarButton.addActionListener(e -> {
            // edit prd
        });

        JButton excluirButton = new JButton("Excluir Produto");
        excluirButton.addActionListener(e -> {
            // del prod
        });

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MainWindow mainWindow = new MainWindow();
                mainWindow.show();
            }
        });

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(2, 2, 10, 10));
        panelButtons.setPreferredSize(new Dimension(400, 50));
        panelButtons.add(adicionarButton);
        panelButtons.add(editarButton);
        panelButtons.add(excluirButton);
        panelButtons.add(voltarButton);

        frame.setLayout(new BorderLayout());
        frame.add(panelButtons, BorderLayout.PAGE_START);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    private void openEstoqueScreen() {
        EstoqueCadastroWindow cadastroProdWindow = new EstoqueCadastroWindow();
        cadastroProdWindow.show();
    }

    public void show() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
