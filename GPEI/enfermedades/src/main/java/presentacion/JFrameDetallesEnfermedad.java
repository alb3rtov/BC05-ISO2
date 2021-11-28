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
import dominio.Vacuna;

public class JFrameDetallesEnfermedad extends JFrame {
	
	private JPanel contentPane;
	private JTextPane textPane = new JTextPane();;
	private DefaultTableModel model;
	private JTable table;
	
	public JFrameDetallesEnfermedad(ArrayList<Vacuna> vacunas, Enfermedad enfermedadEncontrada) {
		setTitle(enfermedadEncontrada.getNombre());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 385);
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
		
		textPane.setText(enfermedadEncontrada.getDescripcion());
		textPane.setToolTipText("Mostrar descripcion de la enfermedad");
		textPane.setEditable(false);
		float number = (float) enfermedadEncontrada.getDescripcion().length()/70;
		int dimy = (int) (20*(Math.ceil(number)));
		textPane.setBounds(6, 80, 407, dimy);
		contentPane.add(textPane);
		
		JLabel lblTemporalidad = new JLabel("Temporalidad: ");
		lblTemporalidad.setBounds(6, dimy+80, 150, 30);
		contentPane.add(lblTemporalidad);

		String temporalidad = (enfermedadEncontrada.getTemporalidad() == -1) ? "Indefinida" : enfermedadEncontrada.getTemporalidad() + " dias (media)";
		JLabel lblTextTemporalidad = new JLabel(temporalidad);
		lblTextTemporalidad.setBounds(100, dimy+80, 150, 30);
		contentPane.add(lblTextTemporalidad);
		
		JLabel lblVacunas= new JLabel("Vacunas: ");
		lblVacunas.setBounds(6, dimy+110, 150, 30);
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
			scrollPane.setBounds(10, dimy+140, 407, 80);
			getContentPane().add(scrollPane);
			table = new JTable(datos, columnas);
			model = new DefaultTableModel(datos, columnas);
			scrollPane.setViewportView(table);
		} else {
			JLabel lblNoVacunas= new JLabel("No existen vacunas para esta enfermedad");
			lblNoVacunas.setBounds(70, dimy+110, 280, 30);
			contentPane.add(lblNoVacunas);
		}	
	}
}
