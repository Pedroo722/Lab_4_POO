package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private final JFrame frame;

    public MainWindow() {
        frame = new JFrame("Ponto de Venda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton estoqueButton = new JButton("Estoque");
        estoqueButton.setPreferredSize(new Dimension(100, 40));
        estoqueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openEstoqueScreen();
            }
        });

        JButton vendasButton = new JButton("Vendas");
        vendasButton.setPreferredSize(new Dimension(100, 40));
        vendasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openVendasScreen();
            }
        });

        buttonPanel.add(estoqueButton);
        buttonPanel.add(vendasButton);

        frame.add(buttonPanel);
    }

    private void openEstoqueScreen() {
      EstoqueWindow estoqueWindow = new EstoqueWindow();
        estoqueWindow.show();
    }

    private void openVendasScreen() {
      VendaWindow vendaWindow = new VendaWindow();
      vendaWindow.show();
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow main = new MainWindow();
                main.show();
            }
        });
    }
}
