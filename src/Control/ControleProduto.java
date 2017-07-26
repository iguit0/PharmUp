package Control;

import Model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleProduto {
    
    ConexaoBD conexao = new ConexaoBD();
    Produto prod = new Produto();
    PreparedStatement pst = null;
    ResultSet rs = null;
       
    public void Salvar(Produto prod){
        String query = "insert into produto(nome,descricao,precounitario,categoria,qntd_estoque,cod_fornecedor) values (?,?,?,?,?,?)";
        conexao.Conectar();
        try{
            pst = conexao.conn.prepareStatement(query);
            
            pst.setString(1, prod.getNome());
            pst.setString(2, prod.getDescricao());
            pst.setDouble(3, prod.getPrecounitario());
            pst.setString(4, prod.getCategoria());
            pst.setInt(5, prod.getQntd_estoque());
            pst.setInt(6, prod.getCod_fornecedor());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!","Cadastro de Produto",JOptionPane.INFORMATION_MESSAGE);
          
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante o cadastro!","Cadastro de Produto",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }
        conexao.Desconectar();
    }
    
    
      public void Alterar(Produto prod,int id){
        String query = "update produto set nome=?,descricao=?,precounitario=?,categoria=?,qntd_estoque=?,cod_fornecedor=? where id_produto=?";
        conexao.Conectar();
            try{
                pst = conexao.conn.prepareStatement(query);

            pst.setString(1, prod.getNome());
            pst.setString(2, prod.getDescricao());
            pst.setDouble(3, prod.getPrecounitario());            
            pst.setString(4, prod.getCategoria());
            pst.setInt(5, prod.getQntd_estoque());
            pst.setInt(6, prod.getCod_fornecedor());
            pst.setInt(7, id);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!","Alteracao de Produto",JOptionPane.INFORMATION_MESSAGE);      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante a alteracao do produto!","Produto",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }
        conexao.Desconectar();
        }
      
    
    public void Excluir(Produto prod,int id){
        String query = "delete from produto where id_produto=?";
        conexao.Conectar();
            try{
                pst = conexao.conn.prepareStatement(query);
                pst.setInt(1, id);            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!","Exclusao de produto",JOptionPane.INFORMATION_MESSAGE);      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante a exclusao!","Produto",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }
        conexao.Desconectar();
        }
    
   
}
