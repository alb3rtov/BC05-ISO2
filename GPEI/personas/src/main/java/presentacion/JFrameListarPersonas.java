package presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.GestorPersona;
import dominio.Persona;

public class JFrameListarPersonas extends JFrame {
	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	
	ArrayList<Persona> personasEncontradas =  new ArrayList<Persona>();
	
	public JFrameListarPersonas() {
		setTitle("Listar personas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPersonas = new JLabel("Listar personas");
		lblPersonas.setFont(new Font(null, Font.PLAIN, 16));
		lblPersonas.setBounds(180, 10, 180, 30);
		contentPane.add(lblPersonas);
		
		try {
			personasEncontradas = GestorPersona.buscarPersonas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<String> dnis = new ArrayList<String>();
		ArrayList<String> nombres = new ArrayList<String>();
		ArrayList<String> apellidos1 = new ArrayList<String>();
		ArrayList<String> apellidos2 = new ArrayList<String>();
		ArrayList<String> sexos = new ArrayList<String>();
		ArrayList<String> fechasNacimientos = new ArrayList<String>();
		ArrayList<String> estados = new ArrayList<String>();
		ArrayList<String> vulnerabilidades = new ArrayList<String>();
	
		String [] columnas = {"Dni","Nombre","Apellido 1","Apellido 2", "Sexo", "Fecha nacimiento", "Estado", "Vulnerabilidad"};
		String [][] datos = new String[personasEncontradas.size()][8];
		
		for (int i = 0; i < personasEncontradas.size(); i++) {
			dnis.add(personasEncontradas.get(i).getDni());
			nombres.add(personasEncontradas.get(i).getNombre());
			apellidos1.add(personasEncontradas.get(i).getApellido1());
			apellidos2.add(personasEncontradas.get(i).getApellido2());
			sexos.add(personasEncontradas.get(i).getSexo());
			fechasNacimientos.add(personasEncontradas.get(i).getFechaNacimiento());
			estados.add(personasEncontradas.get(i).getEstado());
			vulnerabilidades.add(personasEncontradas.get(i).getVulnerabilidad());
		}
		
		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = dnis.get(i);
			datos[i][1] = nombres.get(i);
			datos[i][2] = apellidos1.get(i);
			datos[i][3] = apellidos2.get(i);
			datos[i][4] = sexos.get(i);
			datos[i][5] = fechasNacimientos.get(i);
			datos[i][6] = estados.get(i);
			datos[i][7] = vulnerabilidades.get(i);	
		}
		
		//Modificar persona
		final JButton btnModificarEnfermedad = new JButton("Modificar");
		btnModificarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRowCount() == 1) {
					Persona personaEncontrada = null;
					try {
						for (int i = 0; i < personasEncontradas.size(); i++) {
							if (personasEncontradas.get(i).getDni() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
								personaEncontrada = personasEncontradas.get(i);
								break;
							}
						}
						
						JFrameModificarPersonas frame = new JFrameModificarPersonas(personaEncontrada);
						frame.setVisible(true);
					
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} //else {
					//textPane.setText("Para abrir detalles selecciona una única fila");
				//}
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 480, 150);
		getContentPane().add(scrollPane);
		table = new JTable(datos, columnas);
		model = new DefaultTableModel(datos, columnas);
		scrollPane.setViewportView(table);
		table.setRowSelectionInterval(0, 0);
		
		btnModificarEnfermedad.setBounds(150, 270, 124, 30);
		btnModificarEnfermedad.setVisible(true);
		contentPane.add(btnModificarEnfermedad);
	}
}
