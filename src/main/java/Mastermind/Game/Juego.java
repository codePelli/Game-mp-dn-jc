package Mastermind.Game;

import java.awt.Color;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Juego {
	
	private Color[] combinacionSecreta;
	private Color[] coloresDisponibles;
	private Color[] coloresIniciales;

	private int intentos = 0;
	private Color[] coloresResultado;
	

	public Juego(String dificultad) {
		coloresIniciales = new Color[6];
		coloresIniciales[0] = Color.pink;
		coloresIniciales[1] = Color.black;
		coloresIniciales[2] = Color.blue;
		coloresIniciales[3] = Color.red;
		coloresIniciales[4] = Color.orange;
		coloresIniciales[5] = Color.green;
		seleccionDificultad(dificultad);
		rellenarColores();
		combinacionGanadora();
	}
	public void seleccionDificultad(String dificultad) {
		
		combinacionSecreta = new Color[4];
		
		switch (dificultad.toLowerCase()) {
		
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
			
			combinacionSecreta[x] = coloresDisponibles[(int) (Math.random()*coloresDisponibles.length)];
		}
	}
	
	public int comprobarIntento(JButton[] arrayIntento) {
		
		int negros = 0;
		boolean verificar = false;
		int blancos = 0;
		int contador = 0;
		Color[] coloresAparecidos = new Color[arrayIntento.length];
		for (int x = 0; arrayIntento.length > x; x++) {
			
			if (arrayIntento[x].getBackground() == combinacionSecreta[x]) {
				
				negros ++;
				
			}  else {
				
				for (int y = 0; arrayIntento.length > y; y++) {
					
					if (arrayIntento[x].getBackground() == combinacionSecreta[y]) {
						verificar = true;
						for (int i = 0; i < coloresAparecidos.length; i++) {
							if(coloresAparecidos[i] == arrayIntento[x].getBackground()) {
								verificar = false;
							}
						}
						if(verificar) {
							
						}
					}
				}
				
				if (verificar) {
					blancos ++;
					verificar = false;
					coloresAparecidos[contador] = arrayIntento[x].getBackground();
					contador++;
				}
			}
		}
		
		coloresResultado = new Color[negros+blancos];
		
		int copiaNegro = negros;
		
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
		return ganadoPerdido(copiaNegro);
		
	}
	
	public int ganadoPerdido(int acertados) {
		
		if (acertados == 4) {
			
			return 1;

			
		} else if (intentos == 0) {
			
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
			
			for (int x = 0; coloresResultado.length > x; x++) {
				
				botones[x].setBackground(coloresResultado[x]);
				
			}
			
			break;
			
			default:
				JOptionPane.showMessageDialog(null, "Selecciona un nivel");
		}
	}
	
	public void cambiarIntentoBackground(JButton boton) {
		boolean isColored = false;
		
		for (int i = 0; i < coloresDisponibles.length; i++) {
			if(boton.getBackground() == coloresDisponibles[i] && i != coloresDisponibles.length - 1 && !isColored) {
				boton.setBackground(coloresDisponibles[i+1]);
				isColored = true;
			}
		}
		if(!isColored) {
			boton.setBackground(coloresDisponibles[0]);
		}
	}
	
	public void pintarSecreto(JButton secreto, String index) {
		secreto.setBackground(combinacionSecreta[Integer.parseInt(index)]);
	}
	
	public int getIntentos() {
		return intentos;
	}
	public int getContadorColoresDisponibles() {
		return coloresDisponibles.length;
	}
	public Color[] getColoresResultado() {
		return coloresResultado;
	}
}
	

