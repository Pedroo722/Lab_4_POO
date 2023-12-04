package gui;

import gerenciador.Controller;
import validators.IntValidator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import exceptions.InventarioInsuficienteException;
import exceptions.ProdutoNaoEncontradoException;

public class VendaCadastroWindow extends JFrame {

    private JButton jButtonVoltar;
    private JButton jButtonCadastrarVenda;
    private JLabel jLabelCadastroVendas;
    private JLabel jLabelIdProduto;
    private JTextField jTextFieldIdProduto;
    private JTextField jTextFieldQuantidadeVendida;
    private JLabel jLabelQuantidadeVendida;
    private JButton jButtonAdicionarItem;
    private JScrollPane jScrollPaneVenda;
    private JTable jTableVenda;
    private JButton jButtonRemoverItem;
    private ScreenManager screenManager;
    private Controller controller;
    private List<Integer> identificadoresProdutos = new ArrayList<>();
    private List<Integer> quantidadesVendidas = new ArrayList<>();

    public VendaCadastroWindow(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.controller = Controller.getInstance();
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
        jButtonAdicionarItem = new JButton();
        jScrollPaneVenda = new JScrollPane();
        jTableVenda = new JTable();
        jButtonRemoverItem = new JButton();

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

        jTextFieldQuantidadeVendida.setBackground(new java.awt.Color(255, 255, 255));

        jLabelQuantidadeVendida.setBackground(new java.awt.Color(51, 204, 255));
        jLabelQuantidadeVendida.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelQuantidadeVendida.setForeground(new java.awt.Color(0, 153, 255));
        jLabelQuantidadeVendida.setText("Quantidade Vendida:");
        jLabelQuantidadeVendida.setName("");        

        jButtonAdicionarItem.setBackground(new java.awt.Color(102, 255, 51));
        jButtonAdicionarItem.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonAdicionarItem.setForeground(new java.awt.Color(51, 51, 51));
        jButtonAdicionarItem.setText("Adicionar Produto");
        jButtonAdicionarItem.setActionCommand("Adicionar Produto");
        jButtonAdicionarItem.setName("");
        jButtonAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarItemActionPerformed(evt);
            }
        });

        jTableVenda.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTableVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Produto", "Unidades Vendidas"
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

        jButtonRemoverItem.setBackground(new java.awt.Color(51, 153, 255));
        jButtonRemoverItem.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonRemoverItem.setForeground(new java.awt.Color(51, 51, 51));
        jButtonRemoverItem.setText("Remover Item");
        jButtonRemoverItem.setName("");
        jButtonRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverItemActionPerformed(evt);
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
                        .addComponent(jButtonAdicionarItem))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVoltar)
                        .addGap(138, 138, 138)
                        .addComponent(jButtonRemoverItem)
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
                    .addComponent(jButtonAdicionarItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonRemoverItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastrarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }

    private void setTableModel() {
        // Dados de exemplo para preencher a tabela
        Object[][] data = {};
    
        String[] columnNames = {"ID", "Produto", "Quantidade"};
    
        // Configure o modelo da tabela com os dados
        jTableVenda.setModel(new javax.swing.table.DefaultTableModel(data, columnNames) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
    
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
    
        jTableVenda.setFillsViewportHeight(true);
    }
    
    private void jButtonAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int idProduto = Integer.parseInt(jTextFieldIdProduto.getText());
            int quantidadeVendida = Integer.parseInt(jTextFieldQuantidadeVendida.getText());
    
            boolean isIdValid = new IntValidator().validate(idProduto);
            boolean isQuantidadeValid = new IntValidator().validate(quantidadeVendida);
    
            if (isIdValid && isQuantidadeValid) {
                String nomeProduto = controller.obterNome(idProduto); // Obter o nome do produto
                identificadoresProdutos.add(idProduto);
                quantidadesVendidas.add(quantidadeVendida);
    
                DefaultTableModel model = (DefaultTableModel) jTableVenda.getModel();
                model.addRow(new Object[]{idProduto, nomeProduto, quantidadeVendida});
            } else {
                throw new NumberFormatException();
            }
            jTextFieldIdProduto.setText("");
            jTextFieldQuantidadeVendida.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Operação falha. Insira números válidos para o ID e a quantidade vendida.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    

    private void jButtonCadastrarVendaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Chame o método adicionarItemVenda do controlador
            controller.adicionarItemVenda(identificadoresProdutos, quantidadesVendidas);

            // Limpe as listas e a tabela
            identificadoresProdutos.clear();
            quantidadesVendidas.clear();
            DefaultTableModel model = (DefaultTableModel) jTableVenda.getModel();
            model.setRowCount(0);
        } catch (InventarioInsuficienteException e) {
            JOptionPane.showMessageDialog(this, "Operação falha. A quantidade vendida excede o estoque atual.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (ProdutoNaoEncontradoException e) {
            JOptionPane.showMessageDialog(this, "Operação falha. Produto não encontrado, o foi possível cadastrar a venda.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void jButtonRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTableVenda.getSelectedRow();
    
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTableVenda.getModel();
            model.removeRow(selectedRow);
    
            identificadoresProdutos.remove(selectedRow);
            quantidadesVendidas.remove(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Primeiro selecione um item na tabela para apagar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
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