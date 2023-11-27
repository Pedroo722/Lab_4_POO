package gui; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstoqueCadastroWindow extends JFrame {

    private JTextField nomeTextField, valorTextField, quantidadeTextField;

    public EstoqueCadastroWindow() {
        super("Cadastro de Produto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Adiciona barras de entrada e rótulos
        panel.add(new JLabel("Nome:"));
        nomeTextField = new JTextField();
        panel.add(nomeTextField);

        panel.add(new JLabel("Valor:"));
        valorTextField = new JTextField();
        panel.add(valorTextField);

        panel.add(new JLabel("Quantidade:"));
        quantidadeTextField = new JTextField();
        panel.add(quantidadeTextField);

        // Adiciona botões
        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione a lógica para lidar com o botão "Voltar" aqui
            }
        });
        panel.add(voltarButton);

        JButton cadastrarButton = new JButton("Cadastrar Produto");
        cadastrarButton.setBackground(Color.GREEN);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione a lógica para lidar com o botão "Cadastrar Produto" aqui
            }
        });
        panel.add(cadastrarButton);

        // Adiciona o painel ao quadro
        add(panel);

        // Centraliza a janela
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EstoqueCadastroWindow().setVisible(true);
            }
        });
    }
}
