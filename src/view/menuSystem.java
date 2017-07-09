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
import java.awt.Color;


public class menuSystem extends JFrame{
    // JPanel
    JPanel menu = new JPanel();
    // Buttons
    JButton btnCadastroCliente = new JButton("Cadastro Cliente");
    JButton btnCadastroAgencia = new JButton("Cadastro Agencia");
    JButton btnCadastroFuncionario = new JButton("Cadastro Funcionário");
    JButton btnConsultas = new JButton("Consultas");
    
    public menuSystem() {
        super();
        // TODO Auto-generated constructor stub
        initialize();
            
    }
    
    private void initialize(){
        // JFrame properties
        setBackground(Color.BLACK);
        this.setTitle("Sistema Bancário SBD");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(700,400);
        this.setVisible(true);
        btnCadastroCliente.setBounds(100, 400, 220, 50);
        btnCadastroAgencia.setBounds(100, 300, 220, 50);
        btnCadastroFuncionario.setBounds(200, 200, 220, 50);
        btnConsultas.setBounds(100, 100, 220, 50);
        // JPanel bounds
        menu.setBounds(500, 500, 80, 100);
        // Adding to JFrame
        menu.add(btnCadastroCliente);
        menu.add(btnCadastroAgencia);
        menu.add(btnCadastroFuncionario);
        menu.add(btnConsultas);
        add(menu);
        
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                new menuSystem();
	}

    
}
