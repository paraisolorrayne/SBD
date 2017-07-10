/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConectaBd;
import java.sql.*;
import javax.swing.JOptionPane;
import model.bean.OperacaoBancaria;

/**
 *
 * @author eder
 */
public class OperacaoBancariaDAO {
    public void create(OperacaoBancaria operacao) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("INSERT INTO conta(id,Saldo,Data_Criacao, Data_UltimoAcesso) VALUES(?,?,?,?)");
            
            pst.setDate(1, operacao.getData());
            pst.setString(2, operacao.getDescricao());
            pst.setString(3, operacao.getNumSequencia());
            pst.setString(4, operacao.getTipo());
            pst.setDouble(5, operacao.getValor());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Operacao inserida com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na inserção da operacao: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
    
    public void read(OperacaoBancaria operacao) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("SELECT * FROM conta(id,Saldo,Data_Criacao, Data_UltimoAcesso) VALUES(?,?,?,?)");
            
            pst.setDate(1, operacao.getData());
            pst.setString(2, operacao.getDescricao());
            pst.setString(3, operacao.getNumSequencia());
            pst.setString(4, operacao.getTipo());
            pst.setDouble(5, operacao.getValor());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Operacao inserida com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na inserção da operacao: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
}
