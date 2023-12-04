package br.edu.ifpb.gui;

import br.edu.ifpb.validators.DoubleValidator;
import br.edu.ifpb.validators.IntValidator;
import br.edu.ifpb.validators.StringValidator;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.ifpb.exceptions.EstoqueVazioException;
import br.edu.ifpb.exceptions.ProdutoNaoEncontradoException;
import br.edu.ifpb.gerenciador.Controller;

public class EditarProdutoWindow extends javax.swing.JFrame {

    /**
     * Creates new form EditarProdutoWindow
     */
    private ScreenManager screenManager;
    private Controller controller;


    public EditarProdutoWindow(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.controller = Controller.getInstance();
        initComponents();

        setLocationRelativeTo(null);
    }

    private void initComponents() {
        jLabelEditarProduto = new JLabel();
        jLabelNovoNome = new JLabel();
        jButtonVoltar = new JButton();
        jTextFieldNovaQuantidade = new JTextField();
        jButtonEditar = new JButton();
        jLabelNovoPreco = new JLabel();
        jTextFieldNovoNome = new JTextField();
        jLabelNovaQuantidade = new JLabel();
        jTextFieldNovoPreco = new JTextField();
        jLabelIdProduto = new JLabel();
        jTextFieldIdProduto = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(869, 570));
        setMinimumSize(new java.awt.Dimension(869, 570));
        setPreferredSize(new java.awt.Dimension(869, 570));
        setResizable(false);

        jLabelEditarProduto.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelEditarProduto.setText("Editar Produto");

        jLabelNovoNome.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelNovoNome.setText("Novo Nome:");

        jButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonVoltarActionPerformed(evt);
            }
        });


        jTextFieldNovaQuantidade.setBackground(new java.awt.Color(255, 255, 255));

        jButtonEditar.setBackground(new java.awt.Color(255, 153, 0));
        jButtonEditar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonEditar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        

        jLabelNovoPreco.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelNovoPreco.setText("Novo Preço:");

        jTextFieldNovoNome.setBackground(new java.awt.Color(255, 255, 255));

        jLabelNovaQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelNovaQuantidade.setText("Nova Quantidade:");

        jTextFieldNovoPreco.setBackground(new java.awt.Color(255, 255, 255));


        jLabelIdProduto.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelIdProduto.setText("ID do produto editado:");

        jTextFieldIdProduto.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNovaQuantidade)
                    .addComponent(jLabelIdProduto)
                    .addComponent(jLabelNovoPreco)
                    .addComponent(jLabelNovoNome))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNovoPreco)
                    .addComponent(jTextFieldNovoNome)
                    .addComponent(jTextFieldNovaQuantidade)
                    .addComponent(jTextFieldIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonVoltar)
                        .addGap(216, 216, 216)
                        .addComponent(jButtonEditar)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelEditarProduto)
                        .addGap(218, 218, 218))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelEditarProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIdProduto)
                    .addComponent(jTextFieldIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNovoNome)
                    .addComponent(jTextFieldNovoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNovoPreco)
                    .addComponent(jTextFieldNovoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNovaQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNovaQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonEditar))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNovoPrecoActionPerformed
        try {
            String IDString = jTextFieldIdProduto.getText();
            int ID = Integer.parseInt(IDString);

            String nome = jTextFieldNovoNome.getText();
            double valor = Double.parseDouble(jTextFieldNovoPreco.getText());
            int quantidade = Integer.parseInt(jTextFieldNovaQuantidade.getText());

            boolean isNomeValid = new StringValidator().validate(nome);
            boolean isPrecoValid = new DoubleValidator().validate(valor);
            boolean isQuantidadeValid = new IntValidator().validate(quantidade);

            if (isNomeValid && isPrecoValid && isQuantidadeValid) {
                controller.editarProduto(ID, nome, valor, quantidade);

                jTextFieldIdProduto.setText("");
                jTextFieldNovoNome.setText("");
                jTextFieldNovoPreco.setText("");
                jTextFieldNovaQuantidade.setText("");
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Formato de número invalido.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (ProdutoNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(this, "Operação falha. Nenhum produto com esse ID encontrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (EstoqueVazioException ex) {
            JOptionPane.showMessageDialog(this, "Operação falha. O estoque está vazio!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void JButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNovoPrecoActionPerformed
        screenManager.showEstoqueWindow();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        ScreenManager screenManager = new ScreenManager();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarProdutoWindow(screenManager).setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelEditarProduto;
    private javax.swing.JLabel jLabelIdProduto;
    private javax.swing.JLabel jLabelNovaQuantidade;
    private javax.swing.JLabel jLabelNovoNome;
    private javax.swing.JLabel jLabelNovoPreco;
    private javax.swing.JTextField jTextFieldIdProduto;
    private javax.swing.JTextField jTextFieldNovaQuantidade;
    private javax.swing.JTextField jTextFieldNovoNome;
    private javax.swing.JTextField jTextFieldNovoPreco;
}
