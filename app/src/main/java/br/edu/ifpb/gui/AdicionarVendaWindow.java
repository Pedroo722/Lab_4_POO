package br.edu.ifpb.gui;

import br.edu.ifpb.validators.IntValidator;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpb.exceptions.InventarioInsuficienteException;
import br.edu.ifpb.exceptions.ProdutoNaoEncontradoException;
import br.edu.ifpb.gerenciador.Controller;
import br.edu.ifpb.model.Produto;

public class AdicionarVendaWindow extends JFrame {

    private JButton jButtonVoltar;
    private JButton jButtonCadastrarVenda;
    private JLabel jLabelCadastroVendas;
    private JLabel jLabelIdProduto;
    private JComboBox<Produto> jComboBoxProdutos;
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

    public AdicionarVendaWindow(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.controller = Controller.getInstance();
        initComponents();
        setTableModel();

        setLocationRelativeTo(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent evt) {
                updateProdutoList();
            }

            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                controller.salvarProdutos();
                controller.salvarVendas();
            }
        });
    }

    private void initComponents() {
        jButtonVoltar = new JButton();
        jButtonCadastrarVenda = new JButton();
        jLabelCadastroVendas = new JLabel();
        jLabelIdProduto = new JLabel();
        jComboBoxProdutos = new JComboBox<>();
        jTextFieldQuantidadeVendida = new JTextField();
        jLabelQuantidadeVendida = new JLabel();
        jButtonAdicionarItem = new JButton();
        jScrollPaneVenda = new JScrollPane();
        jTableVenda = new JTable();
        jButtonRemoverItem = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(869, 570));
        setResizable(false);

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
        jLabelIdProduto.setText("Produto:");
        jLabelIdProduto.setName("");

        List<Produto> listaProdutos = controller.listarProdutos();
        DefaultComboBoxModel<Produto> model = new DefaultComboBoxModel<>(listaProdutos.toArray(new Produto[0]));
        jComboBoxProdutos.setModel(model);

        jComboBoxProdutos.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Produto) {
                    Produto produto = (Produto) value;
                    setText(produto.getNome());
                }
                return this;
            }
        });

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
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "ID", "Produto", "Unidades Vendidas"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
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
                                                        .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldQuantidadeVendida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelQuantidadeVendida)
                                        .addComponent(jButtonAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        Object[][] data = {};

        String[] columnNames = {"ID", "Produto", "Quantidade"};

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

    private void updateProdutoList() {
        List<Produto> listaProdutos = controller.listarProdutos();
        DefaultComboBoxModel<Produto> model = new DefaultComboBoxModel<>(listaProdutos.toArray(new Produto[0]));
    
        Produto produtoSelecionado = (Produto) jComboBoxProdutos.getSelectedItem();
    
        jComboBoxProdutos.setModel(model);
    
        jComboBoxProdutos.setSelectedItem(produtoSelecionado);
    }
    

    private void jButtonAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Produto produtoSelecionado = jComboBoxProdutos.getItemAt(jComboBoxProdutos.getSelectedIndex());
            int idProdutoSelecionado = produtoSelecionado.getIdentificador();
            int quantidadeVendida = Integer.parseInt(jTextFieldQuantidadeVendida.getText());

            boolean isQuantidadeValid = new IntValidator().validate(quantidadeVendida);

            if (isQuantidadeValid) {
                String nomeProduto = controller.obterNome(idProdutoSelecionado);
                identificadoresProdutos.add(idProdutoSelecionado);
                quantidadesVendidas.add(quantidadeVendida);

                DefaultTableModel model = (DefaultTableModel) jTableVenda.getModel();
                model.addRow(new Object[]{idProdutoSelecionado, nomeProduto, quantidadeVendida});
            } else {
                throw new NumberFormatException();
            }

            jTextFieldQuantidadeVendida.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Operação falha. Insira uma quantidade válida.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void jButtonCadastrarVendaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            controller.adicionarItemVenda(identificadoresProdutos, quantidadesVendidas);

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
            java.util.logging.Logger.getLogger(AdicionarVendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarVendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarVendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarVendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        ScreenManager screenManager = new ScreenManager();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarVendaWindow(screenManager).setVisible(true);
            }
        });
    }
}
