/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConectaBd;
import java.sql.*;
import javax.swing.JOptionPane;
import model.bean.ContaPoupanca;

/**
 *
 * @author eder
 */
public class ContaPoupancaDAO {
    public void create(ContaPoupanca contaPoupanca) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("INSERT INTO contaPoupanca(TaxaJuros) VALUES(?,)");
            
            pst.setDouble(1, contaPoupanca.getTaxaJuros());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Conta inserida com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na inserção da conta: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
    
    public void read(ContaPoupanca contaPoupanca) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("SELECT * FROM contaPoupanca(TaxaJuros) VALUES(?,)");
            
            pst.setDouble(1, contaPoupanca.getTaxaJuros());
            
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
