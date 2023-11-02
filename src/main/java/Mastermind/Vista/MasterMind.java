package Mastermind.Vista;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mastermind.Game.Controlador;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MasterMind extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private String dificultad;
	private Controlador controlador;
	JButton[][] resultado;
	//Creamos constructor a raiz de un controlador
	public MasterMind(Controlador controlador) {

		this.controlador = controlador;
		setTitle("Master Mind Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbldispo = new JLabel("Colores disponibles");
		lbldispo.setHorizontalAlignment(SwingConstants.CENTER);
		lbldispo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lbldispo.setForeground(Color.WHITE);
		lbldispo.setBounds(427, 60, 221, 33);
		contentPane.add(lbldispo);

		JLabel lblcombSecreta = new JLabel("Combinación secreta");
		lblcombSecreta.setHorizontalAlignment(SwingConstants.CENTER);
		lblcombSecreta.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblcombSecreta.setForeground(Color.WHITE);
		lblcombSecreta.setBounds(427, 158, 221, 33);
		contentPane.add(lblcombSecreta);

		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnReiniciar.setForeground(Color.WHITE);
		btnReiniciar.setBounds(427, 273, 122, 33);
		btnReiniciar.setOpaque(false);
		btnReiniciar.setContentAreaFilled(false);
		btnReiniciar.setBorderPainted(false);
		contentPane.add(btnReiniciar);
		
		JButton btnAyuda = new JButton("Como Jugar");
		btnAyuda.setHorizontalAlignment(SwingConstants.LEFT);
		btnAyuda.setOpaque(false);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBounds(570, 273, 156, 33);
		btnAyuda.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{

				controlador.ComoJugar();
				setVisible(false);

			}
		});
		
		contentPane.add(btnAyuda);
		
		JLabel lblCombinaciones = new JLabel("Combinaciones");
		lblCombinaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblCombinaciones.setForeground(Color.WHITE);
		lblCombinaciones.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblCombinaciones.setBounds(47, 11, 137, 33);
		contentPane.add(lblCombinaciones);
		
		JLabel lblPista = new JLabel("Pista");
		lblPista.setHorizontalAlignment(SwingConstants.CENTER);
		lblPista.setForeground(Color.WHITE);
		lblPista.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPista.setBounds(301, 11, 106, 33);
		contentPane.add(lblPista);
		
		JLabel lblNewLabel = new JLabel(" v1.0");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(690, 303, 26, 14);
		contentPane.add(lblNewLabel);
		
		

		crearBotonesIntentos();

		//Acepta el nivel de dificultad 
		btnReiniciar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{

				controlador.reiniciarJuego();

			}
		});
		

		crearBotonesColoresDisponibles();
		crearBotonesCombinacionSecreta();
		crearBotonesResultado();
	}
	//Metodo para crear los botones de intentos
	public void crearBotonesIntentos() {

		JButton[][] intentos = new JButton[controlador.intentos()][4];
		JButton[] comprobar = new JButton[controlador.intentos()];
		int y = 50;
		for(int i = 0; i < intentos.length; i++) {
			int x = 55;
			for (int j = 0; j < intentos[i].length; j++) {
				JButton btn = new JButton("");
				btn.setBackground(Color.DARK_GRAY);
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
			botonComprobar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
			botonComprobar.setForeground(Color.WHITE);
			botonComprobar.setBounds(512, 269, 122, 33);
			botonComprobar.setOpaque(false);
			botonComprobar.setContentAreaFilled(false);
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
					boolean valido = true;
					//Cogemos el index de la array guardada en el botón
					int x = Integer.parseInt(botonComprobar.getActionCommand());
					
					JButton[] filaIntentos = intentos[x];
					JButton[] filaResultado = resultado[x];
					
					for (int j = 0; j < filaIntentos.length; j++) {
						if(Color.DARK_GRAY == filaIntentos[j].getBackground()) {
							valido = false;	
						}
					}
					
					if(valido) {
						botonComprobar.setVisible(false);
						//Dejamos solo visible el primer botón
						if(x < comprobar.length -1) {
							comprobar[x + 1].setVisible(true);
						}
						//Dejamos visible solo la primera linea de de intentos y de resultados
						if(x < intentos.length - 1) {
							for (int k = 0; k < intentos[x+1].length; k++) {
								intentos[x][k].setEnabled(false);
								intentos[x+1][k].setVisible(true);
								resultado[x+1][k].setVisible(true);

							}
						}
						//llamamos al controlador para comprobar el intento y para pintar los botones
						controlador.comprobarIntento(filaIntentos);
						controlador.pintarBotonesResultado(filaResultado);
					}else {
						JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los cuadros");
					}
				}
			});

		}

	}

	public void crearBotonesColoresDisponibles() 
	{
		JButton[] dispo = new JButton[controlador.getContadorDisponibles()];
		int y = 100;
		int x = 460;
		for(int i = 0; i < dispo.length; i++) 
		{
			JButton btn = new JButton("");
			btn.setBounds(x, y, 25, 25);
			dispo[i] = btn;
			contentPane.add(dispo[i]);
			x = x + 30;


		}
		// pinta los colores disponibles
		controlador.getColoresDisponibles(dispo, "Disponibles");
	}

	public void crearBotonesCombinacionSecreta() 
	{
		JButton[] secret = new JButton[4];

		int y = 200;
		int x = 460;
		for(int i = 0; i < secret.length; i++) 
		{
			JButton btn = new JButton("");
			btn.setBackground(Color.DARK_GRAY);
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


		int y = 50;
		for(int i = 0; i < resultado.length; i++) 
		{
			int x = 300;
			for (int j = 0; j < resultado[i].length; j++) 
			{

				JButton btn = new JButton("");
				btn.setBounds(x, y, 25, 25);
				btn.setBackground(Color.DARK_GRAY);
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
