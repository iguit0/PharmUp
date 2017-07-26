package View;

import Control.ConexaoBD;
import Control.ControleFornecedor;
import Model.Fornecedor;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaConsultaCNPJ extends javax.swing.JFrame {
    
     ConexaoBD conexao = new ConexaoBD();
     Fornecedor mod = new Fornecedor();
     ControleFornecedor control = new ControleFornecedor();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaConsultaCNPJ() {
       initComponents();
        this.setLocationRelativeTo(null);
        IconeAplicacao();
        refresh(mod);      
    }
    
       private Fornecedor refresh(Fornecedor mod){
      String query = "select * from fornecedor where cnpj=?";
         conexao.Conectar();
      try{
          pst = conexao.conn.prepareStatement(query);
          pst.setString(1, jTextFieldConsultaCNPJ.getText());         
          rs = pst.executeQuery();
          jTableConsultaCNPJ.setModel((DbUtils.resultSetToTableModel(rs)));
      }catch(SQLException e){
        System.err.println("Nao foi possivel conectar ao Banco de Dados.");
        JOptionPane.showMessageDialog(null,"Nao foi possivel recuperar dados!","Falha no Banco",JOptionPane.ERROR_MESSAGE);
      }
        return mod;
  }
    
    private void voltarTela(){
        conexao.Desconectar();
        this.dispose();
    }
    
     private void LimparCampos(){
        jTextFieldConsultaCNPJ.setText(null);
    }
    
    //Setando ícone da aplicação
    private void IconeAplicacao(){
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icone-aplicacao.png")).getImage());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldConsultaCNPJ = new javax.swing.JFormattedTextField();
        jButtonPesquisaCNPJ = new javax.swing.JButton();
        jLabelConsultaporCNPJ = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsultaCNPJ = new javax.swing.JTable();
        jButtonVoltar = new javax.swing.JButton();
        jButtonAtualiza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar CNPJ - PharmUp v1.0");

        jLabel1.setText("Digite o CNPJ:");

        try {
            jTextFieldConsultaCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldConsultaCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldConsultaCNPJActionPerformed(evt);
            }
        });
        jTextFieldConsultaCNPJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldConsultaCNPJKeyPressed(evt);
            }
        });

        jButtonPesquisaCNPJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom.png"))); // NOI18N
        jButtonPesquisaCNPJ.setText("Pesquisar");
        jButtonPesquisaCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaCNPJActionPerformed(evt);
            }
        });

        jLabelConsultaporCNPJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelConsultaporCNPJ.setText("CONSULTA POR CNPJ");

        jTableConsultaCNPJ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableConsultaCNPJ);

        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_left.png"))); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonAtualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_refresh.png"))); // NOI18N
        jButtonAtualiza.setText("Atualizar");
        jButtonAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAtualiza)
                        .addGap(157, 157, 157)
                        .addComponent(jLabelConsultaporCNPJ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVoltar)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsultaCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisaCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelConsultaporCNPJ)
                        .addComponent(jButtonAtualiza))
                    .addComponent(jButtonVoltar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPesquisaCNPJ, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldConsultaCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldConsultaCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldConsultaCNPJActionPerformed

    }//GEN-LAST:event_jTextFieldConsultaCNPJActionPerformed

    private void jTextFieldConsultaCNPJKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConsultaCNPJKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            refresh(mod);
        }
    }//GEN-LAST:event_jTextFieldConsultaCNPJKeyPressed

    private void jButtonPesquisaCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaCNPJActionPerformed
        refresh(mod);
    }//GEN-LAST:event_jButtonPesquisaCNPJActionPerformed

    private void jButtonAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaActionPerformed
        refresh(mod);
    }//GEN-LAST:event_jButtonAtualizaActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        voltarTela();
    }//GEN-LAST:event_jButtonVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualiza;
    private javax.swing.JButton jButtonPesquisaCNPJ;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelConsultaporCNPJ;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsultaCNPJ;
    private javax.swing.JFormattedTextField jTextFieldConsultaCNPJ;
    // End of variables declaration//GEN-END:variables
}
