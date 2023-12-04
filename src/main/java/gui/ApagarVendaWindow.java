package gui; 

import gerenciador.Controller;
import validators.IntValidator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exceptions.NumeroVendaInvalidoException;

public class ApagarVendaWindow extends javax.swing.JFrame {

    /**
     * Creates new form ApagarVendaWindow
     */
    private ScreenManager screenManager;
    private Controller controller;

    public ApagarVendaWindow(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.controller = Controller.getInstance();
        initComponents();

        setLocationRelativeTo(null);
    }

    private void initComponents() {
        jLabelApagarVenda = new JLabel();
        JButtonApagarVenda = new JButton();
        jLabelNumeroVenda = new JLabel();
        jTextFieldNumeroVenda = new JTextField();
        JButtonVoltar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(869, 570));
        setMinimumSize(new java.awt.Dimension(869, 570));
        setName(""); 
        setPreferredSize(new java.awt.Dimension(869, 570));
        setResizable(false);

        jLabelApagarVenda.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelApagarVenda.setText("Apagar Venda");

        JButtonApagarVenda.setBackground(new java.awt.Color(153, 255, 51));
        JButtonApagarVenda.setFont(new java.awt.Font("Segoe UI", 0, 18));
        JButtonApagarVenda.setForeground(new java.awt.Color(51, 51, 51));
        JButtonApagarVenda.setText("Apagar Venda");
        JButtonApagarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonApagarVendaActionPerformed(evt);
            }
        });

        jLabelNumeroVenda.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelNumeroVenda.setText("Número da Venda:");

        jTextFieldNumeroVenda.setBackground(new java.awt.Color(255, 255, 255));

        JButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
        JButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        JButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
        JButtonVoltar.setText("Voltar");
        JButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelApagarVenda)
                .addGap(205, 205, 205))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JButtonVoltar)
                    .addComponent(jLabelNumeroVenda))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldNumeroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonApagarVenda))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelApagarVenda)
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNumeroVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumeroVenda, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JButtonVoltar)
                    .addComponent(JButtonApagarVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );

        pack();
    }

    private void JButtonApagarVendaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String numeroVendaString = jTextFieldNumeroVenda.getText();
            int numeroVenda = Integer.parseInt(numeroVendaString);

            boolean isNumeroValid = new IntValidator().validate(numeroVenda);

            if (isNumeroValid) {
                controller.apagarVenda(numeroVenda);
            } else {
                throw new NumberFormatException();
            }
            jTextFieldNumeroVenda.setText("");
        } catch (NumeroVendaInvalidoException ex) {
            JOptionPane.showMessageDialog(this, "Operação falha. Nenhuma venda com esse número encontrada.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Operação falha. Insira um número válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void JButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(ApagarVendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApagarVendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApagarVendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApagarVendaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        ScreenManager screenManager = new ScreenManager();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApagarVendaWindow(screenManager).setVisible(true);
            }
        });
    }

    private javax.swing.JButton JButtonApagarVenda;
    private javax.swing.JButton JButtonVoltar;
    private javax.swing.JLabel jLabelApagarVenda;
    private javax.swing.JLabel jLabelNumeroVenda;
    private javax.swing.JTextField jTextFieldNumeroVenda;
}
