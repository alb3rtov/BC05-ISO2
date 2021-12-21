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

public class JFrameRegistrarPersonas extends JFrame {
	
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
	
	public JFrameRegistrarPersonas() {
		setTitle("Registrar personas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblRegistrarPersona = new JLabel("Registrar personas");
		lblRegistrarPersona.setFont(new Font(null, Font.PLAIN, 16));
		lblRegistrarPersona.setBounds(90, 20, 180, 30);
		contentPane.add(lblRegistrarPersona);
		
		JLabel lblDni= new JLabel("Dni: ");
		lblDni.setBounds(6, 60, 150, 30);
		contentPane.add(lblDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(6, 90, 134, 28);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
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
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento: ");
		lblFechaNacimiento.setBounds(160, 60, 150, 30);
		contentPane.add(lblFechaNacimiento	);
		
		textFieldFechaNacimiento = new JTextField();
		textFieldFechaNacimiento.setBounds(160, 90, 134, 28);
		contentPane.add(textFieldFechaNacimiento);
		textFieldFechaNacimiento.setColumns(10);
		
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
		
		JButton btnlRegistrarPersona = new JButton("Registrar");
		btnlRegistrarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean registrado = false;
				
				try {
					//System.out.println(String.valueOf(cbVulnerabilidad.getSelectedItem()));
					registrado = GestorPersona.registrarPersona(textFieldDni.getText(), textFieldNombre.getText(), textFieldApellido1.getText(), textFieldApellido2.getText(), String.valueOf(cbSexo.getSelectedItem()), textFieldFechaNacimiento.getText(), String.valueOf(cbEstado.getSelectedItem()), String.valueOf(cbVulnerabilidad.getSelectedItem()));
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
