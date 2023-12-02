package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditarProdutoWindow extends javax.swing.JFrame {

    /**
     * Creates new form EditarProdutoWindow
     */
    public EditarProdutoWindow() {
        initComponents();
    }

    private void initComponents() {
        jLabelEditarProduto = new JLabel();
        jLabelNovoNome = new JLabel();
        jButtonVoltar = new JButton();
        jTextFieldNovaQuantidade = new JTextField();
        jButtonEditar = new JButton();
        jLabelNovoPreco = new JLabel();
        jTextFieldNovoNome = new JTextField();
        jLabelNovaQuantidade = new JLabel();
        jTextFieldNovoPreco = new JTextField();
        jLabelIdProduto = new JLabel();
        jTextFieldIdProduto = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(869, 570));
        setMinimumSize(new java.awt.Dimension(869, 570));
        setPreferredSize(new java.awt.Dimension(869, 570));
        setResizable(false);

        jLabelEditarProduto.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelEditarProduto.setText("Editar Produto");

        jLabelNovoNome.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelNovoNome.setText("Novo Nome:");

        jButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonVoltar.setText("Voltar");

        jTextFieldNovaQuantidade.setBackground(new java.awt.Color(255, 255, 255));

        jButtonEditar.setBackground(new java.awt.Color(255, 153, 0));
        jButtonEditar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonEditar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEditar.setText("Editar");

        jLabelNovoPreco.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelNovoPreco.setText("Novo Preço:");

        jTextFieldNovoNome.setBackground(new java.awt.Color(255, 255, 255));

        jLabelNovaQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelNovaQuantidade.setText("Nova Quantidade:");

        jTextFieldNovoPreco.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNovoPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNovoPrecoActionPerformed(evt);
            }
        });

        jLabelIdProduto.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelIdProduto.setText("ID do produto Editado:");

        jTextFieldIdProduto.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNovaQuantidade)
                    .addComponent(jLabelIdProduto)
                    .addComponent(jLabelNovoPreco)
                    .addComponent(jLabelNovoNome))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNovoPreco)
                    .addComponent(jTextFieldNovoNome)
                    .addComponent(jTextFieldNovaQuantidade)
                    .addComponent(jTextFieldIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonVoltar)
                        .addGap(216, 216, 216)
                        .addComponent(jButtonEditar)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelEditarProduto)
                        .addGap(218, 218, 218))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelEditarProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIdProduto)
                    .addComponent(jTextFieldIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNovoNome)
                    .addComponent(jTextFieldNovoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNovoPreco)
                    .addComponent(jTextFieldNovoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNovaQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNovaQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonEditar))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNovoPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNovoPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNovoPrecoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarProdutoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarProdutoWindow().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelEditarProduto;
    private javax.swing.JLabel jLabelIdProduto;
    private javax.swing.JLabel jLabelNovaQuantidade;
    private javax.swing.JLabel jLabelNovoNome;
    private javax.swing.JLabel jLabelNovoPreco;
    private javax.swing.JTextField jTextFieldIdProduto;
    private javax.swing.JTextField jTextFieldNovaQuantidade;
    private javax.swing.JTextField jTextFieldNovoNome;
    private javax.swing.JTextField jTextFieldNovoPreco;
}
