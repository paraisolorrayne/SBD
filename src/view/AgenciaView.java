/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConectaBd;
import java.sql.*;
import javax.swing.*;
import model.bean.Agencia;
import model.dao.AgenciaDAO;

/**
 *
 * @author eder
 */
public class AgenciaView extends JFrame {
    // Variables declaration - do not modify                     
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButtonCadastrar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JTextField txtCidade;
    private JTextField txtEstado;
    private JTextField txtdId;
    // End of variables declaration

    /**
     * Creates new form AgenciaView
     */
    public AgenciaView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        Agencia ag = new Agencia();
        AgenciaDAO agDAO = new AgenciaDAO();

        ag.setId(Integer.parseInt(txtdId.getText()));
        ag.setCidade(txtCidade.getText());
        ag.setEstado(txtEstado.getText());

        try {
            agDAO.create(ag);
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
    }                                                

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        
        Connection con = ConectaBd.getConnection();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgenciaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
