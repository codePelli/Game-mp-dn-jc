package Mastermind.Vista;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MasterMind extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MasterMind() 
	{
		
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
		
		JButton btnComprobarIntentos = new JButton("Comprobar");
		btnComprobarIntentos.setBounds(188, 285, 115, 23);
		contentPane.add(btnComprobarIntentos);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(512, 285, 89, 23);
		contentPane.add(btnAtras);
		
		//Acepta el nivel de dificultad 
		btnAtras.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
						
				setVisible(false);
				SeleccionarNivel niveles = new SeleccionarNivel(); 
			    niveles.setVisible(true); 
			             
			}
		});
		
		
		JButton btn1ColorIntento = new JButton("");
		btn1ColorIntento.setBounds(56, 285, 23, 23);
		contentPane.add(btn1ColorIntento);
		
		JButton btn2ColorIntento = new JButton("");
		btn2ColorIntento.setBounds(89, 285, 23, 23);
		contentPane.add(btn2ColorIntento);
		
		JButton btn3ColorIntento = new JButton("");
		btn3ColorIntento.setBounds(122, 285, 23, 23);
		contentPane.add(btn3ColorIntento);
		
		JButton btn4ColorIntento = new JButton("");
		btn4ColorIntento.setBounds(155, 285, 23, 23);
		contentPane.add(btn4ColorIntento);
		
		JButton btn1Dispo = new JButton("");
		btn1Dispo.setBounds(512, 71, 23, 23);
		contentPane.add(btn1Dispo);
		
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
		
		JButton btn1ColorIntento_1 = new JButton("");
		btn1ColorIntento_1.setBounds(56, 251, 23, 23);
		contentPane.add(btn1ColorIntento_1);
		
		JButton btn2ColorIntento_1 = new JButton("");
		btn2ColorIntento_1.setBounds(89, 251, 23, 23);
		contentPane.add(btn2ColorIntento_1);
		
		JButton btn3ColorIntento_1 = new JButton("");
		btn3ColorIntento_1.setBounds(122, 251, 23, 23);
		contentPane.add(btn3ColorIntento_1);
		
		JButton btn4ColorIntento_1 = new JButton("");
		btn4ColorIntento_1.setBounds(155, 251, 23, 23);
		contentPane.add(btn4ColorIntento_1);
		
		JButton btn1ColorIntento_2 = new JButton("");
		btn1ColorIntento_2.setBounds(56, 217, 23, 23);
		contentPane.add(btn1ColorIntento_2);
		
		JButton btn2ColorIntento_2 = new JButton("");
		btn2ColorIntento_2.setBounds(89, 217, 23, 23);
		contentPane.add(btn2ColorIntento_2);
		
		JButton btn3ColorIntento_2 = new JButton("");
		btn3ColorIntento_2.setBounds(122, 217, 23, 23);
		contentPane.add(btn3ColorIntento_2);
		
		JButton btn4ColorIntento_2 = new JButton("");
		btn4ColorIntento_2.setBounds(155, 217, 23, 23);
		contentPane.add(btn4ColorIntento_2);
		
		JButton btn1ColorIntento_3 = new JButton("");
		btn1ColorIntento_3.setBounds(56, 183, 23, 23);
		contentPane.add(btn1ColorIntento_3);
		
		JButton btn2ColorIntento_3 = new JButton("");
		btn2ColorIntento_3.setBounds(89, 183, 23, 23);
		contentPane.add(btn2ColorIntento_3);
		
		JButton btn3ColorIntento_3 = new JButton("");
		btn3ColorIntento_3.setBounds(122, 183, 23, 23);
		contentPane.add(btn3ColorIntento_3);
		
		JButton btn4ColorIntento_3 = new JButton("");
		btn4ColorIntento_3.setBounds(155, 183, 23, 23);
		contentPane.add(btn4ColorIntento_3);
		
		JButton btn1ColorIntento_4 = new JButton("");
		btn1ColorIntento_4.setBounds(56, 149, 23, 23);
		contentPane.add(btn1ColorIntento_4);
		
		JButton btn2ColorIntento_4 = new JButton("");
		btn2ColorIntento_4.setBounds(89, 149, 23, 23);
		contentPane.add(btn2ColorIntento_4);
		
		JButton btn3ColorIntento_4 = new JButton("");
		btn3ColorIntento_4.setBounds(122, 149, 23, 23);
		contentPane.add(btn3ColorIntento_4);
		
		JButton btn4ColorIntento_4 = new JButton("");
		btn4ColorIntento_4.setBounds(155, 149, 23, 23);
		contentPane.add(btn4ColorIntento_4);
		
		JButton btn1ColorIntento_5 = new JButton("");
		btn1ColorIntento_5.setBounds(56, 115, 23, 23);
		contentPane.add(btn1ColorIntento_5);
		
		JButton btn2ColorIntento_5 = new JButton("");
		btn2ColorIntento_5.setBounds(89, 115, 23, 23);
		contentPane.add(btn2ColorIntento_5);
		
		JButton btn3ColorIntento_5 = new JButton("");
		btn3ColorIntento_5.setBounds(122, 115, 23, 23);
		contentPane.add(btn3ColorIntento_5);
		
		JButton btn4ColorIntento_5 = new JButton("");
		btn4ColorIntento_5.setBounds(155, 115, 23, 23);
		contentPane.add(btn4ColorIntento_5);
		btn4CombinacionSecreta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Generar un color aleatorio
                Color randomColor4 = new Color((int) (Math.random() * 0x1000000));
                btn4CombinacionSecreta.setBackground(randomColor4); // Establecer el color de fondo del botón
            }
        });
		
	}
}
