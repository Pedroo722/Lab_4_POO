package br.edu.ifpb.gui; 

import java.util.Random;

import br.edu.ifpb.validators.DoubleValidator;
import br.edu.ifpb.validators.IntValidator;
import br.edu.ifpb.validators.StringValidator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.ifpb.exceptions.IDInvalidoException;
import br.edu.ifpb.gerenciador.Controller;

public class AdicionarProdutoWindow extends javax.swing.JFrame {

    private JLabel jLabelAdicionarProduto;
    private JLabel jLabelNome;
    private JLabel jLabelValor;
    private JLabel jLabelQuantidade;
    private JButton jButtonVoltar;
    private JButton jButtonCadastrar;
    private JTextField jTextFieldNome;
    private JTextField jTextFieldValor;
    private JTextField jTextFieldQuantidade;
    private ScreenManager screenManager;
    private Controller controller;

    public AdicionarProdutoWindow(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.controller = Controller.getInstance();
        initComponents();

        setLocationRelativeTo(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                controller.salvarProdutos();
                controller.salvarVendas();
            }
        });
    }

    private void initComponents() {
        jLabelAdicionarProduto = new JLabel();
        jLabelNome = new JLabel();
        jLabelValor = new JLabel();
        jLabelQuantidade = new JLabel();
        jButtonVoltar = new JButton();
        jButtonCadastrar = new JButton();
        jTextFieldNome = new JTextField();
        jTextFieldValor = new JTextField();
        jTextFieldQuantidade = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(869, 570));
        setMinimumSize(new java.awt.Dimension(869, 570));
        setPreferredSize(new java.awt.Dimension(869, 570));
        setResizable(false);

        jLabelAdicionarProduto.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelAdicionarProduto.setText("Adicionar Produto");

        jLabelNome.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelNome.setText("Nome:");

        jLabelValor.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelValor.setText("Valor:");

        jLabelQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelQuantidade.setText("Quantidade:");

        jButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonCadastrar.setBackground(new java.awt.Color(102, 255, 102));
        jButtonCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonCadastrar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jTextFieldNome.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldValor.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldQuantidade.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVoltar)
                        .addGap(222, 222, 222)
                        .addComponent(jButtonCadastrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelQuantidade)
                                .addComponent(jLabelNome)
                                .addComponent(jLabelValor))
                            .addGap(72, 72, 72)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addComponent(jTextFieldValor)
                                .addComponent(jTextFieldQuantidade)))))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValor)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidade)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Random rand = new Random(); 
            int upperbound = 1000; // ID entre 1 e 999
            int ID = rand.nextInt(upperbound);

            String nome = jTextFieldNome.getText();
            double valor = Double.parseDouble(jTextFieldValor.getText());
            int quantidade = Integer.parseInt(jTextFieldQuantidade.getText());

            boolean isNomeValid = new StringValidator().validate(nome);
            boolean isPrecoValid = new DoubleValidator().validate(valor);
            boolean isQuantidadeValid = new IntValidator().validate(quantidade);

            if (isNomeValid && isPrecoValid && isQuantidadeValid) {
                controller.cadastrarProduto(ID, nome, valor, quantidade);
            }

            jTextFieldNome.setText("");
            jTextFieldValor.setText("");
            jTextFieldQuantidade.setText("");
        } catch (IDInvalidoException ex) {
            JOptionPane.showMessageDialog(this, "Operação falha. Esse ID já está cadastrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Operação falha. O valor e a quantidade devem ser números válidos.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        screenManager.showEstoqueWindow();
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdicionarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        ScreenManager screenManager = new ScreenManager();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarProdutoWindow(screenManager).setVisible(true);
            }
        });
    }
}
