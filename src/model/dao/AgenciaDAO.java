/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.swing.*;
import connection.ConectaBd;
import java.sql.*;
import model.bean.Agencia;

/**
 *
 * @author eder
 */
public class AgenciaDAO {
    public void create(Agencia agencia) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("INSERT INTO agencia(id,cidade,estado) VALUES(?,?,?)");
            
            pst.setInt(1, agencia.getId());
            pst.setString(2,agencia.getCidade());
            pst.setString(3, agencia.getEstado());            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Agencia inserida com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na inserção da agencia: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
    
    public void read(Agencia agencia) throws SQLException, ClassNotFoundException
    {
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        
        try{
            pst = con.prepareStatement("SELECT * FROM agencia(id,cidade,estado) VALUES(?,?,?)");
            
            pst.setInt(1, agencia.getId());
            pst.setString(2,agencia.getCidade());
            pst.setString(3, agencia.getEstado());            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Agencia inserida com sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na inserção da agencia: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
    
    public void readEstado (String nome) throws SQLException, ClassNotFoundException {
        Agencia c = new Agencia();
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        try{
            pst = con.prepareStatement("SELECT estado FROM agencia(nome) VALUES(?)");
            nome = c.getEstado();
            pst.setString(3, nome);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na busca do Estado: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
        
        public void readCidade (String nome) throws SQLException, ClassNotFoundException {
        Agencia c = new Agencia();
        Connection con = ConectaBd.getConnection();
        PreparedStatement pst = null;
        try{
            pst = con.prepareStatement("SELECT cidade FROM agencia(nome) VALUES(?)");
            nome = c.getCidade();
            pst.setString(3, nome);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na busca da cidade: "+ ex);
        }finally{
            ConectaBd.closeConnection(con, pst);     
        }
    }
    
}
