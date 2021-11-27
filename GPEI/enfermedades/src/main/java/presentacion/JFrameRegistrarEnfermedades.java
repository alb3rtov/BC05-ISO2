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

import dominio.GestorEnfermedades;

public class JFrameRegistrarEnfermedades extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldTemporalidad;
	private JTextPane textPane;
	
	public JFrameRegistrarEnfermedades() {
		setTitle("Enfermedades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarEnfermedad = new JLabel("Registrar enfermedad");
		lblRegistrarEnfermedad.setFont(new Font(null, Font.PLAIN, 16));
		lblRegistrarEnfermedad.setBounds(130, 10, 180, 30);
		contentPane.add(lblRegistrarEnfermedad);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(6, 60, 150, 30);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(100, 60, 134, 28);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setBounds(6, 100, 150, 30);
		contentPane.add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(100, 100, 134, 28);
		contentPane.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblTemporalidad = new JLabel("Temporalidad: ");
		lblTemporalidad.setBounds(6, 140, 150, 30);
		contentPane.add(lblTemporalidad);
		
		textFieldTemporalidad = new JTextField();
		textFieldTemporalidad.setBounds(100, 140, 134, 28);
		contentPane.add(textFieldTemporalidad);
		textFieldTemporalidad.setColumns(10);
		
		
		JButton btnlRegistrarEnfermedad = new JButton("Registrar");
		btnlRegistrarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean registrado = false;
				
				try {
					registrado = GestorEnfermedades.registrarEnfermedad(textFieldNombre.getText(), textFieldDescripcion.getText(), textFieldTemporalidad.getText());
				}catch (Exception e) {
					textPane.setText("Ha ocurrido un error, vuelva a intentarlo" + e.toString());
				}
				
				if (registrado) {
					textPane.setText("Enfermedad añadida");
				} else {
					textPane.setText("Ha ocurrido un error durante la inserción");
				}
			}
		});
		
		btnlRegistrarEnfermedad.setBounds(280, 80, 120, 30);
		contentPane.add(btnlRegistrarEnfermedad);
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el resultado de la comprobaci\u00F3n de buscar contenido o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 200, 407, 102);
		contentPane.add(textPane);
	}
}