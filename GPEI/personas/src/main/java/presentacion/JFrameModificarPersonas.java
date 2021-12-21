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

import dominio.GestorPersona;
import dominio.GestorPersona;
import dominio.Persona;

public class JFrameModificarPersonas extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JTextField textFieldFechaNacimiento;
	JComboBox<String> cbSexo;
	JComboBox<String> cbEstado;
	JComboBox<String> cbVulnerabilidad;
	private JTextPane textPane;
	
	public JFrameModificarPersonas(final Persona persona) {
		setTitle("Modificar personas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblModificarPersona = new JLabel("Modificar personas");
		lblModificarPersona.setFont(new Font(null, Font.PLAIN, 16));
		lblModificarPersona.setBounds(90, 20, 180, 30);
		contentPane.add(lblModificarPersona);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(6, 120, 150, 30);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(6, 150, 134, 28);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido1 = new JLabel("Apellido 1: ");
		lblApellido1.setBounds(6, 180, 150, 30);
		contentPane.add(lblApellido1);
		
		textFieldApellido1 = new JTextField();
		textFieldApellido1.setBounds(6, 210, 134, 28);
		contentPane.add(textFieldApellido1);
		textFieldApellido1.setColumns(10);
		
		JLabel lblApellido2 = new JLabel("Apellido 2: ");
		lblApellido2.setBounds(6, 240, 150, 30);
		contentPane.add(lblApellido2);
		
		textFieldApellido2 = new JTextField();
		textFieldApellido2.setBounds(6, 270, 134, 28);
		contentPane.add(textFieldApellido2);
		textFieldApellido2.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(160, 120, 150, 30);
		contentPane.add(lblSexo);
		
		cbSexo =new JComboBox<String>();
		cbSexo.addItem("Masculino");
        cbSexo.addItem("Femenino");
        cbSexo.addItem("Otro");
        cbSexo.setBounds(160, 150, 134, 28);
        contentPane.add(cbSexo);
        
		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setBounds(160, 180, 150, 30);
		contentPane.add(lblEstado	);
		
		cbEstado =new JComboBox<String>();
		cbEstado.addItem("SANO");
		cbEstado.addItem("SANO_CONFINADO");
		cbEstado.addItem("ENFERMO");
		cbEstado.addItem("ENFERMO_CONFINADO");
		cbEstado.setBounds(160, 210, 134, 28);
		contentPane.add(cbEstado);
        
		JLabel lblVulnerabilidad = new JLabel("Vulnerabilidad: ");
		lblVulnerabilidad.setBounds(160, 240, 150, 30);
		contentPane.add(lblVulnerabilidad	);
		
		cbVulnerabilidad =new JComboBox<String>();
		cbVulnerabilidad.addItem("BAJA");
		cbVulnerabilidad.addItem("MEDIA");
		cbVulnerabilidad.addItem("ALTA");
		cbVulnerabilidad.addItem("CRITICA");
		cbVulnerabilidad.setBounds(160, 270, 134, 28);
		contentPane.add(cbVulnerabilidad);
		
		JButton btnlModificarPersona = new JButton("Modificar");
		btnlModificarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int modificado = -1;
				String tmpNombre = "", tmpApellido1 = "", tmpApellido2 = "", tmpSexo = String.valueOf(cbSexo.getSelectedItem()), tmpEstado = String.valueOf(cbEstado.getSelectedItem()), tmpVulnerabilidad = String.valueOf(cbVulnerabilidad.getSelectedItem());
				
				if(textFieldNombre.getText().equals("")) tmpNombre = persona.getNombre();
				else tmpNombre = textFieldNombre.getText();
				if(textFieldApellido1.getText().equals("")) tmpApellido1 = persona.getApellido1();
				else textFieldApellido1.getText();
				if(textFieldApellido2.getText().equals("")) tmpApellido2 = persona.getApellido2();
				else textFieldApellido2.getText();
				
				try {
					modificado = GestorPersona.modificarPersona(persona.getDni(), tmpNombre, tmpApellido1, tmpApellido2, tmpSexo, tmpEstado, tmpVulnerabilidad);
				}catch (Exception e) {
					textPane.setText("Ha ocurrido un error, vuelva a intentarlo" + e.toString());
				}
				
				if (modificado != -1) {
					textPane.setText("Persona modificada");
				} else {
					textPane.setText("Ha ocurrido un error durante la modificación");
				}
			}
		});
		
		btnlModificarPersona.setBounds(90, 320, 120, 30);
		contentPane.add(btnlModificarPersona);
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el resultado de la comprobaci\u00F3n de buscar contenido o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 370, 407, 30);
		contentPane.add(textPane);
		
	}
}
