package presentacion;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Enfermedad;
import dominio.Medicina;
import dominio.Sintoma;
import dominio.Vacuna;

public class JFrameDetallesEnfermedad extends JFrame {
	
	private JPanel contentPane;
	private JTextPane textPane1 = new JTextPane();
	private JTextPane textPane2 = new JTextPane();
	private JTextPane textPane3 = new JTextPane();
	private DefaultTableModel model;
	private JTable table;
	
	public JFrameDetallesEnfermedad(ArrayList<Vacuna> vacunas, ArrayList<Medicina> medicinas, ArrayList<Sintoma> sintomas, Enfermedad enfermedadEncontrada) {
		setTitle(enfermedadEncontrada.getNombre());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnfermedad= new JLabel("Detalles de " + enfermedadEncontrada.getNombre());
		lblEnfermedad.setFont(new Font(null, Font.PLAIN, 16));
		lblEnfermedad.setBounds(130, 10, 180, 30);
		contentPane.add(lblEnfermedad);
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setBounds(6, 50, 150, 30);
		contentPane.add(lblDescripcion);
		
		textPane1.setText(enfermedadEncontrada.getDescripcion());
		textPane1.setToolTipText("Mostrar descripcion de la enfermedad");
		textPane1.setEditable(false);
		float number = (float) enfermedadEncontrada.getDescripcion().length()/70;
		int dimy = (int) (20*(Math.ceil(number)));
		textPane1.setBounds(6, 80, 407, dimy);
		contentPane.add(textPane1);
		
		JLabel lblTemporalidad = new JLabel("Temporalidad: ");
		lblTemporalidad.setBounds(6, dimy+80, 150, 30);
		contentPane.add(lblTemporalidad);

		String temporalidad = (enfermedadEncontrada.getTemporalidad() == -1) ? "Indefinida" : enfermedadEncontrada.getTemporalidad() + " dias (media)";
		JLabel lblTextTemporalidad = new JLabel(temporalidad);
		lblTextTemporalidad.setBounds(100, dimy+80, 150, 30);
		contentPane.add(lblTextTemporalidad);
		
		JLabel lblMedicinas= new JLabel("Medicinas: ");
		lblMedicinas.setBounds(6, dimy+110, 150, 30);
		contentPane.add(lblMedicinas);
		
		if (medicinas.size() != 0) {
			String cadena = "";
			for (int i = 0; i < medicinas.size(); i++) {
				if (medicinas.size()-1 == i) {
					cadena += medicinas.get(i).getNombre();
				} else {
					cadena+= medicinas.get(i).getNombre() + ",";
				}
			}
			textPane2.setText(cadena);
			textPane2.setToolTipText("Mostrar medicinas para la enfermedad");
			textPane2.setEditable(false);
			textPane2.setBounds(6, dimy+140, 407, 30);
			contentPane.add(textPane2);
		} else {
			textPane2.setText("No existen medicinas para esta enfermedad");
			textPane2.setToolTipText("Mostrar medicinas para la enfermedad");
			textPane2.setEditable(false);
			textPane2.setBounds(6, dimy+140, 407, 30);
			contentPane.add(textPane2);
		}
		
		JLabel lblSintomas= new JLabel("Sintomas: ");
		lblSintomas.setBounds(6, dimy+170, 150, 30);
		contentPane.add(lblSintomas);
		
		if (sintomas.size() != 0) {
			String cadena = "";
			for (int i = 0; i < sintomas.size(); i++) {
				if (sintomas.size()-1 == i) {
					cadena += sintomas.get(i).getNombre();
				} else {
					cadena+= sintomas.get(i).getNombre() + ",";
				}
			}
			textPane3.setText(cadena);
			textPane3.setToolTipText("Mostrar sintomas de la enfermedad");
			textPane3.setEditable(false);
			textPane3.setBounds(6, dimy+200, 407, 30);
			contentPane.add(textPane3);
		} else {
			textPane3.setText("No existen sintomas para esta enfermedad");
			textPane3.setToolTipText("Mostrar sintomas de la enfermedad");
			textPane3.setEditable(false);
			textPane3.setBounds(6, dimy+200, 407, 30);
			contentPane.add(textPane3);
		}
		
		JLabel lblVacunas= new JLabel("Vacunas: ");
		lblVacunas.setBounds(6, dimy+230, 150, 30);
		contentPane.add(lblVacunas);
		
		if (vacunas.size() != 0) {

			ArrayList<String> nombreVacuna =new ArrayList<String>(); 
			ArrayList<String> numDosis = new ArrayList<String>();
			
			String [] columnas = {"Nombre","Numero dosis"};
			String [][] datos = new String[vacunas.size()][2];
			
			for (int i = 0; i < vacunas.size(); i++) {
				nombreVacuna.add(vacunas.get(i).getNombre());
				numDosis.add(vacunas.get(i).getNumDosis()+"");
			}
			
			for (int i = 0; i < datos.length; i++) {
				datos[i][0] = nombreVacuna.get(i);
				datos[i][1] = numDosis.get(i);
			}
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, dimy+260, 407, 60);
			getContentPane().add(scrollPane);
			table = new JTable(datos, columnas);
			model = new DefaultTableModel(datos, columnas);
			scrollPane.setViewportView(table);
		} else {
			JLabel lblNoVacunas= new JLabel("No existen vacunas para esta enfermedad");
			lblNoVacunas.setBounds(70, dimy+230, 280, 30);
			contentPane.add(lblNoVacunas);
		}
		

		
	}
}
