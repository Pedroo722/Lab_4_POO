package gui;

import gerenciador.Controller;

import validators.IntValidator;

import exceptions.ProdutoNaoEncontradoException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ExcluirProdutoWindow extends javax.swing.JFrame {

    /**
     * Creates new form ExcluirProdutoWindow
     */
    private ScreenManager screenManager;
    private Controller controller;

    public ExcluirProdutoWindow(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.controller = Controller.getInstance();
        initComponents();
    }


    private void initComponents() {
        jLabelExcluirProduto = new JLabel();
        JButtonExcluirProduto = new JButton();
        JButtonVoltar = new JButton();
        jLabelIdProduto = new JLabel();
        jTextFieldIdProduto = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(869, 570));
        setMinimumSize(new java.awt.Dimension(869, 570));
        setPreferredSize(new java.awt.Dimension(869, 570));
        setResizable(false);

        jLabelExcluirProduto.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelExcluirProduto.setText("Excluir Produto");

        JButtonExcluirProduto.setBackground(new java.awt.Color(153, 255, 51));
        JButtonExcluirProduto.setFont(new java.awt.Font("Segoe UI", 0, 18));
        JButtonExcluirProduto.setForeground(new java.awt.Color(51, 51, 51));
        JButtonExcluirProduto.setText("Excluir Produto");
        JButtonExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonExcluirProdutoActionPerformed(evt);
            }
        });

        JButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
        JButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        JButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
        JButtonVoltar.setText("Voltar");
        JButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonVoltarActionPerformed(evt);
            }
        });

        jLabelIdProduto.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelIdProduto.setText("ID do produto:");

        jTextFieldIdProduto.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelExcluirProduto)
                .addGap(202, 202, 202))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JButtonVoltar)
                    .addComponent(jLabelIdProduto))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jTextFieldIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(JButtonExcluirProduto)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabelExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIdProduto)
                    .addComponent(jTextFieldIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonVoltar))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
    }

    private void JButtonExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String IDString = jTextFieldIdProduto.getText();
            int ID = Integer.parseInt(IDString);

            boolean isNumeroValid = new IntValidator().validate(ID);

            if (isNumeroValid) {
                controller.removerProduto(ID);
            } else {
                throw new NumberFormatException();
            }

            jTextFieldIdProduto.setText("");

        } catch (ProdutoNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(this, "Operação falha. Nenhum produto com esse ID encontrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Operação falha. Insira um número válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void JButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(ExcluirProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExcluirProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExcluirProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExcluirProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        ScreenManager screenManager = new ScreenManager();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcluirProdutoWindow(screenManager).setVisible(true);
            }
        });
    }

    private javax.swing.JButton JButtonExcluirProduto;
    private javax.swing.JButton JButtonVoltar;
    private javax.swing.JLabel jLabelExcluirProduto;
    private javax.swing.JLabel jLabelIdProduto;
    private javax.swing.JTextField jTextFieldIdProduto;
}
