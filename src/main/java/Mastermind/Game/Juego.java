package Mastermind.Game;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Juego {
	
	private Color[] combinacionSecreta;
	private Color[] coloresDisponibles;
	private Color[] coloresIniciales;
	private int intentos = 0;
	
	public Juego(Color[] combinacionSecreta, Color[] coloresDisponibles) {
		
		coloresIniciales[0] = Color.pink;
		coloresIniciales[1] = Color.black;
		coloresIniciales[2] = Color.blue;
		coloresIniciales[3] = Color.red;
		coloresIniciales[4] = Color.orange;
		coloresIniciales[5] = Color.green;
		
		this.combinacionSecreta = combinacionSecreta;
		this.coloresDisponibles = coloresDisponibles;
	}
	
	public void seleccionDificultad() {
		
		int dificultad = 0;
		combinacionSecreta = new Color[4];
		
		switch (dificultad) {
		
		case 1:
			//dificultad principiante
			
			coloresDisponibles = new Color[4];
			intentos = 10;
			break;
			
		case 2:
			//dificultad media
			
			coloresDisponibles = new Color[6];
			intentos = 8;
			break;
			
		case 3:
			//dificultad avanzado
			
			coloresDisponibles = new Color[6];
			intentos = 6;
			break;
			
			default:
				JOptionPane.showMessageDialog(null, "Selecciona un nivel");
		}
	}
	
	public void rellenarColores() {
		
		for (int x = 0; coloresDisponibles.length > x; x++) {
			
			coloresDisponibles[x] = coloresIniciales [x];
		}
		
	}
	
	public void combinacionGanadora() {
		
		for (int x = 0; combinacionSecreta.length > x; x++) {
			
			combinacionSecreta[x] = coloresDisponibles[x];
		}
	}
	
	public Color[] comprobarIntento(JButton[] arrayIntento) {
		
		int negros = 0;
		boolean verificar = false;
		int blancos = 0;
		Color[] coloresResultado;

		
		for (int x = 0; arrayIntento.length > x; x++) {
			
			if (arrayIntento[x].getBackground() == combinacionSecreta[x]) {
				
				negros ++;
				
			}  else {
				
				for (int y = 0; arrayIntento.length > y; y++) {
					
					if (arrayIntento[x].getBackground() == combinacionSecreta[y]) {
						
						verificar = true;
					}
				}
				
				if (verificar) {
					
					blancos ++;
					verificar = false;
				}
			}
		}
		
		coloresResultado = new Color[negros+blancos];
		
		for (int x = 0; coloresResultado.length > x; x++) {
			
			if (negros > 0) {
				
				negros--;
				coloresResultado[x] = Color.black;
				
			} else if (blancos > 0) {
				
				blancos--;
				coloresResultado[x] = Color.white;
			}
			
		}
		
		return coloresDisponibles;
		
	}
	
	public void pintarBoton(JButton[] botones, int seleccionOpcion) {
		
		
		switch (seleccionOpcion) {
		
		case 1:
			//Colores disponibles
			

			
		case 2:
			//Combinacion secreta
			

			
		case 3:
			//Combinacion resultado

			break;
			
			default:
				JOptionPane.showMessageDialog(null, "Selecciona un nivel");
		}
	}
	}
	
}
