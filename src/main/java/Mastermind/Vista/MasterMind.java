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
    
	public MasterMind(Controlador controlador) {
		
		this.controlador = controlador;
		this.dificultad = dificultad;
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
		
		JButton btn2Dispo = new JButton("");
		btn2Dispo.setBounds(545, 71, 23, 23);
		contentPane.add(btn2Dispo);
		
		JButton btn3Dispo = new JButton("");
		btn3Dispo.setBounds(578, 71, 23, 23);
		contentPane.add(btn3Dispo);
		
		JButton btn4Dispo = new JButton("");
		btn4Dispo.setBounds(611, 71, 23, 23);
		contentPane.add(btn4Dispo);
		
		JButton btn5Dispo = new JButton("");
		btn5Dispo.setBounds(644, 71, 23, 23);
		contentPane.add(btn5Dispo);
		
		JButton btn6Dispo = new JButton("");
		btn6Dispo.setBounds(677, 71, 23, 23);
		contentPane.add(btn6Dispo);
		
		JButton btn1CombinacionSecreta = new JButton("");
		btn1CombinacionSecreta.setBounds(512, 203, 23, 23);
		contentPane.add(btn1CombinacionSecreta);
		
		btn1CombinacionSecreta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Generar un color aleatorio
                Color randomColor1 = new Color((int) (Math.random() * 0x1000000));
                btn1CombinacionSecreta.setBackground(randomColor1); // Establecer el color de fondo del botón
            }
        });
		
		
		JButton btn2CombinacionSecreta = new JButton("");
		btn2CombinacionSecreta.setBounds(545, 203, 23, 23);
		contentPane.add(btn2CombinacionSecreta);
		btn2CombinacionSecreta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Generar un color aleatorio
                Color randomColor2 = new Color((int) (Math.random() * 0x1000000));
                btn2CombinacionSecreta.setBackground(randomColor2); // Establecer el color de fondo del botón
            }
        });
		
		JButton btn3CombinacionSecreta = new JButton("");
		btn3CombinacionSecreta.setBounds(578, 203, 23, 23);
		contentPane.add(btn3CombinacionSecreta);
		btn3CombinacionSecreta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Generar un color aleatorio
                Color randomColor3 = new Color((int) (Math.random() * 0x1000000));
                btn3CombinacionSecreta.setBackground(randomColor3); // Establecer el color de fondo del botón
            }
        });
		
		JButton btn4CombinacionSecreta = new JButton("");
		btn4CombinacionSecreta.setBounds(611, 203, 23, 23);
		contentPane.add(btn4CombinacionSecreta);
		
		btn4CombinacionSecreta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Generar un color aleatorio
                Color randomColor4 = new Color((int) (Math.random() * 0x1000000));
                btn4CombinacionSecreta.setBackground(randomColor4); // Establecer el color de fondo del botón
            }
        });
		
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
			}
			JButton botonComprobar = new JButton("Comprobar");
			botonComprobar.setBounds(175, y, 115, 25);
			comprobar[i] = botonComprobar;
			contentPane.add(comprobar[i]);
			y += 30;
		}
	}
	
	public String getDificultad() {
		return dificultad;
	}
}
