package Mastermind.Vista;


import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Mastermind.Game.Juego;
import javax.swing.JButton;

public class MasterMind extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	Juego juego;
	
	public MasterMind(String dificultad) 
	{
		juego = new Juego(dificultad);
		setTitle("Master Mind Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbldispo = new JLabel("Colores disponibles");
		lbldispo.setBounds(512, 46, 221, 14);
		contentPane.add(lbldispo);
		
		JLabel lbldispo_1 = new JLabel("Combinacion cecreta");
		lbldispo_1.setBounds(512, 178, 221, 14);
		contentPane.add(lbldispo_1);
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(512, 285, 89, 23);
		contentPane.add(btnAtras);
		
		//Acepta el nivel de dificultad 
		btnAtras.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
								
				setVisible(false);
				SeleccionarNivel niveles = new SeleccionarNivel(); 
				niveles.setVisible(true); 
					             
			}
		});
		
		crearBotonesIntentos();
		crearBotonesCombinacionSecreta();
		crearBotonesColoresDisponibles();
		crearBotonesAyuda();
		

		
	}	
	
	public void crearBotonesColoresDisponibles() 
	{
		JButton[][] dispo = new JButton[juego.getIntentos()][4];
		
		int y = 65;
		for(int i = 0; i < dispo.length; i++) 
		{
			int x = 513;
			for (int j = 0; j < dispo[i].length; j++) 
			{
				JButton btn = new JButton("");
				btn.setBounds(x, y, 25, 25);
				dispo[i][j] = btn;
				contentPane.add(dispo[i][j]);
				x = x + 30;
	
			}
		}
	}
	
	
	
		
	public void crearBotonesCombinacionSecreta() 
	{
		JButton[][] secret = new JButton[juego.getIntentos()][4];
		
		int y = 200;
		for(int i = 0; i < secret.length; i++) 
		{
			int x = 513;
			for (int j = 0; j < secret[i].length; j++) 
			{
				JButton btn = new JButton("");
				btn.setBounds(x, y, 25, 25);
				secret[i][j] = btn;
				contentPane.add(secret[i][j]);
				x = x + 30;
				
				btn.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		                // Generar un color aleatorio
		                Color randomColor1 = new Color((int) (Math.random() * 0x1000000));
		                btn.setBackground(randomColor1); // Establecer el color de fondo del botón
		                
		            }
		        });
			}
		}
	}
	
	public void crearBotonesIntentos() 
	{
		
		JButton[][] intentos = new JButton[juego.getIntentos()][4];
		JButton[] comprobar = new JButton[juego.getIntentos()];

		int y = 15;
		for(int i = 0; i < intentos.length; i++) 
		{
			int x = 55;
			for (int j = 0; j < intentos[i].length; j++) 
			{
				
				JButton botonintento = new JButton("");
				botonintento.setBounds(x, y, 25, 25);
				intentos[i][j] = botonintento;
				contentPane.add(intentos[i][j]);
				x = x + 30;
				
				botonintento.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0) 
					{
										
						setVisible(false);
						OpcionesJuego colores = new OpcionesJuego(); 
						colores.setVisible(true); 
							             
					}
				});

			}
			
			JButton botonComprobar = new JButton("Comprobar");
			botonComprobar.setBounds(175, y, 115, 25);
			comprobar[i] = botonComprobar;
			contentPane.add(comprobar[i]);
			y += 30;			
			
		}
	}
	
	public void crearBotonesAyuda() 
	{
		
		JButton[][] ayuda = new JButton[juego.getIntentos()][4];
		

		int y = 15;
		for(int i = 0; i < ayuda.length; i++) 
		{
			int x = 300;
			for (int j = 0; j < ayuda[i].length; j++) 
			{
				
				JButton btn = new JButton("");
				btn.setBounds(x, y, 25, 25);
				ayuda[i][j] = btn;
				contentPane.add(ayuda[i][j]);
				x = x + 30;

			}
		}
	}
	
}
