package Mastermind.Vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;

public class ComoJugar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public ComoJugar(MasterMind mastermind) {
		
		setTitle("Como Jugar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 375);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBounds(504, 292, 109, 33);
		btnAtras.setOpaque(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		contentPane.add(btnAtras);
		
		btnAtras.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{

				mastermind.setVisible(true); 
				setVisible(false);


			}
		});
		
		JLabel lblNewLabel = new JLabel("El objetivo del juego es adivinar la combinación secreta utilizando los colores disponibles mostrados ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 87, 603, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblElPanelDe = new JLabel("En el panel de \"Combinaciones\" se crea una posible secuencia con los colores disponibles");
		lblElPanelDe.setForeground(Color.WHITE);
		lblElPanelDe.setBounds(10, 121, 584, 33);
		contentPane.add(lblElPanelDe);
		
		JLabel lblEnPanelDe = new JLabel("En panel de \"Pista\" se muestran dos tipos de colores:");
		lblEnPanelDe.setForeground(Color.WHITE);
		lblEnPanelDe.setBounds(10, 188, 584, 33);
		contentPane.add(lblEnPanelDe);
		
		JLabel lblElPanelDe_2_1 = new JLabel("Color Negro: ");
		lblElPanelDe_2_1.setForeground(Color.WHITE);
		lblElPanelDe_2_1.setBounds(52, 217, 122, 38);
		contentPane.add(lblElPanelDe_2_1);
		
		JLabel lblElPanelDe_2_1_1 = new JLabel("Indica que un color adivinado es correcto y está en la posición correcta.");
		lblElPanelDe_2_1_1.setForeground(Color.WHITE);
		lblElPanelDe_2_1_1.setBounds(134, 217, 479, 38);
		contentPane.add(lblElPanelDe_2_1_1);
		
		JLabel lblElPanelDe_2_1_2 = new JLabel("Color Blanco: ");
		lblElPanelDe_2_1_2.setForeground(Color.WHITE);
		lblElPanelDe_2_1_2.setBounds(52, 243, 122, 38);
		contentPane.add(lblElPanelDe_2_1_2);
		
		JLabel lblElPanelDe_2_1_1_1 = new JLabel("Indica que un color adivinado es correcto, pero no está en la posición correcta.");
		lblElPanelDe_2_1_1_1.setForeground(Color.WHITE);
		lblElPanelDe_2_1_1_1.setBounds(134, 243, 479, 38);
		contentPane.add(lblElPanelDe_2_1_1_1);
		
		JLabel lblPulsamosElBotn = new JLabel("Pulsamos el botón \"Comprobar\" para que nos muestre  la pista.");
		lblPulsamosElBotn.setForeground(Color.WHITE);
		lblPulsamosElBotn.setBounds(10, 153, 584, 33);
		contentPane.add(lblPulsamosElBotn);
		
		JLabel lblComoJugar = new JLabel("Como jugar");
		lblComoJugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblComoJugar.setForeground(new Color(204, 255, 153));
		lblComoJugar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		lblComoJugar.setBounds(134, 11, 350, 76);
		contentPane.add(lblComoJugar);
		
		JLabel lblNewLabel_1 = new JLabel(" v1.0");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(594, 322, 28, 14);
		contentPane.add(lblNewLabel_1);


		
		
	}
}
