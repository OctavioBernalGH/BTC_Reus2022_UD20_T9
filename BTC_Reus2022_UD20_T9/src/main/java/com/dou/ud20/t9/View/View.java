package com.dou.ud20.t9.View;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class View {

	private JFrame frame;
	//TODO: OCTAVIO Crear objetos
	//TODO: David Instanciar las imagenes Listas etc
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//TODO: DAVID ActionListeners
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Funciones
	//TODO: Randomizar Posiciones
	//TODO: URI Jugada
	//TODO: DAVID nueva Partida
}
