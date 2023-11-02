package Mastermind.Game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Juego {

	private Color[] combinacionSecreta;
	private Color[] coloresDisponibles;

	private int intentos = 0;
	private Color[] coloresResultado;

	//Cuando creamos el juego le pasamos la dificultad para guardarnos los intentos y los colores disponibles
	public Juego(String dificultad) {
		seleccionDificultad(dificultad);
		rellenarColores();
		rellenarCombinacionSecreta();
	}
	//Condicional para guardar dificultad
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

			coloresDisponibles[x] = new Color((int)(Math.random() * 0x1000000));
		}

	}

	public void rellenarCombinacionSecreta() {

		for (int x = 0; combinacionSecreta.length > x; x++) {

			combinacionSecreta[x] = coloresDisponibles[(int) (Math.random()*coloresDisponibles.length)];
		}
	}
	// Logica para comprobar el intento que  nos pasan con una array de botones
	public int comprobarIntento(JButton[] arrayIntento) {

		int negros = 0;
		boolean verificar = false;
		int blancos = 0;
		ArrayList<Integer> posicionesAparecidas = new ArrayList<Integer>();
		//Creamos array para saber que colores han aparecido
		for (int x = 0; arrayIntento.length > x; x++) {
			if (arrayIntento[x].getBackground() == combinacionSecreta[x]) {
				negros ++;
				posicionesAparecidas.add(x);
			}  
		}
		for (int x = 0; x < arrayIntento.length; x++) {
			if(!(arrayIntento[x].getBackground() == combinacionSecreta[x])){
				//Bucle for recoge intentos y mira si no son iguales a la combinacion secreta
				for (int y = 0; arrayIntento.length > y; y++) {
					if (arrayIntento[x].getBackground() == combinacionSecreta[y]) {
						verificar = true;
						//Comprueba que la posicion de los negros aparecidos no sea igual a la que se está comprobando
						for (int i = 0; i < posicionesAparecidas.size(); i++) {
							if(posicionesAparecidas.get(i) == y) {
								verificar = false;
							}
						}
					}
					if (verificar) {
						blancos ++;
						verificar = false;
						posicionesAparecidas.add(y);
						//Se iguala a 4 para forzar a acabar el segundo bucle una vez se haya verificado
						y = 4;
					}
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
	// Cambiar color del intento cada vez que se haga click
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
	// pinta el secreto al que le des click
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


