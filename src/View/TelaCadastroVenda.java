package View;

import Control.ConexaoBD;
import Control.ControleVenda;
import Model.Cliente;
import Model.Funcionario;
import Model.Produto;
import Model.Venda;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaCadastroVenda extends javax.swing.JFrame {
    
    Connection conexao1 = null; 
    PreparedStatement pst = null;
    ResultSet rs = null;
    ConexaoBD conexao = new ConexaoBD();
    Cliente cli = new Cliente();
    Produto prod = new Produto();
    Venda v = new Venda();
    Funcionario f = new Funcionario();
    ControleVenda control = new ControleVenda();
    TelaFuncionario func = new TelaFuncionario();
    
    public TelaCadastroVenda() {
        initComponents();
        this.setLocationRelativeTo(null);
        IconeAplicacao();
        refreshCliente(cli);
        refreshProduto(prod);
    }
    
     //Setando ícone da aplicação
    private void IconeAplicacao(){
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icone-aplicacao.png")).getImage());
    }
        
     private void voltarTela(){
        conexao.Desconectar();
        this.dispose();
    }
    
    private Cliente refreshCliente(Cliente cli){
      String query = "select * from cliente where cpf=?";
         conexao.Conectar();
      try{
          pst = conexao.conn.prepareStatement(query);
          pst.setString(1, jTextFieldConsultaCPF.getText());         
          rs = pst.executeQuery();
          jTableCliente.setModel((DbUtils.resultSetToTableModel(rs)));
      }catch(SQLException e){
        System.err.println("Nao foi possivel conectar ao Banco de Dados.");
        JOptionPane.showMessageDialog(null,"Nao foi possivel recuperar dados!","Falha no Banco",JOptionPane.ERROR_MESSAGE);
      }
        return cli;
  }
           
  private Produto refreshProduto(Produto prod){
      String query = "select * from produto where nome=?";
         conexao.Conectar();
      try{
          pst = conexao.conn.prepareStatement(query);
          pst.setString(1, jTextFieldPesquisaProduto.getText());         
          rs = pst.executeQuery();
          jTableProduto.setModel((DbUtils.resultSetToTableModel(rs)));
      }catch(SQLException e){
        System.err.println("Nao foi possivel conectar ao Banco de Dados.");
        JOptionPane.showMessageDialog(null,"Nao foi possivel recuperar dados!","Falha no Banco",JOptionPane.ERROR_MESSAGE);
      }
        return prod;
  }
  
    private double CalcularTotalPedido(){
        double total = 0.0;
        if(jTableProduto.getSelectedRow() != -1){
            double preco_produtos = (double) jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 3);
            int qtd_pedido = jComboBoxQuantidade.getSelectedIndex();
            qtd_pedido++;
            total = preco_produtos*qtd_pedido;
        }
        return total;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonFecharVenda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jButtonRefreshTableCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDataVenda = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxQuantidade = new javax.swing.JComboBox<>();
        jTextFieldConsultaCPF = new javax.swing.JFormattedTextField();
        jButtonVoltar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPesquisaProduto = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        jButtonVerificarEstoque = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldValorTotal = new javax.swing.JTextField();
        jButtonRefreshTableProduct = new javax.swing.JButton();
        jButtonCalcularTotalPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Venda - PharmUp v1.0");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonFecharVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cart_go.png"))); // NOI18N
        jButtonFecharVenda.setText("Fechar Venda");
        jButtonFecharVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharVendaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cart.png"))); // NOI18N
        jLabel1.setText("CADASTRO DE VENDAS");

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCliente);

        jButtonRefreshTableCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_refresh.png"))); // NOI18N
        jButtonRefreshTableCliente.setText("Atualizar");
        jButtonRefreshTableCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshTableClienteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Quantidade:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Data da Venda:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("CPF:");

        jComboBoxQuantidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));

        try {
            jTextFieldConsultaCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldConsultaCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldConsultaCPFActionPerformed(evt);
            }
        });
        jTextFieldConsultaCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldConsultaCPFKeyPressed(evt);
            }
        });

        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_left.png"))); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom.png"))); // NOI18N
        jButton4.setText("Pesquisar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Digite o nome do Produto:");

        jTextFieldPesquisaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaProdutoKeyPressed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom.png"))); // NOI18N
        jButton5.setText("Pesquisar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProduto);

        jButtonVerificarEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirm.png"))); // NOI18N
        jButtonVerificarEstoque.setText("Verificar Estoque");
        jButtonVerificarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerificarEstoqueActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Valor Total");

        jTextFieldValorTotal.setEditable(false);
        jTextFieldValorTotal.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldValorTotal.setText("R$");
        jTextFieldValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorTotalActionPerformed(evt);
            }
        });

        jButtonRefreshTableProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_refresh.png"))); // NOI18N
        jButtonRefreshTableProduct.setText("Atualizar");
        jButtonRefreshTableProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshTableProductActionPerformed(evt);
            }
        });

        jButtonCalcularTotalPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calculator.png"))); // NOI18N
        jButtonCalcularTotalPedido.setText("Calcular Total Pedido");
        jButtonCalcularTotalPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularTotalPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButtonVerificarEstoque)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 58, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCalcularTotalPedido)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonFecharVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonVoltar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRefreshTableProduct, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldConsultaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRefreshTableCliente)))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonRefreshTableCliente, jButtonRefreshTableProduct});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton4, jButton5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldConsultaCPF, jTextFieldPesquisaProduto});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCalcularTotalPedido, jButtonFecharVenda});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRefreshTableCliente)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldConsultaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVerificarEstoque)
                    .addComponent(jButtonRefreshTableProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonFecharVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCalcularTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonRefreshTableCliente, jButtonRefreshTableProduct});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDataVenda, jLabel4, jTextFieldValorTotal});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton4, jButton5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldConsultaCPF, jTextFieldPesquisaProduto});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCalcularTotalPedido, jButtonFecharVenda});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1214, 475));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        refreshProduto(prod);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        refreshCliente(cli);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        voltarTela();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTextFieldConsultaCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConsultaCPFKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                refreshCliente(cli);
            }
    }//GEN-LAST:event_jTextFieldConsultaCPFKeyPressed

    private void jTextFieldConsultaCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldConsultaCPFActionPerformed
