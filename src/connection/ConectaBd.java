/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author maxwe
 */
public class ConectaBd {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    public static Connection getConnection() throws SQLException, ClassNotFoundException{

        try{
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            JOptionPane.showMessageDialog(null, "Conectado no banco com sucesso!");

            return con;
        }   
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);

            return null;
        }
    }

    public static void closeConnection(Connection con)
    {
        try {
            if(con!=null){
                con.close();
            }
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConectaBd.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public static void closeConnection(Connection con,PreparedStatement pst)
    {
        closeConnection(con);
        try{

            if(pst!=null){
                pst.close();
            }
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConectaBd.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public static void closeConnection(Connection con,PreparedStatement pst,ResultSet rs)
    {
        closeConnection(con,pst);
    
        try {
        
            if(rs !=null){
                rs.close();
            }
        }catch (SQLException ex) {
        java.util.logging.Logger.getLogger(ConectaBd.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

}
