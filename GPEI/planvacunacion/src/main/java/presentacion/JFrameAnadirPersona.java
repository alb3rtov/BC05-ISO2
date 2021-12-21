package presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import dominio.GestorPlanPersona;
import dominio.PlanVacunacion;

public class JFrameAnadirPersona extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldDni;
	private JTextField textFieldFecha;
	private JTextPane textPane;
	
	public JFrameAnadirPersona(PlanVacunacion plan) {
		
		final PlanVacunacion planVacunacion = plan;
		
		setTitle("Añadir persona");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblAnadirPersona = new JLabel("Añadir persona");
		lblAnadirPersona.setFont(new Font(null, Font.PLAIN, 16));
		lblAnadirPersona.setBounds(90, 20, 180, 30);
		contentPane.add(lblAnadirPersona);
		
		JLabel lblDni= new JLabel("Dni: ");
		lblDni.setBounds(6, 60, 150, 30);
		contentPane.add(lblDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(6, 90, 134, 28);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(160, 60, 150, 30);
		contentPane.add(lblFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(160, 90, 134, 28);
		contentPane.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JButton btnlRegistrarPersona = new JButton("Añadir");
		btnlRegistrarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean registrado = false;
				
				try {
					registrado = GestorPlanPersona.anadirPersona(textFieldDni.getText(), planVacunacion.getID(), textFieldFecha.getText());
				}catch (Exception e) {
					textPane.setText("Ha ocurrido un error, vuelva a intentarlo" + e.toString());
				}
				
				if (registrado) {
					textPane.setText("Persona añadida");
				} else {
					textPane.setText("Ha ocurrido un error durante la inserción");
				}
			}
		});
		
		btnlRegistrarPersona.setBounds(90, 320, 120, 30);
		contentPane.add(btnlRegistrarPersona);
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el resultado de la comprobaci\u00F3n de buscar contenido o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 370, 407, 30);
		contentPane.add(textPane);
		
	}
}
