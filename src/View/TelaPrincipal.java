package View;

import Control.ConexaoBD;
import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {

    ConexaoBD conn = new ConexaoBD();
    
    public TelaPrincipal(String usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        jLabelUsuarioLogado.setText(usuario);
        IconeAplicacao();
        StatusBanco();
        DataSistema();
    }
    
    //Setando ícone da aplicação
    private void IconeAplicacao(){
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icone-aplicacao.png")).getImage());
    }

    //Muda o Status do Banco (conectado, sem conexão)
    private void StatusBanco(){
        if(conn.Conectar() == true){
            jLabelStatusDoBanco.setText("Conectado");
            jLabelStatusDoBanco.setForeground(Color.blue);
            jLabelStatusDoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database.png")));
        }else if(conn.Conectar() == false){
            jLabelStatusDoBanco.setText("Sem conexão");
            jLabelStatusDoBanco.setForeground(Color.red);
            jLabelStatusDoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database_error.png")));
        }
    }
    
    private void DataSistema(){
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        Locale Brasil = new Locale("pt", "BR");
        DateFormat f1 = DateFormat.getDateInstance(DateFormat.FULL, Brasil);
        jLabel1.setText(f1.format(data));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLogoMegaPharma = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonMenuClientes = new javax.swing.JButton();
        jButtonMenuProdutos = new javax.swing.JButton();
        jButtonMenuVendas = new javax.swing.JButton();
        jButtonMenuFornecedores = new javax.swing.JButton();
        jButtonMenuLogout = new javax.swing.JButton();
        jLabelStatusDoBanco = new javax.swing.JLabel();
        jButtonTelaFuncionario = new javax.swing.JButton();
        jLabelStatusLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelUsuarioLogado = new javax.swing.JLabel();
        jLabelFundoPrincipal = new javax.swing.JLabel();
        jMenuBarTelaPrincipal = new javax.swing.JMenuBar();
        jMenuMenuPharmUp = new javax.swing.JMenu();
        jMenuPharmUpSobreoPrograma = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal - PharmUP v1.0");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabelLogoMegaPharma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-megapharma.png"))); // NOI18N
        getContentPane().add(jLabelLogoMegaPharma);
        jLabelLogoMegaPharma.setBounds(270, 20, 510, 170);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-pills-green-125.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(560, 220, 120, 110);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/medico_icon.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(370, 200, 170, 140);

        jButtonMenuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jButtonMenuClientes.setText("Clientes");
        jButtonMenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenuClientes);
        jButtonMenuClientes.setBounds(40, 470, 140, 50);

        jButtonMenuProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pill.png"))); // NOI18N
        jButtonMenuProdutos.setText("Produtos");
        jButtonMenuProdutos.setPreferredSize(new java.awt.Dimension(109, 26));
        jButtonMenuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuProdutosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenuProdutos);
        jButtonMenuProdutos.setBounds(190, 470, 140, 50);

        jButtonMenuVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cart.png"))); // NOI18N
        jButtonMenuVendas.setText("Vendas");
        jButtonMenuVendas.setPreferredSize(new java.awt.Dimension(109, 26));
        jButtonMenuVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuVendasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenuVendas);
        jButtonMenuVendas.setBounds(340, 470, 150, 50);

        jButtonMenuFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lorry.png"))); // NOI18N
        jButtonMenuFornecedores.setText("Fornecedores");
        jButtonMenuFornecedores.setPreferredSize(new java.awt.Dimension(109, 26));
        jButtonMenuFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuFornecedoresActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenuFornecedores);
        jButtonMenuFornecedores.setBounds(500, 470, 160, 50);

        jButtonMenuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-logout.png"))); // NOI18N
        jButtonMenuLogout.setText("Sair do Sistema");
        jButtonMenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenuLogout);
        jButtonMenuLogout.setBounds(840, 470, 180, 50);

        jLabelStatusDoBanco.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(jLabelStatusDoBanco);
        jLabelStatusDoBanco.setBounds(10, 590, 110, 30);

        jButtonTelaFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_gray.png"))); // NOI18N
        jButtonTelaFuncionario.setText("Funcionários");
        jButtonTelaFuncionario.setMaximumSize(new java.awt.Dimension(124, 28));
        jButtonTelaFuncionario.setMinimumSize(new java.awt.Dimension(124, 28));
        jButtonTelaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTelaFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTelaFuncionario);
        jButtonTelaFuncionario.setBounds(670, 470, 160, 50);
        getContentPane().add(jLabelStatusLogin);
        jLabelStatusLogin.setBounds(910, 10, 110, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar_view_day.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(400, 390, 430, 40);

        jLabelUser.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_suit.png"))); // NOI18N
        jLabelUser.setText("Usuário logado:");
        getContentPane().add(jLabelUser);
        jLabelUser.setBounds(400, 350, 150, 30);

        jLabelUsuarioLogado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelUsuarioLogado.setForeground(new java.awt.Color(0, 153, 51));
        getContentPane().add(jLabelUsuarioLogado);
        jLabelUsuarioLogado.setBounds(550, 350, 120, 30);

        jLabelFundoPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFundoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Free-HD-Light-Blue-Wallpaper-Download.jpg"))); // NOI18N
        jLabelFundoPrincipal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabelFundoPrincipal);
        jLabelFundoPrincipal.setBounds(0, 0, 1080, 640);

        jMenuMenuPharmUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/small-blue-pill-icon-19994.png"))); // NOI18N
        jMenuMenuPharmUp.setText("PharmUp");

        jMenuPharmUpSobreoPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/information.png"))); // NOI18N
        jMenuPharmUpSobreoPrograma.setText("Sobre o Programa");
        jMenuPharmUpSobreoPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPharmUpSobreoProgramaActionPerformed(evt);
            }
        });
        jMenuMenuPharmUp.add(jMenuPharmUpSobreoPrograma);

        jMenuItemSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuMenuPharmUp.add(jMenuItemSair);

        jMenuBarTelaPrincipal.add(jMenuMenuPharmUp);

        setJMenuBar(jMenuBarTelaPrincipal);

        setSize(new java.awt.Dimension(1076, 682));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuFornecedoresActionPerformed
        new TelaFornecedor().setVisible(true);
    }//GEN-LAST:event_jButtonMenuFornecedoresActionPerformed

    private void jButtonMenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuClientesActionPerformed
        new TelaCliente().setVisible(true);
    }//GEN-LAST:event_jButtonMenuClientesActionPerformed

    private void jButtonMenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuLogoutActionPerformed
            conn.Desconectar();
            JOptionPane.showMessageDialog(null,"Você saiu do sistema!","Logout",JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new TelaLogin().setVisible(true);      
    }//GEN-LAST:event_jButtonMenuLogoutActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
       conn.Desconectar();
        JOptionPane.showMessageDialog(null,"Você saiu do sistema!","Logout",JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new TelaLogin().setVisible(true);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jButtonMenuVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuVendasActionPerformed
        new TelaVenda().setVisible(true);
    }//GEN-LAST:event_jButtonMenuVendasActionPerformed

    private void jMenuPharmUpSobreoProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPharmUpSobreoProgramaActionPerformed
        new TelaSobreOPrograma().setVisible(true);
    }//GEN-LAST:event_jMenuPharmUpSobreoProgramaActionPerformed

    private void jButtonMenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuProdutosActionPerformed
        new TelaProduto().setVisible(true);      
    }//GEN-LAST:event_jButtonMenuProdutosActionPerformed

    private void jButtonTelaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTelaFuncionarioActionPerformed
        new TelaFuncionario().setVisible(true);
    }//GEN-LAST:event_jButtonTelaFuncionarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMenuClientes;
    private javax.swing.JButton jButtonMenuFornecedores;
    private javax.swing.JButton jButtonMenuLogout;
    private javax.swing.JButton jButtonMenuProdutos;
    private javax.swing.JButton jButtonMenuVendas;
    private javax.swing.JButton jButtonTelaFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelFundoPrincipal;
    private javax.swing.JLabel jLabelLogoMegaPharma;
    private javax.swing.JLabel jLabelStatusDoBanco;
    private javax.swing.JLabel jLabelStatusLogin;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLabel jLabelUsuarioLogado;
    private javax.swing.JMenuBar jMenuBarTelaPrincipal;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenu jMenuMenuPharmUp;
    private javax.swing.JMenuItem jMenuPharmUpSobreoPrograma;
    // End of variables declaration//GEN-END:variables
}
