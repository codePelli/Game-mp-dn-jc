package Mastermind.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
}
