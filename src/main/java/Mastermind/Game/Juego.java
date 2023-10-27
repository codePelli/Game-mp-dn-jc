package Mastermind.Game;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Juego {
	
	private Color[] combinacionSecreta;
	private Color[] coloresDisponibles;
	private Color[] coloresIniciales;
	private int intentos = 0;
	Color[] coloresResultado;
	
	public Juego(String dificultad) {
		coloresIniciales = new Color[6];
		coloresIniciales[0] = Color.pink;
		coloresIniciales[1] = Color.black;
		coloresIniciales[2] = Color.blue;
		coloresIniciales[3] = Color.red;
		coloresIniciales[4] = Color.orange;
		coloresIniciales[5] = Color.green;
		seleccionDificultad(dificultad);
		
	}
	public void seleccionDificultad(String dificultad) {
		
		combinacionSecreta = new Color[4];
		
		switch (dificultad) {
		
		case "principiante":
			//dificultad principiante
			
			coloresDisponibles = new Color[4];
			intentos = 10;
			break;
			
		case "medio":
			//dificultad media
			
			coloresDisponibles = new Color[6];
			intentos = 8;
			break;
			
		case "avanzado":
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
	
	public int comprobarIntento(JButton[] arrayIntento) {
		
		int negros = 0;
		boolean verificar = false;
		int blancos = 0;
		
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
		
		intentos--;
		return ganadoPerdido(negros);
		
	}
	
	public int ganadoPerdido(int acertados) {
		
		if (acertados == 4) {
			
			JOptionPane.showMessageDialog(null, "HAS GANADO");
			return 1;

			
		} else if (intentos == 0) {
			
			JOptionPane.showMessageDialog(null, "PERDISTE HUEVON");	
			return 2;
		} 
		
		return 3;
		
	}
	
	public void pintarBoton(JButton[] botones, String seleccionOpcion) {
		
		
		switch (seleccionOpcion) {
		
		case "Disponibles":
			//Colores disponibles
			
			for (int x = 0; botones.length > x; x++) {
				
				botones[x].setBackground(coloresDisponibles[x]);
				
			}
			
			break;
			
		case "Resultado":
			//Combinacion resultado
			
			for (int x = 0; botones.length > x; x++) {
				
				botones[x].setBackground(coloresResultado[x]);
				
			}
			
			break;
			
			default:
				JOptionPane.showMessageDialog(null, "Selecciona un nivel");
		}
	}
}
	

