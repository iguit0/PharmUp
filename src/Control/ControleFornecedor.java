package Control;

import Model.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleFornecedor {
    
    ConexaoBD conexao = new ConexaoBD();
    Fornecedor forn = new Fornecedor();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void Salvar(Fornecedor forn){
        String query = "insert into fornecedor(nome,telefone,cnpj,email) values (?,?,?,?)";
        conexao.Conectar();
        try {
            pst = conexao.conn.prepareStatement(query);
            pst.setString(1, forn.getNome());
            pst.setString(2, forn.getTelefone());
            pst.setString(3, forn.getCnpj());
            pst.setString(4, forn.getEmail());
                   
                pst.execute();
                JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!","Cadastro de Fornecedor",JOptionPane.INFORMATION_MESSAGE);  
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante o cadastro!","Cliente",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }
        conexao.Desconectar();
    }
    
    public void Alterar(Fornecedor forn, int id){
        String query = "update fornecedor set nome=?,telefone=?,cnpj=?,email=? where id_fornecedor=?";
        conexao.Conectar();
          try {
            pst = conexao.conn.prepareStatement(query);
            pst.setString(1, forn.getNome());
            pst.setString(2, forn.getTelefone());
            pst.setString(3, forn.getCnpj());
            pst.setString(4, forn.getEmail());
            pst.setInt(5, id);
            
                pst.execute();
                JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!","Cadastro de Fornecedor",JOptionPane.INFORMATION_MESSAGE);  
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante o cadastro!","Cliente",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }
        conexao.Desconectar();
    }
    
    public void Excluir(Fornecedor forn, int id){
          String query = "delete from fornecedor where id_fornecedor=?";
        conexao.Conectar();
            try{
                pst = conexao.conn.prepareStatement(query);
                pst.setInt(1, id);            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso!","Exclusao de Fornecedor",JOptionPane.INFORMATION_MESSAGE);      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante a exclusao!","Fornecedor",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }
        conexao.Desconectar();       
    }
        
}
