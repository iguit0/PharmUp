package Control;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
 
public class ConexaoBD {  
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/pharmup_bd";
    private String usuario = "pharmupdba";
    private String senha = "EJpKovPSKsM6m9Wl";
    public Connection conn;
    public ResultSet rs;
    
    //conexao com o bd
    public boolean Conectar() {
        try {
            System.setProperty("jdbc.Drivers",driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);           
            return true;
        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null,"Erro ao se conectar com banco de dados!"+ex.getMessage(),"Falha na autenticação",JOptionPane.ERROR_MESSAGE);           
            return false;
         }
    }       
    
    //retorna status (estado) da conexao
    public boolean Status(){
        if(Conectar() == true){
            System.out.println("BD Conectado!");
            return true;
        }else{
            System.err.println("BD Desconectado!");
            return false;
        }
    }
    
    //desconecta (fecha) conexao
    public boolean Desconectar(){
        try{
            conn.close();            
            return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao se desconectar com banco de dados!"+ex.getMessage(),"Falha no Logout",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}   