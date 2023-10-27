package Mastermind.Game;
import Mastermind.Vista.MasterMind;
import Mastermind.Vista.SeleccionarNivel;

/**
 * Hello world!
 *
 */
public class MainApp 
{
	
    private Juego juego;
    private MasterMind mastermind;
    private SeleccionarNivel seleccionarLevel;
    
    public static void main( String[] args ){

        
    	
    }
    
    public void reiniciarJuego() {
    	
    	seleccionarLevel = new SeleccionarNivel();
    	juego = new Juego();
    }
}
