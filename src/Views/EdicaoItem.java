/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import dao.ComputadorDAO;
import javax.swing.JOptionPane;
import netbeans.Computador;

/**
 *
 * @author butuk
 */
public class EdicaoItem extends javax.swing.JFrame {


    public EdicaoItem(Computador computador){
        initComponents();
        txtId.setText(String.valueOf(computador.getId()));
        txtId.setEnabled(false);
        txtNome.setText(computador.getNome());
        txtMarca.setText(computador.getMarca());
        txtPreco.setText(String.valueOf(computador.getPreco()));
        txtQuantidade.setText(String.valueOf(computador.getQuantidade()));
        txtAreaDesc.setText(computador.getDescricao());
        String tipoComputador = computador.getTipo();
        
        if(tipoComputador.equals("Notebook")){
            cbxNotebook.setSelected(true);
        }
        
        if(tipoComputador.equals("Desktop")){
            cbxDesktop.setSelected(true);
        }
        
    }
    
    public EdicaoItem() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubTitulo = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        cbxDesktop = new javax.swing.JCheckBox();
        cbxNotebook = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDesc = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("System Select - Edição de Item");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("SYSTEM SELECT");

        lblSubTitulo.setText("Edição de Item");

        jLabel3.setText("Id:");

        txtNome.setToolTipText("Informe o nome que deseja utilizar");
        txtNome.setNextFocusableComponent(txtMarca);

        jLabel4.setText("Nome:");

        btnVoltar.setText("< Voltar");
        btnVoltar.setNextFocusableComponent(txtNome);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel5.setText("Marca:");

        txtMarca.setToolTipText("Informe o nome que deseja utilizar");
        txtMarca.setNextFocusableComponent(cbxDesktop);

        cbxDesktop.setText("Desktop");
        cbxDesktop.setNextFocusableComponent(cbxNotebook);
        cbxDesktop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDesktopActionPerformed(evt);
            }
        });

        cbxNotebook.setText("Notebook");
        cbxNotebook.setNextFocusableComponent(txtPreco);
        cbxNotebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNotebookActionPerformed(evt);
            }
        });

        jLabel6.setText("Preço:");

        txtPreco.setToolTipText("Informe o nome que deseja utilizar");
        txtPreco.setNextFocusableComponent(txtQuantidade);

        jLabel7.setText("Tipo:");

        txtQuantidade.setToolTipText("Informe o nome que deseja utilizar");
        txtQuantidade.setNextFocusableComponent(txtAreaDesc);

        jLabel8.setText("Quantidade:");

        jLabel1.setText("Descrição:");

        txtAreaDesc.setColumns(20);
        txtAreaDesc.setRows(5);
        txtAreaDesc.setNextFocusableComponent(btnSalvar);
        jScrollPane1.setViewportView(txtAreaDesc);

        btnSalvar.setBackground(new java.awt.Color(0, 102, 204));
        btnSalvar.setText("Salvar");
        btnSalvar.setNextFocusableComponent(btnVoltar);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(cbxDesktop)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(cbxNotebook))
                                                .addComponent(jLabel8)
                                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtPreco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVoltar)
                                .addGap(75, 75, 75)
                                .addComponent(lblTitulo)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(208, 208, 208))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSubTitulo)
                                .addGap(180, 180, 180))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(197, 197, 197))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addComponent(lblTitulo))
                .addGap(7, 7, 7)
                .addComponent(lblSubTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxDesktop)
                            .addComponent(cbxNotebook))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        boolean validacaoForm = true;
        
        if(txtNome.getText().isEmpty()){
            validacaoForm = false;
        }
        
        if(txtMarca.getText().isEmpty()){
            validacaoForm = false;
        }
                
        if(txtPreco.getText().isEmpty()){
            validacaoForm = false;
        }
        
        if(txtQuantidade.getText().isEmpty()){
            validacaoForm = false;
        }

        if(txtAreaDesc.getText().isEmpty()){
            validacaoForm = false;
        }
        
        if(!cbxDesktop.isSelected() && !cbxNotebook.isSelected()){
            validacaoForm = false;
        }
        
        if(validacaoForm == true){
        Computador computador = new Computador();
        
        computador.setId(Integer.parseInt(txtId.getText()));
        computador.setNome(txtNome.getText());
        computador.setMarca(txtMarca.getText());
        computador.setDescricao(txtAreaDesc.getText());
        computador.setPreco(Double.parseDouble(txtPreco.getText()));
        computador.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        if(cbxDesktop.isSelected()){
            computador.setTipo("Desktop");
        }
        if(cbxNotebook.isSelected()){
            computador.setTipo("Notebook");
        }
        
        ComputadorDAO dao = new ComputadorDAO();
        dao.atualizarItem(computador);
        JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        RelatorioEstoque telaEstoque = new RelatorioEstoque();
        telaEstoque.setVisible(true);
        dispose();
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Todos os dados devem ser preenchidos."); 
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cbxDesktopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDesktopActionPerformed
        if(cbxNotebook.isSelected()){
            cbxNotebook.setSelected(false);
        }
    }//GEN-LAST:event_cbxDesktopActionPerformed

    private void cbxNotebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNotebookActionPerformed
        if(cbxDesktop.isSelected()){
            cbxDesktop.setSelected(false);
        }
    }//GEN-LAST:event_cbxNotebookActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja voltar? Todos os dados alterados não serão salvos.", "Confirmação", JOptionPane.YES_NO_OPTION);
                
        if(confirmacao == JOptionPane.YES_OPTION){
            RelatorioEstoque telaEstoque = new RelatorioEstoque();
            telaEstoque.setVisible(true);
            dispose();
            
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EdicaoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EdicaoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EdicaoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EdicaoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EdicaoItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JCheckBox cbxDesktop;
    private javax.swing.JCheckBox cbxNotebook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtAreaDesc;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
