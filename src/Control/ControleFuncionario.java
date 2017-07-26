package Control;

import Model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleFuncionario {
    
    ConexaoBD conexao = new ConexaoBD();
    Funcionario func = new Funcionario();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void Salvar(Funcionario func){
        String query = "insert into funcionario(nome,telefone,usuario,senha,permissao) values (?,?,?,?,?)";
        conexao.Conectar();
        try{
            pst = conexao.conn.prepareStatement(query);
            
            pst.setString(1, func.getNome());
            pst.setString(2, func.getTelefone());
            pst.setString(3, func.getUsuario());
            pst.setString(4, func.getSenha());
            pst.setString(5, func.getPermissao());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!","Cadastro de Funcionario",JOptionPane.INFORMATION_MESSAGE);         
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante o cadastro!","Cadastro de Funcionario",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }
        conexao.Desconectar();
    }
    
    public void Alterar(Funcionario func,int id){
        String query = "update funcionario set nome=?,telefone=?,usuario=?,senha=?,permissao=? where id_funcionario=?";
        conexao.Conectar();
        try{
            pst = conexao.conn.prepareStatement(query);
            
            pst.setString(1, func.getNome());
            pst.setString(2, func.getTelefone());
            pst.setString(3, func.getUsuario());
            pst.setString(4, func.getSenha());
            pst.setString(5, func.getPermissao());
            pst.setInt(6, id);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso!","Alteracao de Funcionario",JOptionPane.INFORMATION_MESSAGE);         
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante a alteracao!","Alteracao de Funcionario",JOptionPane.ERROR_MESSAGE); 
            e.printStackTrace();
        }
        conexao.Desconectar();
    }
    
    public void Excluir(Funcionario func,int id){
        String query = "delete from funcionario where id_funcionario=?";
        conexao.Conectar();
        try{
            pst = conexao.conn.prepareStatement(query);
            pst.setInt(1, id);  
       pst.execute();
            JOptionPane.showMessageDialog(null, "Funcionario excluido com sucesso!","Exclusao de Cliente",JOptionPane.INFORMATION_MESSAGE);      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante a exclusao!","Funcionario",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }
        conexao.Desconectar();
        }
  
}
