package model.dao;

import connection.ConectaBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Cliente;

/**
 *
 * @author maxwell
 */
public class ClienteDAO {
    
    public void create(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("INSERT INTO cliente(id,cpf,nome,datanasc,cidade,estado,endereco,gernumf) VALUES(?,?,?,?,?,?,?,?)");
            
            pst.setInt(1, cliente.getId());
            pst.setDouble(2, cliente.getCPF());
            pst.setString(3, cliente.getNome());
            pst.setDate(4,cliente.getDataNasc());
            pst.setString(5,cliente.getCidade());
            pst.setString(6, cliente.getEstado());
            pst.setString(7,cliente.getEndereco());
            pst.setString(8,cliente.getGernumf());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na inserção do cliente: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
    
    public void read(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("SELECT * FROM cliente(id,cpf,nome,datanasc,cidade,estado,endereco,gernumf) VALUES(?,?,?,?,?,?,?,?)");
            
            pst.setInt(1, cliente.getId());
            pst.setDouble(2, cliente.getCPF());
            pst.setString(3, cliente.getNome());
            pst.setDate(4,cliente.getDataNasc());
            pst.setString(5,cliente.getCidade());
            pst.setString(6, cliente.getEstado());
            pst.setString(7,cliente.getEndereco());
            pst.setString(8,cliente.getGernumf());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente encontrado com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na busca do cliente: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
    public void readNome (String nome) throws SQLException, ClassNotFoundException {
        Cliente c = new Cliente();
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        try{
            pst = con.prepareStatement("SELECT nome FROM cliente(nome) VALUES(?)");
            nome = c.getNome();
            pst.setString(3, nome);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na busca do cliente: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
        
    }
    
    
    
}
