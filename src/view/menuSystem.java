/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eder
 */

package view;

import javax.swing.*;
import java.awt.event.*;


public class menuSystem extends JFrame{
    // JPanel
    JPanel menu = new JPanel();
    // Buttons
    JButton btnCadastroCliente = new JButton("Cadastro Cliente");
    JButton btnCadastroAgencia = new JButton("Cadastro Agencia");
    JButton btnCadastroFuncionario = new JButton("Cadastro Funcionário");
    JButton btnConsultaCliente = new JButton("Consulta Cliente");
    JButton btnConsultaClienteAgencia = new JButton("Consulta Cliente por Agencia");
    
    public menuSystem() {
        super();
        // TODO Auto-generated constructor stub
        initialize();
            
    }
    
    private void initialize(){
        // JFrame properties
        this.setTitle("Sistema Bancário SBD");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(700,400);
        this.setVisible(true);
        btnCadastroCliente.setBounds(100, 400, 220, 50);
        btnCadastroAgencia.setBounds(100, 300, 220, 50);
        btnCadastroFuncionario.setBounds(200, 200, 220, 50);
        btnConsultaCliente.setBounds(100, 100, 220, 50);
        btnConsultaClienteAgencia.setBounds(100, 100, 220, 50);
        // JPanel bounds
        menu.setBounds(500, 500, 80, 100);
        // Adding to JFrame
        menu.add(btnCadastroCliente);
        menu.add(btnCadastroAgencia);
        menu.add(btnCadastroFuncionario);
        menu.add(btnConsultaCliente);
        menu.add(btnConsultaClienteAgencia);
        add(menu);
        //abre cadastro cliente
        btnCadastroCliente.addActionListener((ActionEvent e) -> {
            new ClienteView().setVisible(true);
        });
        //abre cadastro agencia
        btnCadastroAgencia.addActionListener((ActionEvent e) -> {
            new AgenciaView().setVisible(true);
        });
        //abre cadastro funcionario
        btnCadastroFuncionario.addActionListener((ActionEvent e) -> {
            new FuncionarioView().setVisible(true);
        });
        //abre consulta cliente
        btnConsultaCliente.addActionListener((ActionEvent e) -> {
            new ConsultaClienteView().setVisible(true);
        });
        //abre consulta cliente agencia
        btnConsultaClienteAgencia.addActionListener((ActionEvent e) -> {
            new ConsultaClienteAgencia().setVisible(true);
        });
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        menuSystem menuSystem = new menuSystem();
	}

    
}
