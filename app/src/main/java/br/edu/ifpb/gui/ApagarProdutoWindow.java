package br.edu.ifpb.gui;

import java.awt.Component;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import br.edu.ifpb.exceptions.ProdutoNaoEncontradoException;
import br.edu.ifpb.gerenciador.Controller;
import br.edu.ifpb.model.Produto;
import br.edu.ifpb.validators.IntValidator;

public class ApagarProdutoWindow extends javax.swing.JFrame {

    private ScreenManager screenManager;
    private Controller controller;
    private JComboBox<Produto> jComboBoxProdutosExcluir;

    public ApagarProdutoWindow(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.controller = Controller.getInstance();
        initComponents();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent evt) {
                        updateProdutoListExcluir();

            }

            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                controller.salvarProdutos();
                controller.salvarVendas();
            }
        });
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
        setLocationRelativeTo(null);

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
        jLabelIdProduto.setText("Produto:");

        List<Produto> listaProdutosExcluir = controller.listarProdutos();
        DefaultComboBoxModel<Produto> modelExcluir = new DefaultComboBoxModel<>(listaProdutosExcluir.toArray(new Produto[0]));
        jComboBoxProdutosExcluir = new JComboBox<>(modelExcluir);

        jComboBoxProdutosExcluir.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Produto) {
                    Produto produto = (Produto) value;
                    setText(produto.getNome());
                }
                return this;
            }
        });

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
                        .addComponent(jComboBoxProdutosExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jComboBoxProdutosExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            Produto produtoSelecionado = jComboBoxProdutosExcluir.getItemAt(jComboBoxProdutosExcluir.getSelectedIndex());
            int idProdutoSelecionado = produtoSelecionado.getIdentificador();

            boolean isNumeroValid = new IntValidator().validate(idProdutoSelecionado);

            if (isNumeroValid) {
                controller.removerProduto(idProdutoSelecionado);
            } else {
                throw new NumberFormatException();
            }
            
            jTextFieldIdProduto.setText("");
            updateProdutoListExcluir();
        } catch (ProdutoNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(this, "Operação falha. Nenhum produto com esse ID encontrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Operação falha. Insira um número válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void JButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        screenManager.showEstoqueWindow();
    }

    private void updateProdutoListExcluir() {
        List<Produto> listaProdutos = controller.listarProdutos();
        DefaultComboBoxModel<Produto> model = new DefaultComboBoxModel<>(listaProdutos.toArray(new Produto[0]));

        Produto produtoSelecionado = (Produto) jComboBoxProdutosExcluir.getSelectedItem();

        jComboBoxProdutosExcluir.setModel(model);

        jComboBoxProdutosExcluir.setSelectedItem(produtoSelecionado);
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
            java.util.logging.Logger.getLogger(ApagarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApagarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApagarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApagarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        ScreenManager screenManager = new ScreenManager();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApagarProdutoWindow(screenManager).setVisible(true);
            }
        });
    }

    private javax.swing.JButton JButtonExcluirProduto;
    private javax.swing.JButton JButtonVoltar;
    private javax.swing.JLabel jLabelExcluirProduto;
    private javax.swing.JLabel jLabelIdProduto;
    private javax.swing.JTextField jTextFieldIdProduto;
}
