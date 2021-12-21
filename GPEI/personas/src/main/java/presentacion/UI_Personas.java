package presentacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UI_Personas extends JFrame {
	private JPanel contentPane;
	
	/* Main function */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Personas frame = new UI_Personas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UI_Personas() {
		setTitle("Personas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Menu personas");
		lblTitulo.setFont(new Font(null, Font.PLAIN, 16));
		lblTitulo.setBounds(150, 37, 150, 30);
		contentPane.add(lblTitulo);
		
		JButton btnBuscarPersonas = new JButton("Listar personas");
		btnBuscarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameListarPersonas frame = new JFrameListarPersonas();
				frame.setVisible(true);
			}
		});
		
		JButton btnRegistrarPersona= new JButton("Registrar persona");
		btnRegistrarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameRegistrarPersonas frame = new JFrameRegistrarPersonas();
				frame.setVisible(true);
			}
		});
		
		btnBuscarPersonas.setBounds(110, 90, 200, 40);
		contentPane.add(btnBuscarPersonas);
		
		btnRegistrarPersona.setBounds(110, 140, 200, 40);
		contentPane.add(btnRegistrarPersona);
	}
}
