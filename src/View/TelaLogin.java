package View;

import Control.ConexaoBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

    ResultSet rs = null;
    PreparedStatement pst = null;  
    
    ConexaoBD conexao = new ConexaoBD();
    
    public TelaLogin() {
        initComponents();
        IconeAplicacao();
        this.setLocationRelativeTo(null);
        StatusBanco();
    }
    
    //Setando ícone da aplicação
    private void IconeAplicacao(){
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icone-aplicacao.png")).getImage());
    }
    
    //Entrar no Sistema
    private void Entrar(){
        String query = "select * from funcionario where usuario=? and senha=?";
        
        try{
            pst = conexao.conn.prepareStatement(query);
            pst.setString(1, jTextFieldUsuario.getText());
            pst.setString(2, jPasswordFieldSenha.getText());
            
            rs = pst.executeQuery();
            if(rs.next()){
                try{
                    pst.close();
                    rs.close();
                    conexao.Desconectar();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Nao foi possivel desconectar!","Falha no Logout",JOptionPane.ERROR_MESSAGE);           
                }
                JOptionPane.showMessageDialog(null,"Bem Vindo(a): "+jTextFieldUsuario.getText(),"Acesso ao Sistema",JOptionPane.INFORMATION_MESSAGE);           
                new TelaPrincipal(jTextFieldUsuario.getText()).setVisible(true);
                this.dispose();
            }else if(jTextFieldUsuario.getText().isEmpty() && jPasswordFieldSenha.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Campos de Usuario e Senha em branco!","Falha na autenticação",JOptionPane.ERROR_MESSAGE);           
            }else{
                JOptionPane.showMessageDialog(null,"Usuario ou senha incorretos!","Falha na autenticação",JOptionPane.ERROR_MESSAGE);           
            }                   
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Usuario ou senha incorretos!","Falha na autenticação",JOptionPane.ERROR_MESSAGE);           
            System.err.println("Erro ao conectar ao Banco de Dados.");
        }
    }
    
    
    //Muda o Status do Banco (conectado ou sem conexão)
    private void StatusBanco(){
        if(conexao.Status() == true){
            jLabelStatusDoBanco.setText("Conectado");
            jLabelStatusDoBanco.setForeground(Color.blue);
            jLabelStatusDoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database.png")));
        }else{
            jLabelStatusDoBanco.setText("Sem conexão");
            jLabelStatusDoBanco.setForeground(Color.red);
            jLabelStatusDoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database_error.png")));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUser = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButtonAcessar = new javax.swing.JButton();
        jLabelSenha = new javax.swing.JLabel();
        jLabelStatusDoBanco = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();
        jLabelLogoMegaPharma = new javax.swing.JLabel();
        jLabelFundoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - PharmUp v1.0");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-doctor.png"))); // NOI18N
        getContentPane().add(jLabelUser);
        jLabelUser.setBounds(300, 200, 130, 150);

        jLabelCPF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelCPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCPF.setText("Usuário:");
        getContentPane().add(jLabelCPF);
        jLabelCPF.setBounds(150, 380, 60, 20);

        jPasswordFieldSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(220, 440, 290, 30);

        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(220, 380, 290, 30);

        jButtonAcessar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N
        jButtonAcessar.setText("Acessar");
        jButtonAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcessarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAcessar);
        jButtonAcessar.setBounds(500, 490, 110, 40);

        jLabelSenha.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSenha.setText("Senha:");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(150, 440, 60, 20);

        jLabelStatusDoBanco.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(jLabelStatusDoBanco);
        jLabelStatusDoBanco.setBounds(10, 520, 120, 30);

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(610, 490, 90, 40);

        jLabelLogoMegaPharma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-megapharma.png"))); // NOI18N
        getContentPane().add(jLabelLogoMegaPharma);
        jLabelLogoMegaPharma.setBounds(110, 0, 500, 190);

        jLabelFundoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundo_telaLogin.jpg"))); // NOI18N
        getContentPane().add(jLabelFundoLogin);
        jLabelFundoLogin.setBounds(0, 0, 730, 580);

        setSize(new java.awt.Dimension(719, 598));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

    private void jButtonAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcessarActionPerformed
        if(conexao.Status() == false){
            System.err.println("Erro ao conectar ao Banco de Dados.");
            JOptionPane.showMessageDialog(null,"Banco de dados não conectado!","Falha na autenticação",JOptionPane.ERROR_MESSAGE);
        }else{
            Entrar();
        }
    }//GEN-LAST:event_jButtonAcessarActionPerformed

    private void jPasswordFieldSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            Entrar();
        }
    }//GEN-LAST:event_jPasswordFieldSenhaKeyPressed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcessar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelFundoLogin;
    private javax.swing.JLabel jLabelLogoMegaPharma;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelStatusDoBanco;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
