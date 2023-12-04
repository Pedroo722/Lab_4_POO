package gui;

import gerenciador.Controller;
import model.ItemVenda;
import model.Produto;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import exceptions.EstoqueVazioException;
import exceptions.VendasVazioException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;

public class VendaWindow extends javax.swing.JFrame {

    /**
     * Creates new form VendaWindow
     */
    private ScreenManager screenManager;
    private Controller controller;

    public VendaWindow(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.controller = Controller.getInstance();
        initComponents();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent evt) {
                setTextArea();
            }
        });
    }

    private void initComponents() {
        JLabelMenuVenda = new JLabel();
        JButtonCadastraVenda = new JButton();
        JButtonExcluirVenda = new JButton();
        JButtonVoltar = new JButton();
        jScrollPaneVenda = new JScrollPane();
        jTextAreaVenda = new JTextArea();
        jTextPaneVenda = new javax.swing.JTextPane();
        
        jTextPaneVenda.setContentType("text/html");
        jTextPaneVenda.setEditable(false);
        jScrollPaneVenda.setViewportView(jTextPaneVenda);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(869, 570));
        setPreferredSize(new java.awt.Dimension(869, 570));

        JLabelMenuVenda.setFont(new java.awt.Font("Segoe UI", 1, 36));
        JLabelMenuVenda.setText("Menu de Venda");

        JButtonCadastraVenda.setBackground(new java.awt.Color(51, 153, 255));
        JButtonCadastraVenda.setFont(new java.awt.Font("Segoe UI", 0, 24));
        JButtonCadastraVenda.setForeground(new java.awt.Color(51, 51, 51));
        JButtonCadastraVenda.setText("Cadastrar Venda");
        JButtonCadastraVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCadastraVendaActionPerformed(evt);
            }
        });

        JButtonExcluirVenda.setBackground(new java.awt.Color(51, 153, 255));
        JButtonExcluirVenda.setFont(new java.awt.Font("Segoe UI", 0, 24));
        JButtonExcluirVenda.setForeground(new java.awt.Color(51, 51, 51));
        JButtonExcluirVenda.setText("Excluir Venda");
        JButtonExcluirVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonExcluirVendaActionPerformed(evt);
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

        jTextAreaVenda.setColumns(20);
        jTextAreaVenda.setRows(5);
        jScrollPaneVenda.setViewportView(jTextAreaVenda);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(JLabelMenuVenda))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(JButtonCadastraVenda)
                        .addGap(100, 100, 100)
                        .addComponent(JButtonVoltar)
                        .addGap(88, 88, 88)
                        .addComponent(JButtonExcluirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jScrollPaneVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JLabelMenuVenda)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonExcluirVenda)
                    .addComponent(JButtonCadastraVenda)
                    .addComponent(JButtonVoltar))
                .addGap(28, 28, 28)
                .addComponent(jScrollPaneVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        pack();
    }

    private void JButtonCadastraVendaActionPerformed(java.awt.event.ActionEvent evt) {
        screenManager.showCadastroVendaWindow();
    }


    private void JButtonExcluirVendaActionPerformed(java.awt.event.ActionEvent evt) {
        screenManager.showApagarVendaWindow();
    }

    private void JButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        screenManager.showMainWindow();
    }

    private void setTextArea() {
        try {
            List<ItemVenda> vendas;
            vendas = controller.relatorioVendas();
    
            StringBuilder textContent = new StringBuilder();
    
            for (int i = 0; i < vendas.size(); i++) {
                ItemVenda venda = vendas.get(i);
                textContent.append("===== Venda #").append(i + 1).append(" ====\n");
    
                List<Produto> produtosVenda = venda.getProdutos();
                int index = 1;
                for (Produto produto : produtosVenda) {
                    textContent.append("Produto #").append(index).append("\n");
                    textContent.append("* Nome do Produto: ").append(produto.getNome()).append("\n");
                    textContent.append("* Preço: ").append(produto.getPreco()).append("\n");
                    textContent.append("* Quantidade Vendida: ").append(produto.getQuantidadeVendida()).append("\n\n");

                    index++;
                }
            }
    
            if (vendas.isEmpty()) {
                textContent.append("Nenhuma venda cadastrada.");
            }
    
            jTextAreaVenda.setText(textContent.toString());
        } catch (VendasVazioException e) {
            jTextAreaVenda.setText("Nenhuma venda cadastrada.");
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
            java.util.logging.Logger.getLogger(VendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        // Crie uma instância de ScreenManager
        ScreenManager screenManager = new ScreenManager();
    
        // Passe o ScreenManager ao criar a instância de VendaWindow
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaWindow(screenManager).setVisible(true);
            }
        });
    }

    private javax.swing.JButton JButtonCadastraVenda;
    private javax.swing.JButton JButtonExcluirVenda;
    private javax.swing.JButton JButtonVoltar;
    private javax.swing.JLabel JLabelMenuVenda;
    private javax.swing.JScrollPane jScrollPaneVenda;
    private javax.swing.JTextArea jTextAreaVenda;
    private javax.swing.JTextPane jTextPaneVenda;
}
