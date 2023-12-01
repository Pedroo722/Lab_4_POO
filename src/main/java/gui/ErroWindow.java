package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErroWindow extends JFrame {

    private JLabel jLabelErro;
    private JLabel jLabelOcorreu;
    private JButton jButtonOk;

    public ErroWindow() {
        initComponents();
    }

    private void initComponents() {
        jLabelErro = new JLabel();
        jLabelOcorreu = new JLabel();
        jButtonOk = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(386, 217));
        setMinimumSize(new java.awt.Dimension(386, 217));
        setResizable(false);

        jLabelErro.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabelErro.setText("Erro");

        jLabelOcorreu.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabelOcorreu.setText("Ocorreu um erro ao executar esta ação");

        jButtonOk.setBackground(new java.awt.Color(204, 204, 255));
        jButtonOk.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jButtonOk.setForeground(new java.awt.Color(0, 0, 0));
        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabelErro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabelOcorreu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jButtonOk)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelErro)
                .addGap(44, 44, 44)
                .addComponent(jLabelOcorreu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButtonOk)
                .addGap(33, 33, 33))
        );

        pack();
    }

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(ErroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ErroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ErroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ErroWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ErroWindow().setVisible(true);
            }
        });
    }
}
