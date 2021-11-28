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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Enfermedad;
import dominio.GestorEnfermedades;
import dominio.Medicina;
import dominio.Vacuna;

public class JFrameBuscarEnfermedades extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextPane textPane;
	private DefaultTableModel model;
	private JTable table;
	ArrayList<Enfermedad> enfermedadesEncontradas =  new ArrayList<Enfermedad>();
	
	public JFrameBuscarEnfermedades() {
		setTitle("Buscar enfermedades");
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
		
		final JButton btnAbrirDetalles = new JButton("Abrir detalles");
		btnAbrirDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRowCount() == 1) {
					Enfermedad enfermedadEncontrada = null;
					try {
						for (int i = 0; i < enfermedadesEncontradas.size(); i++) {
							if (enfermedadesEncontradas.get(i).getNombre() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
								enfermedadEncontrada = enfermedadesEncontradas.get(i);
								break;
							}
						}
						
						ArrayList<Vacuna> vacunas = new ArrayList<Vacuna>();
						vacunas = GestorEnfermedades.buscarVacuna(enfermedadEncontrada.getNombre());
						ArrayList<Medicina> medicinas = new ArrayList<Medicina>();
						medicinas = GestorEnfermedades.buscarMedicina(enfermedadEncontrada.getNombre());
						JFrameDetallesEnfermedad frame = new JFrameDetallesEnfermedad(vacunas,medicinas,enfermedadEncontrada);
						frame.setVisible(true);
					
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					textPane.setText("Para abrir detalles selecciona una única fila");
				}
				
			}
		});
		
		JButton btnlBuscarEnfermedad = new JButton("Buscar");
		btnlBuscarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (textFieldNombre.getText().length() != 0) { 
					try {
						ArrayList<String> enfermedades = new ArrayList<String>();
						ArrayList<String> descripciones = new ArrayList<String>();
						ArrayList<String> temporalidades = new ArrayList<String>();

						enfermedadesEncontradas = GestorEnfermedades.buscarEnfermedad(textFieldNombre.getText());


						if (enfermedadesEncontradas.size() == 0) {
							textPane.setText("No se han encontrado resultados");
						} else {
							
							textPane.setText("Resultados encontrados");
							String [] columnas = {"Nombre","Descripcion","Temporalidad"};
							String [][] datos = new String[enfermedadesEncontradas.size()][3];
							
							for (int i = 0; i < enfermedadesEncontradas.size(); i++) {
								enfermedades.add(enfermedadesEncontradas.get(i).getNombre());
								descripciones.add(enfermedadesEncontradas.get(i).getDescripcion());
								
								if (enfermedadesEncontradas.get(i).getTemporalidad() == -1) {
									temporalidades.add("Indefinido");
								} else {
									temporalidades.add(enfermedadesEncontradas.get(i).getTemporalidad() + " días");
								}
							}
						
							for (int i = 0; i < datos.length; i++) {
								datos[i][0] = enfermedades.get(i);
								datos[i][1] = descripciones.get(i);
								datos[i][2] = temporalidades.get(i);
							}
							
							JScrollPane scrollPane = new JScrollPane();
							scrollPane.setBounds(10, 140, 407, 120);
							getContentPane().add(scrollPane);
							table = new JTable(datos, columnas);
							model = new DefaultTableModel(datos, columnas);
							scrollPane.setViewportView(table);
							table.setRowSelectionInterval(0, 0);
							btnAbrirDetalles.setVisible(true);
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
		textPane.setBounds(6, 100, 407, 25);
		contentPane.add(textPane);
		
		btnAbrirDetalles.setBounds(150, 270, 120, 30);
		btnAbrirDetalles.setVisible(false);
		contentPane.add(btnAbrirDetalles);
	}

}
