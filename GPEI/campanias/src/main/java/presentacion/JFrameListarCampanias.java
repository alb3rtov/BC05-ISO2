package presentacion;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Campania;
import dominio.GestorCampanias;
import dominio.GestorEnfermedades;

public class JFrameListarCampanias extends JFrame {
	
	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	
	ArrayList<Campania> campaniasEncontradas =  new ArrayList<Campania>();
	
	public JFrameListarCampanias() {
		setTitle("Listar campa\u00f1as");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarEnfermedad = new JLabel("Listar campa\u00f1as");
		lblRegistrarEnfermedad.setFont(new Font(null, Font.PLAIN, 16));
		lblRegistrarEnfermedad.setBounds(180, 10, 180, 30);
		contentPane.add(lblRegistrarEnfermedad);
		
		try {
			campaniasEncontradas = GestorCampanias.buscarCampanias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> inicioFechas = new ArrayList<String>();
		ArrayList<String> finFechas = new ArrayList<String>();
		ArrayList<Float> costes = new ArrayList<Float>();
		ArrayList<Float> efectividades = new ArrayList<Float>();
		ArrayList<String> enfermedades = new ArrayList<String>();
		
		String [] columnas = {"Fecha inicio","Fecha fin","Coste (€)","Efectividad (%)", "Enfermedad"};
		String [][] datos = new String[campaniasEncontradas.size()][5];
		
		for (int i = 0; i < campaniasEncontradas.size(); i++) {
			inicioFechas.add(campaniasEncontradas.get(i).getFechaInicio());
			finFechas.add(campaniasEncontradas.get(i).getFechaFin());
			costes.add(campaniasEncontradas.get(i).getCoste());
			efectividades.add(campaniasEncontradas.get(i).getEfectividad());
			enfermedades.add(campaniasEncontradas.get(i).getEnfermedad());
		}
		
		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = inicioFechas.get(i);
			datos[i][1] = finFechas.get(i);
			datos[i][2] = costes.get(i) + "";
			datos[i][3] = efectividades.get(i) + "";
			datos[i][4] = enfermedades.get(i);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 447, 150);
		getContentPane().add(scrollPane);
		table = new JTable(datos, columnas);
		model = new DefaultTableModel(datos, columnas);
		scrollPane.setViewportView(table);
		table.setRowSelectionInterval(0, 0);
	}
}
