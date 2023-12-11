package br.edu.ifpb.gui;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpb.exceptions.EstoqueVazioException;
import br.edu.ifpb.gerenciador.Controller;

import java.awt.Component;

import java.awt.Color;

import br.edu.ifpb.model.Produto;

public class EstoqueWindow extends JFrame {

    private JLabel jLabelMenuEstoque;
    private JButton jButtonAdicionaProduto;
    private JButton jButtonExcluirProduto;
    private JButton jButtonVoltar;
    private JButton jButtonEditarProduto;
    private JScrollPane jScrollPaneEstoque;
    private JTable jTableEstoque;
    private ScreenManager screenManager;
    private Controller controller;


    public EstoqueWindow(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.controller = Controller.getInstance();
        initComponents();
        setTableModel();
        setLocationRelativeTo(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent evt) {
                atualizarTabela();
            }

            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                controller.salvarProdutos();
                controller.salvarVendas();
            }
        });

        jTableEstoque.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected) { 
                    component.setBackground(new Color(173, 216, 230)); // Azul claro
                    
                } else {
                    // Se não estiver selecionado, use a cor padrão de fundo
                    component.setBackground(table.getBackground());
                }

                return component;
            }
        });
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
        setResizable(false);

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

        jTableEstoque.setSelectionBackground(Color.CYAN);
        jTableEstoque.setSelectionForeground(Color.BLUE);
        jTableEstoque.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTableEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"O estoque", "está vazio.", null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
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
        jTableEstoque.setFillsViewportHeight(true);
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
        screenManager.showAdicionarProdutoWindow();
    }

    private void jButtonExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {
        screenManager.showExcluirProdutoWindow();
    }

    private void jButtonEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int linha = jTableEstoque.getSelectedRow();
            int identificador = (int) jTableEstoque.getModel().getValueAt(linha, 0);
            String descricao = jTableEstoque.getModel().getValueAt(linha, 1).toString();
            double preco = (double) jTableEstoque.getModel().getValueAt(linha, 2);
            int quantidade = (int) jTableEstoque.getModel().getValueAt(linha, 3);

            screenManager.showEditarProdutoWindow(new Produto(identificador, descricao, preco, quantidade));
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Operação falha. Selecione um item primeiro.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        screenManager.showMainWindow();
    }

    private void setTableModel() {
        try {
            List<Produto> produtos = controller.listarProdutos();

            Object[][] data = new Object[produtos.size()][5]; // Aumente para 5 colunas

            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                data[i][0] = produto.getIdentificador();
                data[i][1] = produto.getNome();
                data[i][2] = produto.getPreco();
                data[i][3] = produto.getQuantidade();

                // Adicione a lógica para determinar o Status
                if (produto.getQuantidade() < 5) {
                    data[i][4] = "Baixa Quantidade";
                } else {
                    data[i][4] = "Alta Quantidade";
                }
            }

            String[] columnNames = {"ID", "Descrição", "Preço", "Quantidade no Estoque", "Status"};

            DefaultTableModel model = new DefaultTableModel(data, columnNames) {
                Class[] types = new Class[]{
                    Integer.class, String.class, Double.class, Integer.class, String.class
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // torna as células não editáveis
                }
            };

            jTableEstoque.setModel(model);
            jTableEstoque.setDefaultRenderer(Object.class, new StatusCellRenderer());

            jTableEstoque.setFillsViewportHeight(true);
        } catch (EstoqueVazioException e) {
            jTableEstoque.setModel(new DefaultTableModel());
        }
    }

    // Adicione esta classe StatusCellRenderer
    class StatusCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String status = value.toString();

            if (isSelected) {
                component.setBackground(new Color(173, 216, 230)); // Azul claro quando selecionado
            } else if ("Baixa Quantidade".equals(status)) {
                component.setBackground(Color.RED);
            } else if ("Alta Quantidade".equals(status)) {
                component.setBackground(Color.GREEN);
            } else {
                component.setBackground(Color.WHITE);
            }

            return component;
        }
    }


    private void atualizarTabela() {
        try {
            // Obtenha os dados reais do método listarProdutos do Controller
            List<Produto> produtos = controller.listarProdutos();
    
            // Converta a lista de produtos para um array bidimensional
            Object[][] data = new Object[produtos.size()][5]; // Aumente para 5 colunas
    
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                data[i][0] = produto.getIdentificador();
                data[i][1] = produto.getNome();
                data[i][2] = produto.getPreco();
                data[i][3] = produto.getQuantidade();
    
                // Adicione a lógica para determinar o Status
                if (produto.getQuantidade() < 5) {
                    data[i][4] = "Baixa Quantidade";
                } else {
                    data[i][4] = "Alta Quantidade";
                }
            }
    
            String[] columnNames = {"ID", "Descrição", "Preço", "Quantidade no Estoque", "Status"};
    
            // Configure o modelo da tabela com os dados reais
            jTableEstoque.setModel(new javax.swing.table.DefaultTableModel(data, columnNames) {
                Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
                };
    
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
            });
    
            jTableEstoque.setDefaultRenderer(Object.class, new StatusCellRenderer()); // Adicione esta linha
    
            jTableEstoque.setFillsViewportHeight(true);
        } catch (EstoqueVazioException ex) {
            // Exceção capturada, exiba a mensagem na tabela
            String[] columnNames = {"Mensagem"};
            Object[][] data = {{"Nenhum produto cadastrado."}};
    
            jTableEstoque.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    
            // Defina o renderizador padrão para a mensagem
            jTableEstoque.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    component.setBackground(table.getBackground());
                    return component;
                }
            });
    
            jTableEstoque.setFillsViewportHeight(true);
        }
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
    
        // Crie uma instância de ScreenManager
        ScreenManager screenManager = new ScreenManager();
    
        // Passe o ScreenManager ao criar a instância de EstoqueWindow
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstoqueWindow(screenManager).setVisible(true);
            }
        });
    }
}