//
    }//GEN-LAST:event_jTextFieldConsultaCPFActionPerformed

    private void jButtonRefreshTableClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshTableClienteActionPerformed
        refreshCliente(cli);
    }//GEN-LAST:event_jButtonRefreshTableClienteActionPerformed

    private void jButtonRefreshTableProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshTableProductActionPerformed
        refreshProduto(prod);
    }//GEN-LAST:event_jButtonRefreshTableProductActionPerformed

    private void jTextFieldPesquisaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaProdutoKeyPressed
           if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                refreshProduto(prod);
            }
    }//GEN-LAST:event_jTextFieldPesquisaProdutoKeyPressed

    private void jButtonFecharVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharVendaActionPerformed
        if(jDataVenda == null){
            JOptionPane.showMessageDialog(null,"Preencha a data da venda!","Cadastro de Venda",JOptionPane.ERROR_MESSAGE);     
        }else if(jTableProduto.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null,"Selecione um produto","Cadastro de Venda",JOptionPane.ERROR_MESSAGE);                         
        }else if(jTableCliente.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null,"Selecione um cliente","Cadastro de Venda",JOptionPane.ERROR_MESSAGE);                         
        }else{
            int confirmar = JOptionPane.showConfirmDialog(null, "Voce tem certeza?", "Cadastrar Venda", JOptionPane.YES_NO_OPTION);
                if(confirmar == 0){
                    int row = jTableProduto.getSelectedRow();
                    int estoque = (int) (jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 5));
                    int id_produto = (int) (jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 0));
                    int qtd_venda = jComboBoxQuantidade.getSelectedIndex();
                    qtd_venda++;
                    int id = (int) (jTableCliente.getModel().getValueAt(jTableCliente.getSelectedRow(), 0));
                    v.setData(jDataVenda.getDate());
                    v.setQntd_venda(qtd_venda);
                    v.setValortotal(CalcularTotalPedido());
                    v.setCod_funcionario(id);
                    v.setCod_cliente(id);            
                        if(control.Salvar(v) == true){
                            JOptionPane.showMessageDialog(null,"Venda cadastrada com sucesso!","Cadastro de Venda",JOptionPane.INFORMATION_MESSAGE);                                    
                            estoque-=qtd_venda;
                            prod.setQntd_estoque(estoque);
                            control.Alterar(prod, id_produto);
                        }
                }
            }
    }//GEN-LAST:event_jButtonFecharVendaActionPerformed

    private void jTableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutoMouseClicked

    }//GEN-LAST:event_jTableProdutoMouseClicked

    private void jTableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClienteMouseClicked
    
    }//GEN-LAST:event_jTableClienteMouseClicked

    private void jButtonVerificarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerificarEstoqueActionPerformed
        if(jTableProduto.getSelectedRow() != -1){
            int qtd_estoque = (int) jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 5);
            int qtd_pedido = jComboBoxQuantidade.getSelectedIndex();
            qtd_pedido++;
            if(qtd_estoque < qtd_pedido){
                JOptionPane.showMessageDialog(null,"Estoque insuficiente!","Estoque de produto",JOptionPane.ERROR_MESSAGE);     
            }else{
                JOptionPane.showMessageDialog(null,"Estoque suficiente!","Estoque de produto",JOptionPane.INFORMATION_MESSAGE);     
            }       
        }
    }//GEN-LAST:event_jButtonVerificarEstoqueActionPerformed

    private void jButtonCalcularTotalPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularTotalPedidoActionPerformed
        String total = "";
        if(jTableProduto.getSelectedRow() != -1){
            double preco_produtos = (double) jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 3);
            int qtd_pedido = jComboBoxQuantidade.getSelectedIndex();
            qtd_pedido++;
            preco_produtos*=qtd_pedido;
            total = String.valueOf(preco_produtos);
            jTextFieldValorTotal.setText("R$ "+total);      
        }else{
            JOptionPane.showMessageDialog(null,"Selecione pelo menos um produto","Cadastro de Venda",JOptionPane.ERROR_MESSAGE);                         
        }  
    }//GEN-LAST:event_jButtonCalcularTotalPedidoActionPerformed

    private void jTextFieldValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorTotalActionPerformed
        //
    }//GEN-LAST:event_jTextFieldValorTotalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonCalcularTotalPedido;
    private javax.swing.JButton jButtonFecharVenda;
    private javax.swing.JButton jButtonRefreshTableCliente;
    private javax.swing.JButton jButtonRefreshTableProduct;
    private javax.swing.JButton jButtonVerificarEstoque;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxQuantidade;
    private com.toedter.calendar.JDateChooser jDataVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JFormattedTextField jTextFieldConsultaCPF;
    private javax.swing.JTextField jTextFieldPesquisaProduto;
    private javax.swing.JTextField jTextFieldValorTotal;
    // End of variables declaration//GEN-END:variables
}
