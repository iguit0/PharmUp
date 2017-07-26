package Control;

import Model.Produto;
import Model.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleVenda {
    
    ConexaoBD conexao = new ConexaoBD();
    Venda v = new Venda();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public boolean Salvar(Venda v){
        String query = "insert into venda(data,qntd_venda,valortotal,cod_funcionario,cod_cliente) values (?,?,?,?,?)";
        conexao.Conectar();
        try{
            pst = conexao.conn.prepareStatement(query);
            
            pst.setDate(1, new java.sql.Date(v.getData().getTime()));
            pst.setInt(2, v.getQntd_venda());
            pst.setDouble(3, v.getValortotal());
            pst.setDouble(4, v.getCod_funcionario());
            pst.setInt(5, v.getCod_cliente());
            
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!","Cadastro de venda",JOptionPane.INFORMATION_MESSAGE);
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante a venda!","Cadastro de Venda",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Selecione uma data!","Cadastro de Venda",JOptionPane.ERROR_MESSAGE); 
            ex.getMessage();
            return false;
        }
        conexao.Desconectar();
        return false;
    }
    
    public void Alterar(Produto prod,int id){
        String query = "update produto set qntd_estoque=? where id_produto=?";
        conexao.Conectar();
            try{
                pst = conexao.conn.prepareStatement(query);

            pst.setInt(1, prod.getQntd_estoque());
            pst.setInt(2, id);
            
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!","Alteracao de Produto",JOptionPane.INFORMATION_MESSAGE);      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante a alteracao do produto!","Produto",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }
        conexao.Desconectar();
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
