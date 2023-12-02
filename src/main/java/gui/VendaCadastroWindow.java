package gui; 

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VendaCadastroWindow extends JFrame {

    private JButton jButtonVoltar;
    private JButton jButtonCadastrarVenda;
    private JLabel jLabelCadastroVendas;
    private JLabel jLabelIdProduto;
    private JTextField jTextFieldIdProduto;
    private JTextField jTextFieldQuantidadeVendida;
    private JLabel jLabelQuantidadeVendida;
    private JButton jButtonAdicionarVenda;
    private JScrollPane jScrollPaneVenda;
    private JTable jTableVenda;
    private JButton jButtonApagarVenda;
    private ScreenManager screenManager;

    public VendaCadastroWindow(ScreenManager screenManager) {
        this.screenManager = screenManager;
        initComponents();
        setTableModel();
    }

    private void initComponents() {
        jButtonVoltar = new JButton();
        jButtonCadastrarVenda = new JButton();
        jLabelCadastroVendas = new JLabel();
        jLabelIdProduto = new JLabel();
        jTextFieldIdProduto = new JTextField();
        jTextFieldQuantidadeVendida = new JTextField();
        jLabelQuantidadeVendida = new JLabel();
        jButtonAdicionarVenda = new JButton();
        jScrollPaneVenda = new JScrollPane();
        jTableVenda = new JTable();
        jButtonApagarVenda = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(869, 570));

        jButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setName("");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonCadastrarVenda.setBackground(new java.awt.Color(102, 255, 51));
        jButtonCadastrarVenda.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonCadastrarVenda.setForeground(new java.awt.Color(51, 51, 51));
        jButtonCadastrarVenda.setText("Cadastrar Vanda");
        jButtonCadastrarVenda.setName("jButtonCadastrarVenda");
        jButtonCadastrarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarVendaActionPerformed(evt);
            }
        });

        jLabelCadastroVendas.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelCadastroVendas.setText("Cadastro de Vendas");

        jLabelIdProduto.setBackground(new java.awt.Color(51, 204, 255));
        jLabelIdProduto.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelIdProduto.setForeground(new java.awt.Color(0, 153, 255));
        jLabelIdProduto.setText("ID do Produto:");
        jLabelIdProduto.setName("");

        jTextFieldIdProduto.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldIdProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdProdutoActionPerformed(evt);
            }
        });

        jTextFieldQuantidadeVendida.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldQuantidadeVendida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantidadeVendidaActionPerformed(evt);
            }
        });

        jLabelQuantidadeVendida.setBackground(new java.awt.Color(51, 204, 255));
        jLabelQuantidadeVendida.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelQuantidadeVendida.setForeground(new java.awt.Color(0, 153, 255));
        jLabelQuantidadeVendida.setText("Quantidade Vendida:");
        jLabelQuantidadeVendida.setName("");

        jButtonAdicionarVenda.setBackground(new java.awt.Color(102, 255, 51));
        jButtonAdicionarVenda.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonAdicionarVenda.setForeground(new java.awt.Color(51, 51, 51));
        jButtonAdicionarVenda.setText("Adicionar Venda");
        jButtonAdicionarVenda.setActionCommand("Adicionar Venda");
        jButtonAdicionarVenda.setName("");
        jButtonAdicionarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarVendaActionPerformed(evt);
            }
        });

        jTableVenda.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTableVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Produto", "Unidades Vendidas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneVenda.setViewportView(jTableVenda);

        jButtonApagarVenda.setBackground(new java.awt.Color(51, 153, 255));
        jButtonApagarVenda.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonApagarVenda.setForeground(new java.awt.Color(51, 51, 51));
        jButtonApagarVenda.setText("Apagar Venda");
        jButtonApagarVenda.setName("");
        jButtonApagarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelIdProduto)
                            .addComponent(jLabelQuantidadeVendida))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuantidadeVendida, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(jButtonAdicionarVenda))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVoltar)
                        .addGap(138, 138, 138)
                        .addComponent(jButtonApagarVenda)
                        .addGap(93, 93, 93)
                        .addComponent(jButtonCadastrarVenda)))
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabelCadastroVendas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jScrollPaneVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelCadastroVendas)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelIdProduto)
                    .addComponent(jTextFieldIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldQuantidadeVendida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelQuantidadeVendida))
                    .addComponent(jButtonAdicionarVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonApagarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastrarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }

    private void setTableModel() {
        // Dados de exemplo para preencher a tabela
        Object[][] data = {
            {,},
            {,},
            {,},
            {,},
        };
    
        String[] columnNames = {"Produto", "Quantidade"};
    
        // Configure o modelo da tabela com os dados
        jTableVenda.setModel(new javax.swing.table.DefaultTableModel(data, columnNames) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
    
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

        jTableVenda.setFillsViewportHeight(true);

    }

    private void jButtonCadastrarVendaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextFieldIdProdutoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextFieldQuantidadeVendidaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonAdicionarVendaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonApagarVendaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        screenManager.showVendaWindow();
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
            java.util.logging.Logger.getLogger(VendaCadastroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaCadastroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaCadastroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaCadastroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        ScreenManager screenManager = new ScreenManager();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaCadastroWindow(screenManager).setVisible(true);
            }
        });
    }
}