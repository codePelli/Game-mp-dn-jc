package Mastermind.Vista;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mastermind.Game.Controlador;
import Mastermind.Game.Juego;
import Mastermind.Game.MainApp;

import javax.swing.JButton;

public class MasterMind extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private String dificultad;
	private Controlador controlador;
	JButton[][] resultado;
	
	public MasterMind(Controlador controlador) {

		this.controlador = controlador;
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

		//		JButton btnComprobarIntentos = new JButton("Comprobar");
		//		btnComprobarIntentos.setBounds(188, 285, 115, 23);
		//		contentPane.add(btnComprobarIntentos);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(512, 285, 89, 23);
		contentPane.add(btnAtras);

		crearBotonesIntentos();

		//Acepta el nivel de dificultad 
		btnAtras.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{

				setVisible(false);
				SeleccionarNivel niveles = new SeleccionarNivel(controlador); 
				niveles.setVisible(true); 

			}
		});


		crearBotonesColoresDisponibles();
		crearBotonesCombinacionSecreta();
		crearBotonesResultado();
	}

	public void crearBotonesIntentos() {

		JButton[][] intentos = new JButton[controlador.intentos()][4];
		JButton[] comprobar = new JButton[controlador.intentos()];
		int y = 15;
		for(int i = 0; i < intentos.length; i++) {
			int x = 55;
			for (int j = 0; j < intentos[i].length; j++) {
				JButton btn = new JButton("");
				btn.setBounds(x, y, 25, 25);
				intentos[i][j] = btn;
				contentPane.add(intentos[i][j]);
				x = x + 30;
				if(i > 0) {
					btn.setVisible(false);
				}
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controlador.pintarBotonIntento(btn);
					}
				});
			}
			JButton botonComprobar = new JButton("Comprobar");
			
			botonComprobar.setActionCommand(i+"");
			if (i != 0) {
				
				botonComprobar.setVisible(false);
			}
			botonComprobar.setBounds(175, y, 115, 25);
			comprobar[i] = botonComprobar;
			contentPane.add(comprobar[i]);
			y += 30;
			botonComprobar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int x = Integer.parseInt(botonComprobar.getActionCommand());
					botonComprobar.setVisible(false);
					if(x < comprobar.length -1) {
						comprobar[x + 1].setVisible(true);
					}
					JButton[] filaIntentos = intentos[x];
					JButton[] filaResultado = resultado[x];
					
					
					for (int k = 0; k < intentos[x+1].length; k++) {
						intentos[x+1][k].setVisible(true);
						resultado[x+1][k].setVisible(true);
					}

					
					controlador.comprobarIntento(filaIntentos);
					controlador.pintarBotonesResultado(filaResultado);

				}
			});
			
		}

	}

	public void crearBotonesColoresDisponibles() 
	{
		JButton[] dispo = new JButton[controlador.getContadorDisponibles()];
		int y = 65;
		int x = 513;
		for(int i = 0; i < dispo.length; i++) 
		{
			JButton btn = new JButton("");
			btn.setBounds(x, y, 25, 25);
			dispo[i] = btn;
			contentPane.add(dispo[i]);
			x = x + 30;


		}
		controlador.getColoresDisponibles(dispo, "Disponibles");
	}

	public void crearBotonesCombinacionSecreta() 
	{
		JButton[] secret = new JButton[4];

		int y = 200;
		int x = 513;
		for(int i = 0; i < secret.length; i++) 
		{
			JButton btn = new JButton("");
			btn.setBounds(x, y, 25, 25);
			secret[i] = btn;
			btn.setActionCommand(i+"");
			contentPane.add(secret[i]);
			x = x + 30;

			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlador.getColorSecreta(btn, e.getActionCommand());

				}
			});

		}
	}
	public void crearBotonesResultado() 
	{
		
		resultado = new JButton[controlador.intentos()][4];
		

		int y = 15;
		for(int i = 0; i < resultado.length; i++) 
		{
			int x = 300;
			for (int j = 0; j < resultado[i].length; j++) 
			{
				
				JButton btn = new JButton("");
				btn.setBounds(x, y, 25, 25);
				resultado[i][j] = btn;
				contentPane.add(resultado[i][j]);
				x = x + 30;
				if(i > 0) {
					btn.setVisible(false);
				}

			}
			y += 30;
		}
	}
}
