package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EstoqueWindow extends JFrame {

    private JLabel jLabelMenuEstoque;
    private JButton jButtonAdicionaProduto;
    private JButton jButtonExcluirProduto;
    private JButton jButtonVoltar;
    private JButton jButtonEditarProduto;
    private JScrollPane jScrollPaneEstoque;
    private JTable jTableEstoque;
    

    public EstoqueWindow() {
        initComponents();
    }

    private void initComponents() {
        jLabelMenuEstoque = new JLabel();
        jButtonAdicionaProduto = new JButton();
        jButtonExcluirProduto = new JButton();
        jButtonVoltar = new JButton();
        jButtonEditarProduto = new JButton();
        jScrollPaneEstoque = new JScrollPane();
        jTableEstoque = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(869, 570));
        setName("frMainWindow");
        setPreferredSize(new java.awt.Dimension(869, 570));

        jLabelMenuEstoque.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelMenuEstoque.setText("Menu do Estoque");

        jButtonAdicionaProduto.setBackground(new java.awt.Color(51, 153, 255));
        jButtonAdicionaProduto.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonAdicionaProduto.setForeground(new java.awt.Color(51, 51, 51));
        jButtonAdicionaProduto.setText("Adicionar Produto");
        jButtonAdicionaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionaProdutoActionPerformed(evt);
            }
        });

        jButtonExcluirProduto.setBackground(new java.awt.Color(51, 153, 255));
        jButtonExcluirProduto.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonExcluirProduto.setForeground(new java.awt.Color(51, 51, 51));
        jButtonExcluirProduto.setText("Excluir Produto");
        jButtonExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirProdutoActionPerformed(evt);
            }
        });

        jButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        

        jButtonEditarProduto.setBackground(new java.awt.Color(51, 153, 255));
        jButtonEditarProduto.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonEditarProduto.setForeground(new java.awt.Color(51, 51, 51));
        jButtonEditarProduto.setText("Editar Produto");
        jButtonEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarProdutoActionPerformed(evt);
            }
        });

        jTableEstoque.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTableEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Preço", "Quantidade no Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneEstoque.setViewportView(jTableEstoque);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonExcluirProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAdicionaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonVoltar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonEditarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(142, 142, 142))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMenuEstoque)
                .addGap(240, 240, 240))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelMenuEstoque)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionaProduto)
                    .addComponent(jButtonEditarProduto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcluirProduto)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void jButtonAdicionaProdutoActionPerformed(java.awt.event.ActionEvent evt) {
        EstoqueCadastroWindow cadastroProdutoWindow = new EstoqueCadastroWindow();
        cadastroProdutoWindow.setVisible(true);
        this.setVisible(false);
    }

    private void jButtonExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {
        ExcluirProdutoWindow excluirWindow = new ExcluirProdutoWindow();
        excluirWindow.setVisible(true);
        this.setVisible(false);
    }

    private void jButtonEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {
        EditarProdutoWindow editarWindow = new EditarProdutoWindow();
        editarWindow.setVisible(true);
        this.setVisible(false);
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(EstoqueWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstoqueWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstoqueWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstoqueWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstoqueWindow().setVisible(true);
            }
        });
    }
}
