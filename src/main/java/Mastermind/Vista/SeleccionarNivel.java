package Mastermind.Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mastermind.Game.Controlador;
import Mastermind.Game.MainApp;

import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class SeleccionarNivel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public ButtonGroup bgroup;
	// Constructor que a raiz de un controlador nos crea una pantalla para seleccionar el novel del juego
	public SeleccionarNivel(Controlador controlador) {
		
		setTitle("Selecciona un nivel de dificultad");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 209);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Botones para seleccionar el nivel de dificultad
		JRadioButton rdbtnprincipante = new JRadioButton("Principiante");
		rdbtnprincipante.setForeground(Color.WHITE);
		rdbtnprincipante.setBackground(Color.DARK_GRAY);
		rdbtnprincipante.setActionCommand("Principiante");
		rdbtnprincipante.setSelected(true);
		rdbtnprincipante.setBounds(57, 83, 109, 23);
		contentPane.add(rdbtnprincipante);
		
		JRadioButton rdbtnMedio = new JRadioButton("Medio");
		rdbtnMedio.setForeground(Color.WHITE);
		rdbtnMedio.setBackground(Color.DARK_GRAY);
		rdbtnMedio.setActionCommand("Medio");

		rdbtnMedio.setBounds(168, 83, 88, 23);
		contentPane.add(rdbtnMedio);
		
		JRadioButton rdbtnAvanzado = new JRadioButton("Avanzado");
		rdbtnAvanzado.setForeground(Color.WHITE);
		rdbtnAvanzado.setBackground(Color.DARK_GRAY);
		rdbtnAvanzado.setActionCommand("Avanzado");
		rdbtnAvanzado.setBounds(258, 83, 109, 23);
		contentPane.add(rdbtnAvanzado);
		
		//Agrupamos las 3 opciones
		bgroup = new ButtonGroup();
		bgroup.add(rdbtnprincipante);
		bgroup.add(rdbtnMedio);
		bgroup.add(rdbtnAvanzado);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.WHITE);		
		btnAceptar.setOpaque(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		
		btnAceptar.setBounds(100, 123, 88, 23);
		contentPane.add(btnAceptar);
		
		//Acepta el nivel de dificultad desde action listener del controlador
		btnAceptar.addActionListener(controlador);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBounds(214, 123, 88, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("Master Mind");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(204, 255, 153));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setBounds(38, 11, 329, 54);
		contentPane.add(lblNewLabel);
		
		//Salir de la aplicacion
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				 System.exit(0);
				
			}
		});
		
	}
}
