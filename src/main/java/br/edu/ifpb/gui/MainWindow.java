package br.edu.ifpb.gui;

import br.edu.ifpb.gerenciador.Controller;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private ScreenManager screenManager;
    private Controller controller;

    public MainWindow(ScreenManager screenManager) {
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
        jButtonEstoque = new JButton();
        jButtonVendas = new JButton();
        jLabelMenu = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(557, 428));
        setMinimumSize(new java.awt.Dimension(557, 428));
        setResizable(false);
        
        jButtonEstoque.setBackground(new java.awt.Color(153, 153, 255));
        jButtonEstoque.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButtonEstoque.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEstoque.setText("Estoque");
        jButtonEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstoqueActionPerformed(evt);
            }
        });
    
        jButtonVendas.setBackground(new java.awt.Color(153, 153, 255));
        jButtonVendas.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButtonVendas.setForeground(new java.awt.Color(0, 0, 0));
        jButtonVendas.setText("Vendas");  
        jButtonVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendasActionPerformed(evt);
            }
        });

        jLabelMenu.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabelMenu.setText("Menu");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jButtonEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(jButtonVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonEstoqueActionPerformed(java.awt.event.ActionEvent evt) {
        screenManager.showEstoqueWindow();
    }
    
    private void jButtonVendasActionPerformed(java.awt.event.ActionEvent bvt) {
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        // Crie uma instância de ScreenManager
        ScreenManager screenManager = new ScreenManager();
    
        // Passe o ScreenManager ao criar a instância de MainWindow
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow(screenManager).setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonEstoque;
    private javax.swing.JButton jButtonVendas;
    private javax.swing.JLabel jLabelMenu;
}
