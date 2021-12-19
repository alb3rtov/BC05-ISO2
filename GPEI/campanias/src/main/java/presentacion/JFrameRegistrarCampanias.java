package presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import dominio.GestorCampanias;
import dominio.GestorEnfermedades;

public class JFrameRegistrarCampanias extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldFechaInicio;
	private JTextField textFieldFechaFin;
	private JTextField textFieldCoste;
	private JTextField textFieldEfectividad;
	private JTextField textFieldEnfermedad;
	private JTextPane textPane;
	
	public JFrameRegistrarCampanias() {
		setTitle("Registrar campa\u00f1as");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarEnfermedad = new JLabel("Registrar campa\u00f1a");
		lblRegistrarEnfermedad.setFont(new Font(null, Font.PLAIN, 16));
		lblRegistrarEnfermedad.setBounds(130, 10, 180, 30);
		contentPane.add(lblRegistrarEnfermedad);
	
		JLabel lblFechaInicio = new JLabel("Fecha inicio: ");
		lblFechaInicio.setBounds(6, 60, 150, 30);
		contentPane.add(lblFechaInicio);
		
		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setBounds(100, 60, 134, 28);
		contentPane.add(textFieldFechaInicio);
		textFieldFechaInicio.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("Fecha fin: ");
		lblFechaFin.setBounds(6, 100, 150, 30);
		contentPane.add(lblFechaFin);
		
		textFieldFechaFin = new JTextField();
		textFieldFechaFin.setBounds(100, 100, 134, 28);
		contentPane.add(textFieldFechaFin);
		textFieldFechaFin.setColumns(10);
		
		JLabel lblCoste = new JLabel("Coste: ");
		lblCoste.setBounds(6, 140, 150, 30);
		contentPane.add(lblCoste);
		
		textFieldCoste = new JTextField();
		textFieldCoste.setBounds(100, 140, 134, 28);
		contentPane.add(textFieldCoste);
		textFieldCoste.setColumns(10);
		
		JLabel lblEfectividad = new JLabel("Efectividad: ");
		lblEfectividad.setBounds(6, 180, 150, 30);
		contentPane.add(lblEfectividad);
		
		textFieldEfectividad = new JTextField();
		textFieldEfectividad.setBounds(100, 180, 134, 28);
		contentPane.add(textFieldEfectividad);
		textFieldEfectividad.setColumns(10);
		
		JLabel lblEnfermedad= new JLabel("Enfermedad: ");
		lblEnfermedad.setBounds(6, 220, 150, 30);
		contentPane.add(lblEnfermedad);
		
		textFieldEnfermedad = new JTextField();
		textFieldEnfermedad.setBounds(100, 220, 134, 28);
		contentPane.add(textFieldEnfermedad);
		textFieldEnfermedad.setColumns(10);
		
		
		JButton btnlRegistrarCampania = new JButton("Registrar");
		btnlRegistrarCampania.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean registrado = false;
				
				try {
					registrado = GestorCampanias.registrarCampania(textFieldFechaInicio.getText(), textFieldFechaFin.getText(), textFieldCoste.getText(), textFieldEfectividad.getText(), textFieldEnfermedad.getText());
				}catch (Exception e) {
					textPane.setText("Ha ocurrido un error, vuelva a intentarlo" + e.toString());
				}
				
				if (registrado) {
					textPane.setText("Campa\u00f1a añadida");
				} else {
					textPane.setText("Ha ocurrido un error durante la inserción");
				}
			}
		});
		
		btnlRegistrarCampania.setBounds(280, 80, 120, 30);
		contentPane.add(btnlRegistrarCampania);
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el resultado de la comprobaci\u00F3n de buscar contenido o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 270, 407, 30);
		contentPane.add(textPane);
	}
}
