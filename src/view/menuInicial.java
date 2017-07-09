/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author eder
 */
import javax.swing.*;
import java.awt.Color;

public class menuInicial extends JFrame{
    
    // JPanel
    JPanel menu = new JPanel();
    // Buttons
    JButton btnCadastro = new JButton("Cadastros");
    JButton btnConsultas = new JButton("Consultas");
    
    public menuInicial() {
        super();
        // TODO Auto-generated constructor stub
        initialize();
            
    }
    
    private void initialize(){
        // JFrame properties
        setBackground(Color.BLACK);
        this.setTitle("Sistema Bancário SBD");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(900,700);
        this.setVisible(true);
        btnCadastro.setBounds(60, 400, 220, 30);
        btnConsultas.setBounds(60, 200, 220, 30);
        // JPanel bounds
        menu.setBounds(800, 800, 200, 100);
        // Adding to JFrame
        menu.add(btnCadastro);
        menu.add(btnConsultas);
        add(menu);
        
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                new menuInicial();
	}
}
