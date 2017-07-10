/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.swing.*;
import connection.ConectaBd;
import java.sql.*;
import model.bean.Cupom;
/**
 *
 * @author eder
 */
public class CupomDAO {
    public void create(Cupom cupom) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("INSERT INTO cumpo(num,validade) VALUES(?,?)");
            
            pst.setInt(1, cupom.getNum());
            pst.setString(2,cupom.getValidade());           
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cumpo inserido com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na inserção do cupom: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
    
    public void read(Cupom cupom) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("SELECT * FROM cumpo(num,validade) VALUES(?,?)");
            
            pst.setInt(1, cupom.getNum());
            pst.setString(2,cupom.getValidade());           
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cumpo inserido com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na inserção do cupom: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
}
