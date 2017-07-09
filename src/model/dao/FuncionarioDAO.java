/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConectaBd;
import java.sql.*;
import javax.swing.JOptionPane;
import model.bean.Funcionario;

/**
 *
 * @author eder
 */
public class FuncionarioDAO {
    public void create(Funcionario funcionario) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("INSERT INTO funcionario(numF, nome, telefone, DataAdmissao, NomeDependentes, TempoDeServico) VALUES(?,?,?,?,?,?)");
            
            pst.setInt(1, funcionario.getNumF());
            pst.setString(2, funcionario.getNome());
            pst.setString(3, funcionario.getTelefone());
            pst.setDate(4, funcionario.getDataAdmissao());
            pst.setArray(5, funcionario.getNomeDependentes());
            pst.setString(6, funcionario.getTempoDeServico());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na inserção do funcionario: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
    
}
