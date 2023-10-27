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

public class SeleccionarNivel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public ButtonGroup bgroup;
	
	public MasterMind getGame() {
		return game;
	}

	private MasterMind game;
	
	public SeleccionarNivel(Controlador controlador) {
		
		setTitle("Seleccionar nivel");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Botones para seleccionar el nivel de dificultad
		JRadioButton rdbtnprincipante = new JRadioButton("Principiante");
		rdbtnprincipante.setActionCommand("Principiante");
		rdbtnprincipante.setSelected(true);
		rdbtnprincipante.setBounds(61, 30, 109, 23);
		contentPane.add(rdbtnprincipante);
		
		JRadioButton rdbtnMedio = new JRadioButton("Medio");
		rdbtnMedio.setActionCommand("Medio");

		rdbtnMedio.setBounds(172, 30, 88, 23);
		contentPane.add(rdbtnMedio);
		
		JRadioButton rdbtnAvanzado = new JRadioButton("Avanzado");
		rdbtnAvanzado.setActionCommand("Avanzado");
		rdbtnAvanzado.setBounds(262, 30, 109, 23);
		contentPane.add(rdbtnAvanzado);
		
		//Agrupamos las 3 opciones
		bgroup = new ButtonGroup();
		bgroup.add(rdbtnprincipante);
		bgroup.add(rdbtnMedio);
		bgroup.add(rdbtnAvanzado);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(103, 71, 88, 23);
		contentPane.add(btnAceptar);
		
		//Acepta el nivel de dificultad 
		btnAceptar.addActionListener(controlador);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(217, 71, 88, 23);
		contentPane.add(btnCancelar);
		
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
