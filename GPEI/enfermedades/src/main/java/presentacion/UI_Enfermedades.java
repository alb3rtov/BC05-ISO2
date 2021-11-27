package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class UI_Enfermedades extends JFrame {

	private JPanel contentPane;

	/* Main function */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Enfermedades frame = new UI_Enfermedades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	
	/* Constructor */
	public UI_Enfermedades() {
		setTitle("Enfermedades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Menú enfermedades");
		lblTitulo.setFont(new Font(null, Font.PLAIN, 16));
		lblTitulo.setBounds(135, 37, 150, 30);
		contentPane.add(lblTitulo);
		
		JButton btnBuscarEnfermedad = new JButton("Buscar enfermedad");
		btnBuscarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameBuscarEnfermedades frame = new JFrameBuscarEnfermedades();
				frame.setVisible(true);
			}
		});
		
		JButton btnRegistrarEnfermedad = new JButton("Registrar enfermedad");
		btnRegistrarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameRegistrarEnfermedades frame = new JFrameRegistrarEnfermedades();
				frame.setVisible(true);
			}
		});
		
		btnBuscarEnfermedad.setBounds(110, 90, 200, 40);
		contentPane.add(btnBuscarEnfermedad);
		
		btnRegistrarEnfermedad.setBounds(110, 140, 200, 40);
		contentPane.add(btnRegistrarEnfermedad);
	}
}
