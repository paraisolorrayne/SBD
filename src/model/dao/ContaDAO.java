/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConectaBd;
import java.sql.*;
import javax.swing.JOptionPane;
import model.bean.Conta;

/**
 *
 * @author eder
 */
public class ContaDAO {
    
    public void create(Conta conta) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("INSERT INTO conta(id,Saldo,Data_Criacao, Data_UltimoAcesso) VALUES(?,?,?,?)");
            
            pst.setInt(1, conta.getId());
            pst.setDouble(2, conta.getSaldo());
            pst.setDate(3, conta.getDataCriacao());
            pst.setDate(4,conta.getDataUltimoAcesso());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Conta inserida com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na inserção da conta: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
    
}
