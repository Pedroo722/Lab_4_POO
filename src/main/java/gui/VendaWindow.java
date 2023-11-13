package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class VendaWindow {
    private final JFrame frame;
    private JLabel Nome;

    public VendaWindow() {
        frame = new JFrame("Vendas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

      // Abre janela para adicionar uma venda
        JButton cadastrarVendaButton = new JButton("Cadastrar Venda");
        cadastrarVendaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
              JLabel labelNome = new JLabel("Nome: ");
              JTextField campoNome = new JTextField(18);
              campoNome.setSize(100, 20);
            }
        });

      // Abre janela para listar as vendas
        JButton listarVendasButton = new JButton("Listar Vendas");
        listarVendasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 
            }
        });

      // Abre janela para apagar
        JButton apagarVendaButton = new JButton("Apagar Venda");
        apagarVendaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 
            }
        });

      // Volta a tela inicial
        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.add(cadastrarVendaButton);
        buttonPanel.add(listarVendasButton);
        buttonPanel.add(apagarVendaButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel);
    }

    public void show() {
        frame.setVisible(true);
    }
  
}