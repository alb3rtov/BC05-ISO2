package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import dominio.Enfermedad;
import dominio.GestorEnfermedades;

public class JFrameBuscarEnfermedades extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextPane textPane;
	
	public JFrameBuscarEnfermedades() {
		setTitle("Enfermedades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarEnfermedad = new JLabel("Buscar enfermedad");
		lblRegistrarEnfermedad.setFont(new Font(null, Font.PLAIN, 16));
		lblRegistrarEnfermedad.setBounds(130, 10, 180, 30);
		contentPane.add(lblRegistrarEnfermedad);
		
		JLabel lblBuscarEnfermedad = new JLabel("Nombre: ");
		lblBuscarEnfermedad.setBounds(6, 50, 150, 30);
		contentPane.add(lblBuscarEnfermedad);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(60, 50, 134, 28);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JButton btnlBuscarEnfermedad = new JButton("Buscar");
		btnlBuscarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (textFieldNombre.getText().length() != 0) { 
					try {
						ArrayList<Enfermedad> enfermedadesEncontradas =  new ArrayList<Enfermedad>();
						ArrayList<String> enfermedades = new ArrayList<String>();
						ArrayList<String> temporalidad = new ArrayList<String>();
						enfermedadesEncontradas = GestorEnfermedades.buscarEnfermedad(textFieldNombre.getText());
						
						String cadenaTitulos = "";
						textPane.setText("");
						
						for (int i = 0; i < enfermedadesEncontradas.size(); i++) {
							enfermedades.add(enfermedadesEncontradas.get(i).getNombre());
							if (enfermedadesEncontradas.get(i).getTemporalidad() == -1) {
								temporalidad.add("Indefinido");
							} else {
								temporalidad.add(enfermedadesEncontradas.get(i).getTemporalidad() + "");
							}
							
						}
						for (int j = 0; j < enfermedades.size(); j++) {
							cadenaTitulos += enfermedades.get(j) + " - tiempo (dias): " + temporalidad.get(j) + "\n";
						}

						if (cadenaTitulos.length() != 0) {
							textPane.setText(cadenaTitulos);
						} else {
							textPane.setText("No se han encontrado resultados");
						}
						

					} catch (Exception e) {
						textPane.setText("Ha ocurrido un error, vuelva a intentarlo" + e.toString());
					}
				} else {
					textPane.setText("Introduzca algun caracter");
				}
			}
		});
		
		btnlBuscarEnfermedad.setBounds(230, 50, 120, 30);
		contentPane.add(btnlBuscarEnfermedad);
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el resultado de la comprobaci\u00F3n de buscar contenido o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 154, 407, 102);
		contentPane.add(textPane);
	}

}
