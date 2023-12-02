package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VendaWindow extends javax.swing.JFrame {

    /**
     * Creates new form VendaWindow
     */
    public VendaWindow() {
        initComponents();
    }

    private void initComponents() {
        JLabelMenuVenda = new JLabel();
        JButtonCadastraVenda = new JButton();
        JButtonExcluirVenda = new JButton();
        JButtonVoltar = new JButton();
        jScrollPaneVenda = new JScrollPane();
        jTextAreaVenda = new JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(869, 570));
        setPreferredSize(new java.awt.Dimension(869, 570));

        JLabelMenuVenda.setFont(new java.awt.Font("Segoe UI", 1, 36));
        JLabelMenuVenda.setText("Menu de Venda");

        JButtonCadastraVenda.setBackground(new java.awt.Color(51, 153, 255));
        JButtonCadastraVenda.setFont(new java.awt.Font("Segoe UI", 0, 24));
        JButtonCadastraVenda.setForeground(new java.awt.Color(51, 51, 51));
        JButtonCadastraVenda.setText("Cadastrar Venda");

        JButtonExcluirVenda.setBackground(new java.awt.Color(51, 153, 255));
        JButtonExcluirVenda.setFont(new java.awt.Font("Segoe UI", 0, 24));
        JButtonExcluirVenda.setForeground(new java.awt.Color(51, 51, 51));
        JButtonExcluirVenda.setText("Excluir Venda");

        JButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
        JButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        JButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
        JButtonVoltar.setText("Voltar");

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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaWindow().setVisible(true);
            }
        });
    }

    private javax.swing.JButton JButtonCadastraVenda;
    private javax.swing.JButton JButtonExcluirVenda;
    private javax.swing.JButton JButtonVoltar;
    private javax.swing.JLabel JLabelMenuVenda;
    private javax.swing.JScrollPane jScrollPaneVenda;
    private javax.swing.JTextArea jTextAreaVenda;
}
