/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.swing.*;
import connection.ConectaBd;
import java.sql.*;
import model.bean.Emprestimo;

/**
 *
 * @author eder
 */
public class EmprestimoDAO {
    public void create(Emprestimo emprestimo) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("INSERT INTO emprestimo(idEmprestimo,QtdParcelas,valor) VALUES(?,?,?)");
            
            pst.setInt(1, emprestimo.getId());
            pst.setInt(2,emprestimo.getParcelas());
            pst.setDouble(3, emprestimo.getValor());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Emprestimo inserido com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na inserção do emprestimo: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
    
    
}
