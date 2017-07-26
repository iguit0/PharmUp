package Control;

import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ControleCliente {
    
    ConexaoBD conexao = new ConexaoBD();
    Cliente cli = new Cliente();
    PreparedStatement pst = null;
    ResultSet rs = null;
        
     
    public void Salvar(Cliente cli){
        String query = "insert into cliente(nome,telefone,cpf,email,rua,numero,cidade,estado,cep) values (?,?,?,?,?,?,?,?,?)";
        conexao.Conectar();
        try{
            pst = conexao.conn.prepareStatement(query);
            
            pst.setString(1, cli.getNome());
            pst.setString(2, cli.getTelefone());
            pst.setString(3, cli.getCpf());
            pst.setString(4, cli.getEmail());
            pst.setString(5, cli.getRua());
            pst.setInt(6, cli.getNumero());
            pst.setString(7, cli.getCidade());
            pst.setString(8, cli.getEstado());
            pst.setString(9, cli.getCep());
                             
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!","Cadastro de Cliente",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante o cadastro!","Cliente",JOptionPane.ERROR_MESSAGE); 
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Favor preencher os campos obrigatórios!!","Cliente",JOptionPane.ERROR_MESSAGE); 
        }
        conexao.Desconectar();
    }
    
    public void Alterar(Cliente cli,int id){
        String query = "update cliente set nome=?,telefone=?,cpf=?,email=?,rua=?,numero=?,cidade=?,estado=?,cep=? where id_cliente=?";
        conexao.Conectar();
            try{
                pst = conexao.conn.prepareStatement(query);

                pst.setString(1, cli.getNome());
                pst.setString(2, cli.getTelefone());
                pst.setString(3, cli.getCpf());
                pst.setString(4, cli.getEmail());
                pst.setString(5, cli.getRua());
                pst.setInt(6, cli.getNumero());
                pst.setString(7, cli.getCidade());
                pst.setString(8, cli.getEstado());
                pst.setString(9, cli.getCep());
                pst.setInt(10, id);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!","Alteracao de Cliente",JOptionPane.INFORMATION_MESSAGE);      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante a alteracao!","Cliente",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }
        conexao.Desconectar();
        }
    

public void Excluir(Cliente cli,int id){
        String query = "delete from cliente where id_cliente=?";
        conexao.Conectar();
            try{
                pst = conexao.conn.prepareStatement(query);
                pst.setInt(1, id);            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!","Exclusao de Cliente",JOptionPane.INFORMATION_MESSAGE);      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro durante a exclusao!","Cliente",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
        }
        conexao.Desconectar();
        }
    

}