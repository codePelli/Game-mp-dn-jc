package Mastermind.Game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Mastermind.Vista.MasterMind;
import Mastermind.Vista.SeleccionarNivel;

public class Controlador implements ActionListener {

    private Juego juego;
    private MasterMind mastermind;
    private SeleccionarNivel seleccionarLevel;
    
    public void reiniciarJuego() {
    	
    	seleccionarLevel = new SeleccionarNivel(this);
		seleccionarLevel.setVisible(true);
    }
    
    public int intentos() {
    	
		return juego.getIntentos();
    	
    }
    
    public void clickDificultad() {
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
    	juego = new Juego(seleccionarLevel.bgroup.getSelection().getActionCommand());
		seleccionarLevel.setVisible(false);
		mastermind = new MasterMind(this); 
	    mastermind.setVisible(true); 

	}
	
	public void getColoresDisponibles(JButton[] botones, String tipo) {
		juego.pintarBoton(botones, tipo);
	}
	public void getColorSecreta(JButton botonSecreto, String index) {
		juego.pintarSecreto(botonSecreto, index);
	}
	public int getContadorDisponibles(){
		return juego.getContadorColoresDisponibles();
	}
	public void pintarBotonIntento(JButton boton) {
		juego.cambiarIntentoBackground(boton);
	}

	public void comprobarIntento(JButton[] arrayIntento) {
		
		int tirada = juego.comprobarIntento(arrayIntento);

		if (tirada == 1) {
			
			JOptionPane.showMessageDialog(mastermind, "¡Has ganado!");
			
		} else if (tirada == 2) {
			
			JOptionPane.showMessageDialog(mastermind, "¡Has perdido!");
			
		}
	}
	public void pintarBotonesResultado(JButton[] botones) {
		juego.pintarBoton(botones,"Resultado");
	}
	
}
