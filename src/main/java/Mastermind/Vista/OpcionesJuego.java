package Mastermind.Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mastermind.Game.Juego;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class OpcionesJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	Juego juego;
	private Color selectedColor;

	public OpcionesJuego(Juego juego) {
		
		this.juego = juego;
		setTitle("Opciones del juego");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(129, 111, 89, 23);
		contentPane.add(btnAceptar);
		

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(228, 111, 89, 23);
		contentPane.add(btnCancelar);
		
		CrearBotonesColorIntentos();
		
	}
		
		/*btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
								
				setVisible(false);
				MasterMind game = new MasterMind(); 
				game.setVisible(true); 
					             
			}
		});*/
		
	/*	JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(82, 34, 50, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(168, 34, 50, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(253, 34, 50, 50);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(335, 34, 50, 50);
		contentPane.add(btnNewButton_3);
	}*/
	
	public void CrearBotonesColorIntentos() 
	{
		
		JButton[][] coloresintentos = new JButton[juego.getIntentos()][4];
		

		int y = 15;
		for(int i = 0; i < coloresintentos.length; i++) 
		{
			int x = 20;
			for (int j = 0; j < coloresintentos[i].length; j++) 
			{
				
				JButton btn = new JButton("");
				btn.setBounds(x, y, 25, 25);
				coloresintentos[i][j] = btn;
				contentPane.add(coloresintentos[i][j]);
				x = x + 30;
				
			/*	btn.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                selectedColor = JColorChooser.showDialog(null, "Seleccionar Color", Color.WHITE);
		                if (selectedColor != null) {
		                	btn.setBackground(selectedColor);
		                }
		            }
		        });*/

			}
		}
	}
	
	
	
}
